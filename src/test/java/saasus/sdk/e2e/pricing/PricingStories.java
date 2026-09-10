package saasus.sdk.e2e.pricing;

import saasus.sdk.testlib.CallStyle;
import saasus.sdk.testlib.LifecycleAction;
import saasus.sdk.testlib.StateUpdate;
import saasus.sdk.testlib.Step;
import saasus.sdk.testlib.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * Pricing test stories mirroring the Go reference coverage: a dependency-ordered lifecycle over
 * Metering / PricingUnits / PricingMenus / PricingPlans / TaxRate, ending with
 * {@code deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates} as cleanup.
 *
 * <p>The full flow is replicated once per {@link CallStyle}; together the four variants cover
 * every {@code (method, style)} pair in the pricing coverage universe. Each story seeds unique
 * entity names so runs never collide.
 */
final class PricingStories {

    private static final int CREATED = 201;
    private static final int OK = 200;
    private static final int NOT_IMPLEMENTED = 501;

    private PricingStories() {
    }

    static List<Story> all(LifecycleAction cleanup) {
        List<Story> stories = new ArrayList<Story>();
        for (CallStyle style : CallStyle.values()) {
            stories.add(story(style, cleanup));
        }
        return stories;
    }

    private static Story story(CallStyle style, LifecycleAction cleanup) {
        return Story.builder("Pricing lifecycle - " + style)
                .description("Full pricing CRUD + metering flow using the " + style + " call style")
                .module("pricing")
                .setup(PricingParams::seedUniqueNames)
                // --- Metering unit ---
                .step(step("CreateMeteringUnit", "createMeteringUnit", style, CREATED,
                        PricingParams::extractMeteringUnitId))
                .step(step("GetMeteringUnits", "getMeteringUnits", style, OK, null))
                // --- Pricing unit (fixed) ---
                .step(step("CreatePricingUnit", "createPricingUnit", style, CREATED,
                        PricingParams::extractPricingUnitId))
                .step(step("GetPricingUnits", "getPricingUnits", style, OK, null))
                .step(step("GetPricingUnit", "getPricingUnit", style, OK, null))
                .step(step("UpdatePricingUnit", "updatePricingUnit", style, OK, null))
                // --- Pricing menu ---
                .step(step("CreatePricingMenu", "createPricingMenu", style, CREATED,
                        PricingParams::extractPricingMenuId))
                .step(step("GetPricingMenus", "getPricingMenus", style, OK, null))
                .step(step("GetPricingMenu", "getPricingMenu", style, OK, null))
                .step(step("UpdatePricingMenu", "updatePricingMenu", style, OK, null))
                // --- Pricing plan ---
                .step(step("CreatePricingPlan", "createPricingPlan", style, CREATED,
                        PricingParams::extractPricingPlanId))
                .step(step("GetPricingPlans", "getPricingPlans", style, OK, null))
                .step(step("GetPricingPlan", "getPricingPlan", style, OK, null))
                .step(step("UpdatePricingPlan", "updatePricingPlan", style, OK, null))
                // NOTE: updatePricingPlansUsed (PATCH /plans/used) は内部呼び出し専用の API で、
                // 外部からは呼び出せず常に 501 を返す。これは仕様上の期待値であり、200 には変更しない。
                .step(step("UpdatePricingPlansUsed", "updatePricingPlansUsed", style, NOT_IMPLEMENTED, null))
                // --- Metering unit update (kept name/aggregate) ---
                .step(step("UpdateMeteringUnitByID", "updateMeteringUnitByID", style, OK, null))
                // --- Metering counts (tenant-scoped) ---
                .step(step("UpdateMeteringUnitTimestampCount", "updateMeteringUnitTimestampCount", style, OK, null))
                .step(step("GetMeteringUnitDateCountByTenantIdAndUnitNameAndDate",
                        "getMeteringUnitDateCountByTenantIdAndUnitNameAndDate", style, OK, null))
                .step(step("UpdateMeteringUnitTimestampCountNow", "updateMeteringUnitTimestampCountNow", style, OK, null))
                .step(step("GetMeteringUnitDateCountByTenantIdAndUnitNameToday",
                        "getMeteringUnitDateCountByTenantIdAndUnitNameToday", style, OK, null))
                .step(step("GetMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth",
                        "getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth", style, OK, null))
                .step(step("GetMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth",
                        "getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth", style, OK, null))
                .step(step("GetMeteringUnitDateCountsByTenantIdAndDate",
                        "getMeteringUnitDateCountsByTenantIdAndDate", style, OK, null))
                .step(step("GetMeteringUnitMonthCountsByTenantIdAndMonth",
                        "getMeteringUnitMonthCountsByTenantIdAndMonth", style, OK, null))
                .step(step("GetMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod",
                        "getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod", style, OK, null))
                .step(step("DeleteMeteringUnitTimestampCount", "deleteMeteringUnitTimestampCount", style, OK, null))
                // --- Tax rate ---
                .step(step("CreateTaxRate", "createTaxRate", style, CREATED, PricingParams::extractTaxRateId))
                .step(step("GetTaxRates", "getTaxRates", style, OK, null))
                .step(step("UpdateTaxRate", "updateTaxRate", style, OK, null))
                // --- Cleanup (also covers the deleteAll method) ---
                .step(step("DeleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates",
                        "deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates", style, OK, null))
                .cleanup(cleanup)
                .build();
    }

    private static Step step(String name, String method, CallStyle style, int expectedStatus, StateUpdate stateUpdate) {
        Step.Builder builder = Step.builder(name, method)
                .callStyle(style)
                .expectedStatus(expectedStatus);
        if (stateUpdate != null) {
            builder.stateUpdate(stateUpdate);
        }
        return builder.build();
    }
}
