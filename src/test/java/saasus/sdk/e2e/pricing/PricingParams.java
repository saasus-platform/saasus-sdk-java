package saasus.sdk.e2e.pricing;

import saasus.sdk.pricing.models.AggregateUsage;
import saasus.sdk.pricing.models.Currency;
import saasus.sdk.pricing.models.MeteringUnit;
import saasus.sdk.pricing.models.MeteringUnitProps;
import saasus.sdk.pricing.models.PricingFixedUnitForSave;
import saasus.sdk.pricing.models.PricingMenu;
import saasus.sdk.pricing.models.PricingPlan;
import saasus.sdk.pricing.models.PricingUnit;
import saasus.sdk.pricing.models.PricingUnitForSave;
import saasus.sdk.pricing.models.RecurringInterval;
import saasus.sdk.pricing.models.SavePricingMenuParam;
import saasus.sdk.pricing.models.SavePricingPlanParam;
import saasus.sdk.pricing.models.TaxRate;
import saasus.sdk.pricing.models.TaxRateProps;
import saasus.sdk.pricing.models.UnitType;
import saasus.sdk.pricing.models.UpdateMeteringUnitTimestampCountMethod;
import saasus.sdk.pricing.models.UpdateMeteringUnitTimestampCountNowParam;
import saasus.sdk.pricing.models.UpdateMeteringUnitTimestampCountParam;
import saasus.sdk.pricing.models.UpdatePricingPlansUsedParam;
import saasus.sdk.pricing.models.UpdateTaxRateParam;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Parameter builders, response extraction, and shared constants for pricing E2E stories.
 *
 * <p>Mirrors the Go reference builders. Unique entity names are seeded once per story (via
 * {@link #seedUniqueNames}) so a create step and its later update/reference steps agree on the
 * name. {@code tenant_id} is resolved from the story variables, then {@code TEST_TENANT_ID}
 * (existing-tenant prerequisite), matching the Go behaviour.
 */
final class PricingParams {

    static final String DATE = "2024-01-01";
    static final String MONTH = "2024-01";
    static final int TIMESTAMP = 1640995200; // 2022-01-01T00:00:00Z, matches the Go reference

    private static final AtomicLong COUNTER = new AtomicLong();

    private PricingParams() {
    }

    // ---- unique names / tenant --------------------------------------------------

    /** Seeds unique entity names for a single story run so create/update steps stay consistent. */
    static void seedUniqueNames(Map<String, Object> vars) {
        String suffix = System.currentTimeMillis() + "_" + COUNTER.incrementAndGet();
        vars.put("metering_unit_name", "user_counts_" + suffix);
        vars.put("pricing_unit_name", "fixed-unit-name_" + suffix);
        vars.put("pricing_menu_name", "fixed-menu_name_" + suffix);
        vars.put("pricing_plan_name", "plan_name_" + suffix);
        vars.put("tax_rate_name", "consumption_tax_" + suffix);
    }

    /** Environment variable naming an existing tenant used by tenant-scoped metering endpoints. */
    static final String TENANT_ID_ENV = "TEST_TENANT_ID";

    /**
     * Validates the {@code TEST_TENANT_ID} prerequisite before any story runs, so a misconfigured
     * pricing E2E run fails fast rather than creating/updating resources and only then failing at
     * the first tenant-scoped call.
     */
    static void requireTenantId() {
        String env = System.getenv(TENANT_ID_ENV);
        if (env == null || env.isEmpty()) {
            throw new IllegalStateException("missing required environment variable: " + TENANT_ID_ENV
                    + " (an existing tenant id is required for tenant-scoped pricing metering endpoints)");
        }
    }

    /** Resolves the tenant id: story variable, then {@code TEST_TENANT_ID} (validated up-front). */
    static String resolveTenantId(Map<String, Object> vars) {
        Object v = vars.get("tenant_id");
        if (v != null && !v.toString().isEmpty()) {
            return v.toString();
        }
        String env = System.getenv(TENANT_ID_ENV);
        if (env != null && !env.isEmpty()) {
            return env;
        }
        throw new IllegalStateException("missing required environment variable: " + TENANT_ID_ENV);
    }

    private static String str(Map<String, Object> vars, String key) {
        Object v = vars.get(key);
        if (v == null || v.toString().isEmpty()) {
            throw new IllegalStateException("required variable '" + key + "' is missing");
        }
        return v.toString();
    }

    // ---- metering unit ----------------------------------------------------------

    static MeteringUnitProps meteringUnitProps(Map<String, Object> vars) {
        MeteringUnitProps props = new MeteringUnitProps();
        props.setUnitName(str(vars, "metering_unit_name"));
        props.setDisplayName("ユーザ数");
        props.setDescription("ユーザ数カウント用のメーター");
        props.setAggregateUsage(AggregateUsage.MAX);
        return props;
    }

    /** Update keeps name and aggregate_usage (cannot change while in use); updates display/description. */
    static MeteringUnitProps meteringUnitUpdateProps(Map<String, Object> vars) {
        MeteringUnitProps props = new MeteringUnitProps();
        props.setUnitName(str(vars, "metering_unit_name"));
        props.setDisplayName("[更新]ユーザ数");
        props.setDescription("[更新]ユーザ数カウント用のメーター");
        props.setAggregateUsage(AggregateUsage.MAX);
        return props;
    }

    static UpdateMeteringUnitTimestampCountParam timestampCountParam() {
        UpdateMeteringUnitTimestampCountParam param = new UpdateMeteringUnitTimestampCountParam();
        param.setMethod(UpdateMeteringUnitTimestampCountMethod.ADD);
        param.setCount(10);
        return param;
    }

    static UpdateMeteringUnitTimestampCountNowParam timestampCountNowParam() {
        UpdateMeteringUnitTimestampCountNowParam param = new UpdateMeteringUnitTimestampCountNowParam();
        param.setMethod(UpdateMeteringUnitTimestampCountMethod.ADD);
        param.setCount(5);
        return param;
    }

    // ---- pricing unit (fixed) ---------------------------------------------------

    static PricingUnitForSave pricingUnitForSave(Map<String, Object> vars) {
        return new PricingUnitForSave(fixedUnit(str(vars, "pricing_unit_name"),
                "固定ユニット1", "固定ユニットdescription1"));
    }

    static PricingUnitForSave pricingUnitUpdate(Map<String, Object> vars) {
        return new PricingUnitForSave(fixedUnit(str(vars, "pricing_unit_name"),
                "固定ユニット1-update", "固定ユニットdescription1-update"));
    }

    private static PricingFixedUnitForSave fixedUnit(String name, String displayName, String description) {
        PricingFixedUnitForSave unit = new PricingFixedUnitForSave();
        unit.setName(name);
        unit.setDisplayName(displayName);
        unit.setDescription(description);
        unit.setType(UnitType.FIXED);
        unit.setCurrency(Currency.JPY);
        unit.setUnitAmount(300);
        unit.setRecurringInterval(RecurringInterval.MONTH);
        return unit;
    }

    // ---- pricing menu -----------------------------------------------------------

    static SavePricingMenuParam savePricingMenuParam(Map<String, Object> vars) {
        SavePricingMenuParam param = new SavePricingMenuParam();
        param.setName(str(vars, "pricing_menu_name"));
        param.setDisplayName("固定UNITメニュー");
        param.setDescription("メニューdescription");
        param.setUnitIds(Collections.singletonList(str(vars, "pricing_unit_id")));
        return param;
    }

    static SavePricingMenuParam pricingMenuUpdate(Map<String, Object> vars) {
        SavePricingMenuParam param = new SavePricingMenuParam();
        param.setName(str(vars, "pricing_menu_name"));
        param.setDisplayName("固定UNITメニュー-update");
        param.setDescription("メニューdescription-update");
        param.setUnitIds(Collections.singletonList(str(vars, "pricing_unit_id")));
        return param;
    }

    // ---- pricing plan -----------------------------------------------------------

    static SavePricingPlanParam savePricingPlanParam(Map<String, Object> vars) {
        SavePricingPlanParam param = new SavePricingPlanParam();
        param.setName(str(vars, "pricing_plan_name"));
        param.setDisplayName("サンプルプラン");
        param.setDescription("プランdescription");
        param.setMenuIds(Collections.singletonList(str(vars, "pricing_menu_id")));
        return param;
    }

    static SavePricingPlanParam pricingPlanUpdate(Map<String, Object> vars) {
        SavePricingPlanParam param = new SavePricingPlanParam();
        param.setName(str(vars, "pricing_plan_name"));
        param.setDisplayName("サンプルプラン-update");
        param.setDescription("プランdescription-update");
        param.setMenuIds(Collections.singletonList(str(vars, "pricing_menu_id")));
        return param;
    }

    static UpdatePricingPlansUsedParam updatePricingPlansUsedParam(Map<String, Object> vars) {
        UpdatePricingPlansUsedParam param = new UpdatePricingPlansUsedParam();
        param.setPlanIds(Collections.singletonList(str(vars, "pricing_plan_id")));
        return param;
    }

    // ---- tax rate ---------------------------------------------------------------

    static TaxRateProps taxRateProps(Map<String, Object> vars) {
        TaxRateProps props = new TaxRateProps();
        props.setName(str(vars, "tax_rate_name"));
        props.setDisplayName("日本の消費税(内税)");
        props.setDescription("日本の消費税。内税10%");
        props.setPercentage(new BigDecimal("10"));
        props.setInclusive(Boolean.TRUE);
        props.setCountry("JP");
        return props;
    }

    static UpdateTaxRateParam taxRateUpdate() {
        UpdateTaxRateParam param = new UpdateTaxRateParam();
        param.setDisplayName("日本の消費税(内税)-update");
        param.setDescription("日本の消費税。内税10%-update");
        return param;
    }

    // ---- id extraction ----------------------------------------------------------

    static void extractMeteringUnitId(Object response, Map<String, Object> vars) {
        if (response instanceof MeteringUnit) {
            MeteringUnit unit = (MeteringUnit) response;
            vars.put("metering_unit_id", unit.getId());
            if (unit.getUnitName() != null) {
                vars.put("metering_unit_name", unit.getUnitName());
            }
        }
    }

    static void extractPricingUnitId(Object response, Map<String, Object> vars) {
        if (response instanceof PricingUnit) {
            vars.put("pricing_unit_id", ((PricingUnit) response).getPricingFixedUnit().getId());
        }
    }

    static void extractPricingMenuId(Object response, Map<String, Object> vars) {
        if (response instanceof PricingMenu) {
            vars.put("pricing_menu_id", ((PricingMenu) response).getId());
        }
    }

    static void extractPricingPlanId(Object response, Map<String, Object> vars) {
        if (response instanceof PricingPlan) {
            vars.put("pricing_plan_id", ((PricingPlan) response).getId());
        }
    }

    static void extractTaxRateId(Object response, Map<String, Object> vars) {
        if (response instanceof TaxRate) {
            vars.put("tax_rate_id", ((TaxRate) response).getId());
        }
    }
}
