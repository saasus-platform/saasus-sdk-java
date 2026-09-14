package saasus.sdk.e2e.billing;

import saasus.sdk.billing.models.UpdateStripeInfoParam;

/**
 * Parameter builders for billing (Stripe) E2E stories.
 *
 * <p>Mirrors the Go reference test's {@code getTestStripeKey} / {@code createUpdateStripeInfoParams}:
 * the Stripe secret is taken from {@code STRIPE_SECRET_KEY} when available, otherwise a harmless
 * test placeholder is used.
 */
final class BillingParams {

    /** Placeholder used when {@code STRIPE_SECRET_KEY} is not configured (matches the Go test). */
    static final String DEFAULT_TEST_STRIPE_KEY = "sk_test_example_key_for_testing";

    private BillingParams() {
    }

    /** Resolves the Stripe secret key: the provided value (from {@code STRIPE_SECRET_KEY}) or the placeholder. */
    static String stripeKey(String configuredKey) {
        if (configuredKey != null && !configuredKey.isEmpty()) {
            return configuredKey;
        }
        return DEFAULT_TEST_STRIPE_KEY;
    }

    /** Builds the body for {@code updateStripeInfo}. */
    static UpdateStripeInfoParam updateStripeInfoParam(String configuredKey) {
        UpdateStripeInfoParam param = new UpdateStripeInfoParam();
        param.setSecretKey(stripeKey(configuredKey));
        return param;
    }
}
