package saasus.sdk.e2e.billing;

import saasus.sdk.testlib.CallStyle;
import saasus.sdk.testlib.Step;
import saasus.sdk.testlib.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * Billing (Stripe) test stories, mirroring the Go reference flow
 * (Pre_Get &rarr; Update &rarr; Get &rarr; Delete &rarr; Final_Get).
 *
 * <p>The Go SDK exercised two method families (standard / WithResponse). The Java testlib
 * exposes four call styles, so the same flow is replicated once per {@link CallStyle}; together
 * the four variants cover every {@code (method, style)} pair for the billing module.
 */
final class BillingStories {

    private BillingStories() {
    }

    static List<Story> all() {
        List<Story> stories = new ArrayList<Story>();
        for (CallStyle style : CallStyle.values()) {
            stories.add(story(style));
        }
        return stories;
    }

    /** The full Postman-collection flow executed entirely through a single call style. */
    private static Story story(CallStyle style) {
        return Story.builder("Stripe Connection CRUD - " + style)
                .description("Reproduces the Postman collection billing flow using the " + style + " call style")
                .module("billing")
                .step(Step.builder("Pre_GetStripeConnectionInformation", "getStripeInfo")
                        .callStyle(style)
                        .expectedStatus(200)
                        .build())
                .step(Step.builder("UpdateStripeConnectionInfo", "updateStripeInfo")
                        .callStyle(style)
                        .expectedStatus(200)
                        .build())
                .step(Step.builder("GetStripeConnectionInformation", "getStripeInfo")
                        .callStyle(style)
                        .expectedStatus(200)
                        .build())
                .step(Step.builder("DeleteStripeConnection", "deleteStripeInfo")
                        .callStyle(style)
                        .expectedStatus(200)
                        .build())
                .step(Step.builder("Final_GetStripeConnectionInformation", "getStripeInfo")
                        .callStyle(style)
                        .expectedStatus(200)
                        .build())
                .build();
    }
}
