# SaaSus Java SDK — E2E Story Tests

Story-based end-to-end tests that exercise every generated SDK method across all four call styles
(`NORMAL`, `WITH_HTTP_INFO`, `ASYNC`, `CALL`) against the live SaaSus API. The flows mirror the
`saasus-sdk-go` E2E stories, which are themselves derived from the Postman collections in
`saasus-dev-env/api/test/tests`.

Modules covered here: **auth**, **communication**, **integration** (this change), alongside the
existing **pricing**, **billing**, **apilog** suites. Each module lives under
`src/test/java/saasus/sdk/e2e/<module>/` with four files:

| File | Responsibility |
|------|----------------|
| `<Module>ApiE2ETest` | JUnit entry point: builds the client, registry and engine, runs the stories, asserts all pass and that `(method, style)` coverage is complete. |
| `<Module>Stories` | Story definitions. Each Postman flow is replicated once per `CallStyle`. |
| `<Module>Invokers` | Registers every SDK method against the four call styles (async/call are signed manually via `Utils.withSaasusSigV1`). |
| `<Module>Params` | Request-body builders and response → story-variable extraction. |

## Running

E2E tests are excluded from `mvn test` (they need live credentials) and run only via the `e2e`
profile:

```bash
# All modules
mvn verify -Pe2e

# A single module
mvn verify -Pe2e -Dit.test=AuthApiE2ETest
mvn verify -Pe2e -Dit.test=CommunicationApiE2ETest
mvn verify -Pe2e -Dit.test=IntegrationApiE2ETest

# Dry run (no network / credentials): validates wiring and coverage completeness only
mvn verify -Pe2e -Dtestlib.args=--dry-run -DfailIfNoTests=false
```

Pure unit tests (including the SRP-6a helper `SrpTest`) run under the normal phase:

```bash
mvn test
```

## Required environment variables

Always required (these **must be exported into the Maven process environment**, not merely placed in
a `.env` file — `Config.fromEnv()` reads `.env` for validation, but the request signer
`Utils.withSaasusSigV1()` reads them directly via `System.getenv()`, so a `.env`-only setup passes
validation yet fails to sign every live request):

```bash
export SAASUS_SAAS_ID=...
export SAASUS_API_KEY=...
export SAASUS_SECRET_KEY=...
```

Optional / per-module:

```bash
# communication
TEST_USER_ID=<uuid>              # default 00000000-0000-0000-0000-000000000000

# integration (EventBridge)
TEST_AWS_ACCOUNT_ID=267185063265 # default
TEST_AWS_REGION=ap-northeast-1   # default

# auth
TEST_TENANT_ID=<tenant-uuid>     # existing tenant for tenant-scoped endpoints
TEST_ENV_ID=3                    # env id used for roles/invitations (default 3)
TEST_PROVIDER_NAME=google        # default, used by unlink/provider endpoints
TEST_DOMAIN_NAME / TEST_FROM_EMAIL / TEST_BACK_OFFICE_EMAIL  # optional overrides
STRIPE_SECRET_KEY=sk_test_...    # enables the Stripe integration steps (skipped when unset)
```

Snapshot capture/compare (optional, shared with the other modules) is toggled with the
`E2E_SNAPSHOT_*` variables; output is written under `tests/e2e/snapshot/<module>/`.

## Module notes

### communication
Reproduces the Postman `feedbacks-comments-votes-create-update-delete-ok` lifecycle (create → update
→ status → comment → vote → delete). 12 methods × 4 styles = 48 `(method, style)` pairs.

### integration (EventBridge)
Merges the Postman `eventbridge-settings` and `eventbridge-events` folders into one lifecycle
(get → save → get → delete → get → save → test-event → send-event → cleanup). `CreateEventBridgeEvent`
expects **501 Not Implemented** (endpoint not implemented server-side, matching the Go reference).
5 methods × 4 styles = 20 pairs.

### auth
93 base methods across 13 API classes (× 4 styles = 372 pairs; the `ReturnInternalServerError`
debug endpoint is excluded, matching the Go reference). Following the Go reference, the Stripe
integration steps (`createTenantAndPricing` = `PATCH /stripe/init`, `deleteStripeTenantAndPricing` =
`DELETE /stripe`, `getStripeCustomer`) are **skipped at runtime unless `STRIPE_SECRET_KEY` is set**
(they still count towards coverage, as in Go's static `VerifyMethodCoverage`), while the SaaS-global
`resetPlan` (`PUT /plans/reset`) and `updateIdentityProvider` run unconditionally. Because those
last two are unscoped and cannot be snapshot-restored, **this suite expects a dedicated (disposable)
test SaaS**, exactly like the Go E2E suite. Stories:

- **Auth Postman mega-flow** — walks every auth category so the four call-style variants together
  cover the full method universe. Environment-dependent / non-idempotent endpoints (Stripe/pricing,
  AWS Marketplace, device/MFA, external-link and email-update confirmation, DNS/SES-gated
  invitations, SRP sign-in) use `allowedStatuses` covering their realistic outcomes rather than
  being skipped, so coverage is preserved while remaining resilient across environments.
- **SaaS user attributes**, **external link & email update**, **sign-up & provider management** —
  faithful ports of the Go feature stories.
- **SRP sign-in** (`sign-in-ok`) and **tenant invitations** (`invitations-ok`) — **new** flows not
  present in the Go tests. Both perform a real client-side SRP-6a `USER_SRP_AUTH` /
  `PASSWORD_VERIFIER` sign-in (see `support/Srp.java`) to obtain an access token, with no AWS SDK
  dependency.

Safety: tenant mutations never touch the configured tenant — `deleteTenant`, `updateTenant`,
`updateTenantBillingInfo`, `updateTenantPlan` and `updateTenantIdentityProvider` only target a tenant
created within the flow (otherwise a random id that 404s, never `TEST_TENANT_ID`); EnvApi
`getEnv`/`updateEnv`/`deleteEnv` only target an env the flow successfully created (otherwise a
reserved sentinel id that 404s), and the `createEnv` attempt uses a high, unlikely-to-exist id.
However, following the Go reference, the SaaS-global `resetPlan` and `updateIdentityProvider` are run
unconditionally, and the Stripe steps run when `STRIPE_SECRET_KEY` is set — these mutate SaaS-wide
state that cannot be restored, so run this suite only against a dedicated, disposable test SaaS.

#### auth environment caveats
Some auth flows require a fully provisioned environment and **may fail locally by design**:

- `sign-in-ok` needs the created user to be a confirmed Cognito user (permanent password); the SDK's
  `createSaasUser` with email+password satisfies this in a properly configured tenant.
- `invitations-ok` and the email-update request require a **DNS + SES validated** environment;
  `CreateTenantInvitation` is CI-only. The confirmation endpoints (`confirmEmailUpdate`,
  `confirmExternalUserLink`) require a real emailed code and return `401`/`400` in E2E.

## SRP-6a helper

`support/Srp.java` ports the Postman collection's embedded `srpHelper` (Cognito USER_SRP_AUTH):
`g^a mod N`, `u`, `x`, `S`, the 16-byte HKDF, the HMAC signature, and the Cognito timestamp format.
It uses `BigInteger.modPow` and `javax.crypto` (no external crypto dependency). `SrpTest` validates
the primitives with published known-answer vectors (RFC 4231 HMAC-SHA256, FIPS SHA-256), the
`padHex` rule, the `g^a mod N` identity, the timestamp format, HKDF length and end-to-end
determinism. The full Cognito match is exercised live by the `sign-in-ok` story.
