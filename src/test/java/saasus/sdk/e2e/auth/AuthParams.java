package saasus.sdk.e2e.auth;

import saasus.sdk.auth.models.AuthInfo;
import saasus.sdk.auth.models.Attribute;
import saasus.sdk.auth.models.BillingInfo;
import saasus.sdk.auth.models.ConfirmDeviceParam;
import saasus.sdk.auth.models.ConfirmEmailUpdateParam;
import saasus.sdk.auth.models.ConfirmExternalUserLinkParam;
import saasus.sdk.auth.models.ConfirmSignUpWithAwsMarketplaceParam;
import saasus.sdk.auth.models.CreateSaasUserParam;
import saasus.sdk.auth.models.CreateSecretCodeParam;
import saasus.sdk.auth.models.CreateTenantInvitationParam;
import saasus.sdk.auth.models.CreateTenantUserParam;
import saasus.sdk.auth.models.CreateTenantUserRolesParam;
import saasus.sdk.auth.models.Credentials;
import saasus.sdk.auth.models.Env;
import saasus.sdk.auth.models.LinkAwsMarketplaceParam;
import saasus.sdk.auth.models.MfaPreference;
import saasus.sdk.auth.models.PlanReservation;
import saasus.sdk.auth.models.RequestEmailUpdateParam;
import saasus.sdk.auth.models.RequestExternalUserLinkParam;
import saasus.sdk.auth.models.ResendSignUpConfirmationEmailParam;
import saasus.sdk.auth.models.RespondToSignInChallengeParam;
import saasus.sdk.auth.models.RespondToSignInChallengeResult;
import saasus.sdk.auth.models.Role;
import saasus.sdk.auth.models.SignInParam;
import saasus.sdk.auth.models.SignInResult;
import saasus.sdk.auth.models.SignUpParam;
import saasus.sdk.auth.models.SignUpWithAwsMarketplaceParam;
import saasus.sdk.auth.models.TenantProps;
import saasus.sdk.auth.models.UpdateBasicInfoParam;
import saasus.sdk.auth.models.UpdateCustomizePageSettingsParam;
import saasus.sdk.auth.models.UpdateCustomizePagesParam;
import saasus.sdk.auth.models.UpdateDeviceStatusParam;
import saasus.sdk.auth.models.UpdateEnvParam;
import saasus.sdk.auth.models.UpdateIdentityProviderParam;
import saasus.sdk.auth.models.UpdateNotificationMessagesParam;
import saasus.sdk.auth.models.UpdateRoleParam;
import saasus.sdk.auth.models.UpdateSaasUserAttributesParam;
import saasus.sdk.auth.models.UpdateSaasUserEmailParam;
import saasus.sdk.auth.models.UpdateSaasUserPasswordParam;
import saasus.sdk.auth.models.UpdateSaasUserSignInIdParam;
import saasus.sdk.auth.models.UpdateSignInSettingsParam;
import saasus.sdk.auth.models.UpdateSingleTenantSettingsParam;
import saasus.sdk.auth.models.UpdateSoftwareTokenParam;
import saasus.sdk.auth.models.UpdateTenantIdentityProviderParam;
import saasus.sdk.auth.models.UpdateTenantUserParam;
import saasus.sdk.auth.models.ValidateInvitationParam;
import saasus.sdk.e2e.auth.support.Srp;

import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Parameter builders, path-parameter resolvers and response extraction for auth E2E stories.
 *
 * <p>Request bodies are constructed with each model's generated {@code fromJson(String)} so the
 * JSON mirrors the Postman collection / Go reference bodies exactly, without depending on the
 * exact generated setter names. Path parameters and dynamic values are read from the story
 * variables (seeded by {@code seed*} helpers or captured by {@code extract*} state updates), with
 * environment-backed fallbacks for existing-resource prerequisites (tenant id, provider, tokens).
 */
final class AuthParams {

    private static final AtomicLong COUNTER = new AtomicLong();

    private AuthParams() {
    }

    // ---- unique names / seeding -------------------------------------------------

    static void seed(Map<String, Object> vars) {
        long n = COUNTER.incrementAndGet();
        String suffix = System.currentTimeMillis() + "_" + n;
        vars.putIfAbsent("role_name", "e2e_role_" + suffix);
        vars.putIfAbsent("user_attribute_name", "e2e_user_attr_" + suffix);
        // SaaS-user attributes have no delete endpoint, so a unique name would accumulate a new
        // schema entry on every run. Reuse a stable name instead: createSaasUserAttribute is keyed
        // by attribute_name (201 on repeat), so re-runs upsert the same definition rather than
        // adding more. User/tenant attributes below stay unique because the flow deletes them.
        vars.putIfAbsent("saas_user_attribute_name", "e2e_saas_user_attr");
        vars.putIfAbsent("tenant_attribute_name", "e2e_tenant_attr_" + suffix);
        vars.putIfAbsent("env_id", envIdDefault());
        // A high, unlikely-to-exist id for EnvApi CRUD so the flow never mutates a real
        // environment (id 3 etc.); create/get/update/delete all target this same id.
        vars.putIfAbsent("crud_env_id", 900000 + (int) (n % 90000));
        vars.putIfAbsent("env_name", "e2e_env_" + suffix);
        vars.putIfAbsent("email", "e2e-" + suffix + "@example.com");
        // sign_in_id must contain only alphanumeric characters, underscores and hyphens (no '@'/'.'),
        // so it cannot fall back to the email.
        vars.putIfAbsent("sign_in_id", "e2e_signin_" + suffix);
        vars.putIfAbsent("new_email", "e2e-new-" + suffix + "@example.com");
        vars.putIfAbsent("invitee_email", "e2e-invitee-" + suffix + "@example.com");
        vars.putIfAbsent("password", "Test-Passw0rd-1!");
    }

    static void extractInvitationId(Object response, Map<String, Object> vars) {
        putId(response, vars, "invitation_id");
    }

    /** Captures the first tenant id from a {@code getTenants} response into {@code tenant_id}. */
    static void extractFirstTenantId(Object response, Map<String, Object> vars) {
        if (response == null) {
            return;
        }
        // Respect an explicitly configured tenant: never override TEST_TENANT_ID with an arbitrary
        // first tenant, so the flow operates on the intended test tenant.
        if (!env("TEST_TENANT_ID", "").isEmpty()) {
            return;
        }
        try {
            Object list = response.getClass().getMethod("getTenants").invoke(response);
            if (list instanceof java.util.List && !((java.util.List<?>) list).isEmpty()) {
                Object first = ((java.util.List<?>) list).get(0);
                Object id = first.getClass().getMethod("getId").invoke(first);
                if (id != null && !id.toString().isEmpty()) {
                    vars.put("tenant_id", id.toString());
                }
            }
        } catch (Exception ignored) {
            // leave tenant_id to the TEST_TENANT_ID fallback
        }
    }

    /** Env id used only for the {@code createEnv} attempt (kept away from real environments). */
    static Integer crudEnvId(Map<String, Object> vars) {
        Object v = vars.get("crud_env_id");
        if (v instanceof Number) {
            return ((Number) v).intValue();
        }
        if (v != null && !v.toString().isEmpty()) {
            return Integer.valueOf(v.toString());
        }
        return 900001;
    }

    /** {@link StateUpdate} for {@code createEnv}: records the id of the env the flow actually created. */
    static void extractCreatedEnvId(Object response, Map<String, Object> vars) {
        if (response == null) {
            return;
        }
        try {
            Object id = response.getClass().getMethod("getId").invoke(response);
            if (id != null) {
                vars.put("created_env_id", id);
            }
        } catch (Exception ignored) {
            // no id to capture
        }
    }

    /**
     * Env id for {@code getEnv} / {@code updateEnv} / {@code deleteEnv} and cleanup: only the env this
     * flow actually created ({@code created_env_id}, set by {@link #extractCreatedEnvId} on a 2xx
     * create), otherwise a reserved sentinel id that 404s. This guarantees update/delete never mutate
     * an environment the flow did not create — e.g. when {@code createEnv} returned a tolerated 409
     * because an env with the requested id already existed.
     */
    static Integer operableEnvId(Map<String, Object> vars) {
        Object v = vars.get("created_env_id");
        if (v instanceof Number) {
            return ((Number) v).intValue();
        }
        if (v != null && !v.toString().isEmpty()) {
            return Integer.valueOf(v.toString());
        }
        return 2_000_000_000;
    }

    /**
     * Tenant id for {@code deleteTenant}: only a tenant this flow created ({@code created_tenant_id}),
     * otherwise a random UUID that safely 404s — never the configured {@code TEST_TENANT_ID}, so a
     * real tenant is never deleted.
     */
    static String deletableTenantId(Map<String, Object> vars) {
        Object v = vars.get("created_tenant_id");
        if (v != null && !v.toString().isEmpty()) {
            return v.toString();
        }
        return java.util.UUID.randomUUID().toString();
    }

    /**
     * Tenant id for mutating tenant operations ({@code updateTenant} / {@code updateTenantBillingInfo}
     * / {@code updateTenantPlan}): only a tenant this flow created ({@code created_tenant_id}),
     * otherwise a random UUID that safely 404s — never the configured {@code TEST_TENANT_ID}, so a
     * real tenant's name, billing info, or plan is never overwritten with hard-coded E2E values.
     */
    static String mutableTenantId(Map<String, Object> vars) {
        return deletableTenantId(vars);
    }

    static void extractCreatedTenantId(Object response, Map<String, Object> vars) {
        putId(response, vars, "created_tenant_id");
    }

    // ---- environment-backed prerequisites --------------------------------------

    static String tenantId(Map<String, Object> vars) {
        Object v = vars.get("tenant_id");
        if (v != null && !v.toString().isEmpty()) {
            return v.toString();
        }
        return env("TEST_TENANT_ID", "");
    }

    static String providerName(Map<String, Object> vars) {
        Object v = vars.get("provider_name");
        if (v != null && !v.toString().isEmpty()) {
            return v.toString();
        }
        return env("TEST_PROVIDER_NAME", "google");
    }

    static String token(Map<String, Object> vars) {
        Object v = vars.get("access_token");
        return v == null ? env("TEST_ACCESS_TOKEN", "dummy-access-token") : v.toString();
    }

    // ---- path parameters --------------------------------------------------------

    static String userId(Map<String, Object> vars) {
        return require(vars, "user_id");
    }

    static String invitationId(Map<String, Object> vars) {
        Object v = vars.get("invitation_id");
        if (v != null && !v.toString().isEmpty()) {
            return v.toString();
        }
        // No invitation was captured (e.g. DNS/SES-gated createTenantInvitation returned 4xx). Fall
        // back to a random UUID that safely 404s so dependent read/delete steps stay resilient
        // instead of throwing a status-0 "missing variable" error.
        return java.util.UUID.randomUUID().toString();
    }

    static String roleName(Map<String, Object> vars) {
        return require(vars, "role_name");
    }

    static String userAttributeName(Map<String, Object> vars) {
        return require(vars, "user_attribute_name");
    }

    static String tenantAttributeName(Map<String, Object> vars) {
        return require(vars, "tenant_attribute_name");
    }

    static Integer envId(Map<String, Object> vars) {
        Object v = vars.get("env_id");
        if (v instanceof Integer) {
            return (Integer) v;
        }
        if (v instanceof Number) {
            return ((Number) v).intValue();
        }
        if (v != null && !v.toString().isEmpty()) {
            return Integer.valueOf(v.toString());
        }
        return envIdDefault();
    }

    static String email(Map<String, Object> vars) {
        Object v = vars.get("email");
        return v == null ? "e2e@example.com" : v.toString();
    }

    static String signInId(Map<String, Object> vars) {
        Object v = vars.get("sign_in_id");
        return v == null ? email(vars) : v.toString();
    }

    static String code(Map<String, Object> vars) {
        Object v = vars.get("temp_code");
        return v == null ? env("TEST_TEMP_CODE", "dummy-code") : v.toString();
    }

    static String authFlow(Map<String, Object> vars) {
        Object v = vars.get("auth_flow");
        return v == null ? "tempcode" : v.toString();
    }

    static String refreshToken(Map<String, Object> vars) {
        Object v = vars.get("refresh_token");
        return v == null ? "" : v.toString();
    }

    // ---- request bodies (built via generated fromJson) --------------------------

    static CreateSaasUserParam createSaasUserParam(Map<String, Object> vars) {
        return parse(CreateSaasUserParam.class, "{"
                + "\"email\":" + json(email(vars)) + ","
                + "\"password\":" + json(str(vars, "password", "Test-Passw0rd-1!"))
                + "}");
    }

    static SignUpParam signUpParam(Map<String, Object> vars) {
        return parse(SignUpParam.class, "{\"email\":" + json(email(vars)) + "}");
    }

    static ResendSignUpConfirmationEmailParam resendSignUpConfirmationEmailParam(Map<String, Object> vars) {
        return parse(ResendSignUpConfirmationEmailParam.class, "{\"email\":" + json(email(vars)) + "}");
    }

    static SignInParam signInParam(Map<String, Object> vars) {
        // USER_SRP_AUTH; SRP_A is the client public value produced by Srp.init() (seedSrp).
        String srpA = str(vars, "srp_A_hex", "");
        return parse(SignInParam.class, "{"
                + "\"sign_in_flow\":\"USER_SRP_AUTH\","
                + "\"sign_in_parameters\":{\"USERNAME\":" + json(email(vars)) + ",\"SRP_A\":" + json(srpA) + "}"
                + "}");
    }

    /** Seeds a fresh SRP ephemeral key pair (private {@code a} + public {@code A}) for a sign-in flow. */
    static void seedSrp(Map<String, Object> vars) {
        Srp.Init init = Srp.init();
        vars.put("srp_a_hex", init.aHex);
        vars.put("srp_A_hex", init.aHexPublic);
    }

    /**
     * {@link StateUpdate} for the {@code signIn} step: reads the PASSWORD_VERIFIER challenge
     * parameters from the {@link SignInResult} and computes the challenge response fields (username,
     * secret block, signature, timestamp) via {@link Srp}, storing them for
     * {@code respondToSignInChallenge}.
     */
    static void captureSignInChallenge(Object response, Map<String, Object> vars) {
        if (!(response instanceof SignInResult)) {
            return;
        }
        Map<String, String> cp = ((SignInResult) response).getChallengeParameters();
        if (cp == null || cp.isEmpty()) {
            return;
        }
        String aHex = str(vars, "srp_a_hex", "");
        String password = str(vars, "password", "Test-Passw0rd-1!");
        Srp.Challenge challenge = Srp.respond(
                cp.get("POOL_NAME"), cp.get("USER_ID_FOR_SRP"), cp.get("SECRET_BLOCK"),
                cp.get("SRP_B"), cp.get("SALT"), aHex, password,
                Calendar.getInstance(TimeZone.getTimeZone("UTC")));
        vars.put("challenge_username", cp.get("USER_ID_FOR_SRP"));
        vars.put("secret_block", cp.get("SECRET_BLOCK"));
        vars.put("signature", challenge.signature);
        vars.put("timestamp", challenge.timestamp);
        // Preserve the sign-in session so respondToSignInChallenge can be tied to this transaction.
        String session = ((SignInResult) response).getSession();
        if (session != null && !session.isEmpty()) {
            vars.put("session", session);
        }
    }

    /** {@link StateUpdate} for the challenge-response step: captures {@code credentials.access_token}. */
    static void captureAccessToken(Object response, Map<String, Object> vars) {
        if (!(response instanceof RespondToSignInChallengeResult)) {
            return;
        }
        RespondToSignInChallengeResult result = (RespondToSignInChallengeResult) response;
        if (result.getCredentials() != null && result.getCredentials().getAccessToken() != null) {
            vars.put("access_token", result.getCredentials().getAccessToken());
        }
    }

    static RespondToSignInChallengeParam respondToSignInChallengeParam(Map<String, Object> vars) {
        String session = str(vars, "session", "");
        StringBuilder body = new StringBuilder("{"
                + "\"challenge_name\":\"PASSWORD_VERIFIER\","
                + "\"challenge_responses\":{"
                + "\"USERNAME\":" + json(str(vars, "challenge_username", "")) + ","
                + "\"PASSWORD_CLAIM_SECRET_BLOCK\":" + json(str(vars, "secret_block", "")) + ","
                + "\"PASSWORD_CLAIM_SIGNATURE\":" + json(str(vars, "signature", "")) + ","
                + "\"TIMESTAMP\":" + json(str(vars, "timestamp", "")) + "}");
        if (!session.isEmpty()) {
            body.append(",\"session\":").append(json(session));
        }
        body.append("}");
        return parse(RespondToSignInChallengeParam.class, body.toString());
    }

    static UpdateSaasUserPasswordParam updateSaasUserPasswordParam(Map<String, Object> vars) {
        return parse(UpdateSaasUserPasswordParam.class, "{\"password\":" + json(str(vars, "password", "Test-Passw0rd-2!")) + "}");
    }

    static UpdateSaasUserEmailParam updateSaasUserEmailParam(Map<String, Object> vars) {
        return parse(UpdateSaasUserEmailParam.class, "{\"email\":" + json(email(vars)) + "}");
    }

    static UpdateSaasUserSignInIdParam updateSaasUserSignInIdParam(Map<String, Object> vars) {
        return parse(UpdateSaasUserSignInIdParam.class, "{\"sign_in_id\":" + json(signInId(vars)) + "}");
    }

    static UpdateSaasUserAttributesParam updateSaasUserAttributesParam(Map<String, Object> vars) {
        String attr = str(vars, "saas_user_attribute_name", "e2e_saas_user_attr");
        return parse(UpdateSaasUserAttributesParam.class,
                "{\"attributes\":{" + json(attr) + ":\"e2e-value\"}}");
    }

    static RequestEmailUpdateParam requestEmailUpdateParam(Map<String, Object> vars) {
        return parse(RequestEmailUpdateParam.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"email\":" + json(str(vars, "new_email", "e2e-new@example.com"))
                + "}");
    }

    static ConfirmEmailUpdateParam confirmEmailUpdateParam(Map<String, Object> vars) {
        return parse(ConfirmEmailUpdateParam.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"code\":" + json(str(vars, "confirmation_code", "000000"))
                + "}");
    }

    static RequestExternalUserLinkParam requestExternalUserLinkParam(Map<String, Object> vars) {
        return parse(RequestExternalUserLinkParam.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"provider\":" + json(providerName(vars))
                + "}");
    }

    static ConfirmExternalUserLinkParam confirmExternalUserLinkParam(Map<String, Object> vars) {
        return parse(ConfirmExternalUserLinkParam.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"code\":" + json(str(vars, "auth_code", "dummy-auth-code"))
                + "}");
    }

    static CreateSecretCodeParam createSecretCodeParam(Map<String, Object> vars) {
        return parse(CreateSecretCodeParam.class, "{\"access_token\":" + json(token(vars)) + "}");
    }

    static UpdateSoftwareTokenParam updateSoftwareTokenParam(Map<String, Object> vars) {
        return parse(UpdateSoftwareTokenParam.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"verification_code\":" + json(str(vars, "totp_code", "000000"))
                + "}");
    }

    static MfaPreference mfaPreference(Map<String, Object> vars) {
        return parse(MfaPreference.class, "{\"enabled\":true,\"method\":\"SOFTWARE_TOKEN_MFA\"}");
    }

    static ConfirmDeviceParam confirmDeviceParam(Map<String, Object> vars) {
        return parse(ConfirmDeviceParam.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"device_key\":" + json(str(vars, "device_key", "dummy-device-key"))
                + "}");
    }

    static UpdateDeviceStatusParam updateDeviceStatusParam(Map<String, Object> vars) {
        return parse(UpdateDeviceStatusParam.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"device_key\":" + json(str(vars, "device_key", "dummy-device-key")) + ","
                + "\"device_remembered_status\":\"remembered\""
                + "}");
    }

    static LinkAwsMarketplaceParam linkAwsMarketplaceParam(Map<String, Object> vars) {
        return parse(LinkAwsMarketplaceParam.class, "{"
                + "\"tenant_id\":" + json(tenantId(vars)) + ","
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"registration_token\":" + json(str(vars, "registration_token", "dummy-registration-token"))
                + "}");
    }

    static SignUpWithAwsMarketplaceParam signUpWithAwsMarketplaceParam(Map<String, Object> vars) {
        return parse(SignUpWithAwsMarketplaceParam.class, "{"
                + "\"email\":" + json(email(vars)) + ","
                + "\"registration_token\":" + json(str(vars, "registration_token", "dummy-registration-token"))
                + "}");
    }

    static ConfirmSignUpWithAwsMarketplaceParam confirmSignUpWithAwsMarketplaceParam(Map<String, Object> vars) {
        return parse(ConfirmSignUpWithAwsMarketplaceParam.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"registration_token\":" + json(str(vars, "registration_token", "dummy-registration-token")) + ","
                + "\"tenant_name\":" + json(str(vars, "tenant_name", "e2e-tenant"))
                + "}");
    }

    // ---- roles / attributes / envs ---------------------------------------------

    static Role role(Map<String, Object> vars) {
        String name = str(vars, "role_name", "e2e_role");
        return parse(Role.class, "{\"role_name\":" + json(name) + ",\"display_name\":" + json(name) + "}");
    }

    static UpdateRoleParam updateRoleParam(Map<String, Object> vars) {
        return parse(UpdateRoleParam.class, "{\"display_name\":" + json(str(vars, "role_name", "e2e_role") + "-update") + "}");
    }

    static Attribute userAttribute(Map<String, Object> vars) {
        String name = str(vars, "user_attribute_name", "e2e_user_attr");
        return attribute(name);
    }

    static Attribute saasUserAttribute(Map<String, Object> vars) {
        String name = str(vars, "saas_user_attribute_name", "e2e_saas_user_attr");
        return attribute(name);
    }

    static Attribute tenantAttribute(Map<String, Object> vars) {
        String name = str(vars, "tenant_attribute_name", "e2e_tenant_attr");
        return attribute(name);
    }

    private static Attribute attribute(String name) {
        return parse(Attribute.class, "{"
                + "\"attribute_name\":" + json(name) + ","
                + "\"display_name\":" + json(name) + ","
                + "\"attribute_type\":\"string\""
                + "}");
    }

    static Env env(Map<String, Object> vars) {
        return parse(Env.class, "{"
                + "\"id\":" + crudEnvId(vars) + ","
                + "\"name\":" + json(str(vars, "env_name", "e2e_env")) + ","
                + "\"display_name\":" + json(str(vars, "env_name", "e2e_env"))
                + "}");
    }

    static UpdateEnvParam updateEnvParam(Map<String, Object> vars) {
        return parse(UpdateEnvParam.class, "{"
                + "\"name\":" + json(str(vars, "env_name", "e2e_env")) + ","
                + "\"display_name\":" + json(str(vars, "env_name", "e2e_env") + "-update")
                + "}");
    }

    // ---- basic-info / auth-info / customize / notifications --------------------

    static UpdateBasicInfoParam updateBasicInfoParam(Map<String, Object> vars) {
        return parse(UpdateBasicInfoParam.class, "{"
                + "\"domain_name\":" + json(env("TEST_DOMAIN_NAME", "kooriyama.dev.saasus.io")) + ","
                + "\"from_email_address\":" + json(env("TEST_FROM_EMAIL", "test@kooriyama.dev.saasus.io"))
                + "}");
    }

    static AuthInfo authInfo(Map<String, Object> vars) {
        return parse(AuthInfo.class, "{\"callback_url\":"
                + json(env("TEST_CALLBACK_URL", "https://example.com/callback")) + "}");
    }

    static UpdateSignInSettingsParam updateSignInSettingsParam(Map<String, Object> vars) {
        return parse(UpdateSignInSettingsParam.class, "{\"self_regist\":{\"enable\":true}}");
    }

    static UpdateIdentityProviderParam updateIdentityProviderParam(Map<String, Object> vars) {
        // "Google" is a valid ProviderName enum value; the step tolerates 4xx if the provider is
        // not configured for the environment.
        return parse(UpdateIdentityProviderParam.class, "{\"provider\":\"Google\"}");
    }

    static UpdateNotificationMessagesParam updateNotificationMessagesParam(Map<String, Object> vars) {
        // Echo the notification messages captured by the preceding FindNotificationMessages step
        // when available (a no-op update). Otherwise send a minimal valid body: at least one
        // MessageTemplate ({subject, message}) must be present, else the API rejects the request
        // with 400 "update object is not set". The mega-flow cleanup restores the originals.
        UpdateNotificationMessagesParam restored = restoredNotificationMessagesParam(vars);
        if (restored != null && restored.getSignUp() != null) {
            return restored;
        }
        return parse(UpdateNotificationMessagesParam.class,
                "{\"sign_up\":{\"subject\":\"E2E\",\"message\":\"E2E test notification\"}}");
    }

    static UpdateCustomizePagesParam updateCustomizePagesParam(Map<String, Object> vars) {
        // Echo the pages captured by the preceding GetCustomizePages step (no-op update) when
        // available; otherwise send a minimal valid body (an empty {} is rejected with 400
        // "update object is not set"). The mega-flow cleanup restores the originals.
        UpdateCustomizePagesParam restored = restoredCustomizePagesParam(vars);
        if (restored != null && restored.getSignInPage() != null) {
            return restored;
        }
        return parse(UpdateCustomizePagesParam.class, "{"
                + "\"sign_in_page\":{"
                + "\"html_contents\":\"\",\"is_terms_of_service\":false,\"is_privacy_policy\":false}"
                + "}");
    }

    static UpdateCustomizePageSettingsParam updateCustomizePageSettingsParam(Map<String, Object> vars) {
        // Echo the settings captured by the preceding GetCustomizePageSettings step verbatim (a
        // no-op update the server is guaranteed to accept). Only fall back to empty values if the
        // capture is unavailable — never send fake icon/favicon URLs, which the API rejects with
        // 400 invalid_parameter.
        UpdateCustomizePageSettingsParam restored = restoredCustomizePageSettingsParam(vars);
        if (restored != null) {
            return restored;
        }
        return parse(UpdateCustomizePageSettingsParam.class, "{"
                + "\"title\":\"\","
                + "\"terms_of_service_url\":\"\","
                + "\"privacy_policy_url\":\"\","
                + "\"google_tag_manager_container_id\":\"\","
                + "\"is_sign_in_id_enabled\":false,"
                + "\"icon\":\"\","
                + "\"favicon\":\"\""
                + "}");
    }

    // ---- SaaS-wide settings capture / restore ----------------------------------
    //
    // The mega-flow overwrites shared BasicInfo / AuthInfo / sign-in / notification / customize
    // settings. These {@link StateUpdate}s remember the original {@code get*} responses so the
    // story's cleanup hook can re-apply them, leaving the SaaS configuration as it was found. The
    // restore params are rebuilt from the captured model's JSON (fields common to the update param
    // are preserved; extra read-only fields are ignored by Gson).

    static void captureBasicInfo(Object response, Map<String, Object> vars) {
        putOriginal(vars, "orig_basic_info", response);
    }

    static void captureAuthInfo(Object response, Map<String, Object> vars) {
        putOriginal(vars, "orig_auth_info", response);
    }

    static void captureSignInSettings(Object response, Map<String, Object> vars) {
        putOriginal(vars, "orig_sign_in_settings", response);
    }

    static void captureNotificationMessages(Object response, Map<String, Object> vars) {
        putOriginal(vars, "orig_notification_messages", response);
    }

    static void captureCustomizePages(Object response, Map<String, Object> vars) {
        putOriginal(vars, "orig_customize_pages", response);
    }

    static void captureCustomizePageSettings(Object response, Map<String, Object> vars) {
        putOriginal(vars, "orig_customize_page_settings", response);
    }

    static UpdateBasicInfoParam restoredBasicInfoParam(Map<String, Object> vars) {
        return convert(UpdateBasicInfoParam.class, vars.get("orig_basic_info"));
    }

    static AuthInfo restoredAuthInfo(Map<String, Object> vars) {
        return convert(AuthInfo.class, vars.get("orig_auth_info"));
    }

    static UpdateSignInSettingsParam restoredSignInSettingsParam(Map<String, Object> vars) {
        return convert(UpdateSignInSettingsParam.class, vars.get("orig_sign_in_settings"));
    }

    static UpdateNotificationMessagesParam restoredNotificationMessagesParam(Map<String, Object> vars) {
        return convert(UpdateNotificationMessagesParam.class, vars.get("orig_notification_messages"));
    }

    static UpdateCustomizePagesParam restoredCustomizePagesParam(Map<String, Object> vars) {
        return convert(UpdateCustomizePagesParam.class, vars.get("orig_customize_pages"));
    }

    static UpdateCustomizePageSettingsParam restoredCustomizePageSettingsParam(Map<String, Object> vars) {
        return convert(UpdateCustomizePageSettingsParam.class, vars.get("orig_customize_page_settings"));
    }

    private static void putOriginal(Map<String, Object> vars, String key, Object response) {
        if (response != null) {
            vars.put(key, response);
        }
    }

    /** Rebuilds an update param from a captured {@code get*} model via its generated JSON, or null. */
    private static <T> T convert(Class<T> type, Object captured) {
        if (captured == null) {
            return null;
        }
        try {
            String jsonString = (String) captured.getClass().getMethod("toJson").invoke(captured);
            return parse(type, jsonString);
        } catch (Exception e) {
            return null;
        }
    }

    // ---- tenants ---------------------------------------------------------------

    static TenantProps tenantProps(Map<String, Object> vars) {
        return parse(TenantProps.class, "{"
                + "\"name\":" + json(str(vars, "tenant_name", "e2e-tenant")) + ","
                + "\"attributes\":{},"
                + "\"back_office_staff_email\":" + json(env("TEST_BACK_OFFICE_EMAIL", "admin@example.com"))
                + "}");
    }

    static BillingInfo billingInfo(Map<String, Object> vars) {
        return parse(BillingInfo.class, "{"
                + "\"name\":\"E2E Tenant\","
                + "\"address\":{"
                + "\"street\":\"1-1-1\","
                + "\"city\":\"Tokyo\","
                + "\"state\":\"Tokyo\","
                + "\"country\":\"JP\","
                + "\"postal_code\":\"100-0001\"},"
                + "\"invoice_language\":\"ja-JP\""
                + "}");
    }

    static PlanReservation planReservation(Map<String, Object> vars) {
        return parse(PlanReservation.class, "{}");
    }

    static UpdateTenantIdentityProviderParam updateTenantIdentityProviderParam(Map<String, Object> vars) {
        // "SAML" is a valid ProviderType enum value; the step tolerates 4xx when not configured.
        return parse(UpdateTenantIdentityProviderParam.class, "{\"provider_type\":\"SAML\"}");
    }

    // ---- tenant users ----------------------------------------------------------

    static CreateTenantUserParam createTenantUserParam(Map<String, Object> vars) {
        return parse(CreateTenantUserParam.class, "{"
                + "\"email\":" + json(email(vars)) + ","
                + "\"attributes\":{}"
                + "}");
    }

    static UpdateTenantUserParam updateTenantUserParam(Map<String, Object> vars) {
        return parse(UpdateTenantUserParam.class, "{\"attributes\":{}}");
    }

    static CreateTenantUserRolesParam createTenantUserRolesParam(Map<String, Object> vars) {
        return parse(CreateTenantUserRolesParam.class,
                "{\"role_names\":[" + json(str(vars, "role_name", "admin")) + "]}");
    }

    // ---- invitations -----------------------------------------------------------

    static CreateTenantInvitationParam createTenantInvitationParam(Map<String, Object> vars) {
        return parse(CreateTenantInvitationParam.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"email\":" + json(str(vars, "invitee_email", "e2e-invitee@example.com")) + ","
                + "\"envs\":[{\"id\":" + envId(vars) + ",\"role_names\":[" + json(str(vars, "role_name", "admin")) + "]}]"
                + "}");
    }

    static ValidateInvitationParam validateInvitationParam(Map<String, Object> vars) {
        return parse(ValidateInvitationParam.class, "{"
                + "\"email\":" + json(str(vars, "invitee_email", "e2e-invitee@example.com")) + ","
                + "\"password\":" + json(str(vars, "password", "Test-Passw0rd-1!"))
                + "}");
    }

    // ---- credentials / single-tenant -------------------------------------------

    static Credentials credentials(Map<String, Object> vars) {
        return parse(Credentials.class, "{"
                + "\"access_token\":" + json(token(vars)) + ","
                + "\"id_token\":" + json(str(vars, "id_token", "dummy-id-token")) + ","
                + "\"refresh_token\":" + json(str(vars, "refresh_token", "dummy-refresh-token"))
                + "}");
    }

    static UpdateSingleTenantSettingsParam updateSingleTenantSettingsParam(Map<String, Object> vars) {
        return parse(UpdateSingleTenantSettingsParam.class, "{}");
    }

    // ---- response extraction ----------------------------------------------------

    static void extractCreatedSaasUserId(Object response, Map<String, Object> vars) {
        putId(response, vars, "user_id");
    }

    static void extractRoleName(Object response, Map<String, Object> vars) {
        if (response instanceof Role) {
            String name = ((Role) response).getRoleName();
            if (name != null && !name.isEmpty()) {
                vars.put("role_name", name);
            }
        }
    }

    /** Best-effort id extraction via reflection ({@code getId}) so it works across model types. */
    private static void putId(Object response, Map<String, Object> vars, String key) {
        if (response == null) {
            return;
        }
        try {
            Object id = response.getClass().getMethod("getId").invoke(response);
            if (id != null && !id.toString().isEmpty()) {
                vars.put(key, id.toString());
            }
        } catch (Exception ignored) {
            // no id getter; nothing to capture
        }
    }

    // ---- helpers ----------------------------------------------------------------

    private static <T> T parse(Class<T> type, String jsonString) {
        try {
            return type.cast(type.getMethod("fromJson", String.class).invoke(null, jsonString));
        } catch (Exception e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            throw new IllegalStateException("failed to build " + type.getSimpleName()
                    + " from JSON: " + cause.getMessage(), cause);
        }
    }

    private static String require(Map<String, Object> vars, String key) {
        Object v = vars.get(key);
        if (v == null || v.toString().isEmpty()) {
            throw new IllegalStateException("required variable '" + key + "' is missing");
        }
        return v.toString();
    }

    private static String str(Map<String, Object> vars, String key, String fallback) {
        Object v = vars.get(key);
        return (v == null || v.toString().isEmpty()) ? fallback : v.toString();
    }

    private static String env(String key, String fallback) {
        String v = System.getenv(key);
        return (v == null || v.isEmpty()) ? fallback : v;
    }

    private static Integer envIdDefault() {
        String v = System.getenv("TEST_ENV_ID");
        if (v != null && !v.isEmpty()) {
            try {
                return Integer.valueOf(v);
            } catch (NumberFormatException ignored) {
                // fall through to default
            }
        }
        return 3;
    }

    /** Minimal JSON string encoding for interpolated values. */
    private static String json(String value) {
        if (value == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder(value.length() + 2);
        sb.append('"');
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            switch (c) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    sb.append(c);
            }
        }
        sb.append('"');
        return sb.toString();
    }
}
