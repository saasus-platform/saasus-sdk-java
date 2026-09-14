package saasus.sdk.e2e.pricing;

import com.google.gson.reflect.TypeToken;
import okhttp3.Request;
import saasus.sdk.e2e.support.ThrowingCallSupplier;
import saasus.sdk.modules.PricingApiClient;
import saasus.sdk.modules.Utils;
import saasus.sdk.pricing.ApiCallback;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.ApiResponse;
import saasus.sdk.pricing.api.MeteringApi;
import saasus.sdk.pricing.api.PricingMenusApi;
import saasus.sdk.pricing.api.PricingPlansApi;
import saasus.sdk.pricing.api.PricingUnitsApi;
import saasus.sdk.pricing.api.TaxRateApi;
import saasus.sdk.pricing.models.MeteringUnit;
import saasus.sdk.pricing.models.MeteringUnitDateCount;
import saasus.sdk.pricing.models.MeteringUnitDateCounts;
import saasus.sdk.pricing.models.MeteringUnitDatePeriodCounts;
import saasus.sdk.pricing.models.MeteringUnitMonthCount;
import saasus.sdk.pricing.models.MeteringUnitMonthCounts;
import saasus.sdk.pricing.models.MeteringUnitTimestampCount;
import saasus.sdk.pricing.models.MeteringUnits;
import saasus.sdk.pricing.models.PricingMenu;
import saasus.sdk.pricing.models.PricingMenus;
import saasus.sdk.pricing.models.PricingPlan;
import saasus.sdk.pricing.models.PricingPlans;
import saasus.sdk.pricing.models.PricingUnit;
import saasus.sdk.pricing.models.PricingUnits;
import saasus.sdk.pricing.models.TaxRate;
import saasus.sdk.pricing.models.TaxRates;
import saasus.sdk.testlib.AsyncSink;
import saasus.sdk.testlib.HttpInfo;
import saasus.sdk.testlib.HttpInfoCall;
import saasus.sdk.testlib.MethodInvokers;
import saasus.sdk.testlib.MethodRegistry;
import saasus.sdk.testlib.NormalCall;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Registers the pricing API methods (Metering / PricingUnits / PricingMenus / PricingPlans /
 * TaxRate) across all four call styles. Mirrors the Go reference coverage universe; individual
 * delete endpoints, {@code linkPlanToStripe} and {@code deleteStripePlan} are intentionally
 * excluded (Go excludes them because of dependency / Stripe constraints), and cleanup uses
 * {@code deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates}.
 *
 * <p>See {@code billing.BillingInvokers} for the signing rationale (async is signed manually).
 */
final class PricingInvokers {

    private static Type type(TypeToken<?> token) {
        return token.getType();
    }

    private static final Type T_METERING_UNIT = type(new TypeToken<MeteringUnit>() { });
    private static final Type T_METERING_UNITS = type(new TypeToken<MeteringUnits>() { });
    private static final Type T_METERING_TS_COUNT = type(new TypeToken<MeteringUnitTimestampCount>() { });
    private static final Type T_DATE_COUNT = type(new TypeToken<MeteringUnitDateCount>() { });
    private static final Type T_DATE_COUNTS = type(new TypeToken<MeteringUnitDateCounts>() { });
    private static final Type T_DATE_PERIOD_COUNTS = type(new TypeToken<MeteringUnitDatePeriodCounts>() { });
    private static final Type T_MONTH_COUNT = type(new TypeToken<MeteringUnitMonthCount>() { });
    private static final Type T_MONTH_COUNTS = type(new TypeToken<MeteringUnitMonthCounts>() { });
    private static final Type T_PRICING_UNIT = type(new TypeToken<PricingUnit>() { });
    private static final Type T_PRICING_UNITS = type(new TypeToken<PricingUnits>() { });
    private static final Type T_PRICING_MENU = type(new TypeToken<PricingMenu>() { });
    private static final Type T_PRICING_MENUS = type(new TypeToken<PricingMenus>() { });
    private static final Type T_PRICING_PLAN = type(new TypeToken<PricingPlan>() { });
    private static final Type T_PRICING_PLANS = type(new TypeToken<PricingPlans>() { });
    private static final Type T_TAX_RATE = type(new TypeToken<TaxRate>() { });
    private static final Type T_TAX_RATES = type(new TypeToken<TaxRates>() { });

    private final PricingApiClient client;
    private final MeteringApi metering;
    private final PricingUnitsApi units;
    private final PricingMenusApi menus;
    private final PricingPlansApi plans;
    private final TaxRateApi taxRates;

    PricingInvokers(PricingApiClient client) {
        this.client = client;
        this.metering = new MeteringApi(client);
        this.units = new PricingUnitsApi(client);
        this.menus = new PricingMenusApi(client);
        this.plans = new PricingPlansApi(client);
        this.taxRates = new TaxRateApi(client);
    }

    MethodRegistry buildRegistry() {
        MethodRegistry r = new MethodRegistry();

        // ---- Metering unit lifecycle ----
        r.register("createMeteringUnit", make(
                vars -> metering.createMeteringUnit(PricingParams.meteringUnitProps(vars)),
                vars -> httpInfo(metering.createMeteringUnitWithHttpInfo(PricingParams.meteringUnitProps(vars))),
                vars -> metering.createMeteringUnitCall(PricingParams.meteringUnitProps(vars), null),
                T_METERING_UNIT));
        r.register("getMeteringUnits", make(
                vars -> metering.getMeteringUnits(),
                vars -> httpInfo(metering.getMeteringUnitsWithHttpInfo()),
                vars -> metering.getMeteringUnitsCall(null),
                T_METERING_UNITS));
        r.register("updateMeteringUnitByID", make(
                vars -> {
                    metering.updateMeteringUnitByID(str(vars, "metering_unit_id"),
                            PricingParams.meteringUnitUpdateProps(vars));
                    return null;
                },
                vars -> httpInfo(metering.updateMeteringUnitByIDWithHttpInfo(str(vars, "metering_unit_id"),
                        PricingParams.meteringUnitUpdateProps(vars))),
                vars -> metering.updateMeteringUnitByIDCall(str(vars, "metering_unit_id"),
                        PricingParams.meteringUnitUpdateProps(vars), null),
                null));

        // ---- Metering counts (tenant-scoped) ----
        r.register("updateMeteringUnitTimestampCount", make(
                vars -> metering.updateMeteringUnitTimestampCount(tenant(vars), name(vars),
                        PricingParams.TIMESTAMP, PricingParams.timestampCountParam()),
                vars -> httpInfo(metering.updateMeteringUnitTimestampCountWithHttpInfo(tenant(vars), name(vars),
                        PricingParams.TIMESTAMP, PricingParams.timestampCountParam())),
                vars -> metering.updateMeteringUnitTimestampCountCall(tenant(vars), name(vars),
                        PricingParams.TIMESTAMP, PricingParams.timestampCountParam(), null),
                T_METERING_TS_COUNT));
        r.register("updateMeteringUnitTimestampCountNow", make(
                vars -> metering.updateMeteringUnitTimestampCountNow(tenant(vars), name(vars),
                        PricingParams.timestampCountNowParam()),
                vars -> httpInfo(metering.updateMeteringUnitTimestampCountNowWithHttpInfo(tenant(vars), name(vars),
                        PricingParams.timestampCountNowParam())),
                vars -> metering.updateMeteringUnitTimestampCountNowCall(tenant(vars), name(vars),
                        PricingParams.timestampCountNowParam(), null),
                T_METERING_TS_COUNT));
        r.register("deleteMeteringUnitTimestampCount", make(
                vars -> {
                    metering.deleteMeteringUnitTimestampCount(tenant(vars), name(vars), PricingParams.TIMESTAMP);
                    return null;
                },
                vars -> httpInfo(metering.deleteMeteringUnitTimestampCountWithHttpInfo(tenant(vars), name(vars),
                        PricingParams.TIMESTAMP)),
                vars -> metering.deleteMeteringUnitTimestampCountCall(tenant(vars), name(vars),
                        PricingParams.TIMESTAMP, null),
                null));
        r.register("getMeteringUnitDateCountByTenantIdAndUnitNameAndDate", make(
                vars -> metering.getMeteringUnitDateCountByTenantIdAndUnitNameAndDate(tenant(vars), name(vars),
                        PricingParams.DATE),
                vars -> httpInfo(metering.getMeteringUnitDateCountByTenantIdAndUnitNameAndDateWithHttpInfo(
                        tenant(vars), name(vars), PricingParams.DATE)),
                vars -> metering.getMeteringUnitDateCountByTenantIdAndUnitNameAndDateCall(tenant(vars), name(vars),
                        PricingParams.DATE, null),
                T_DATE_COUNT));
        r.register("getMeteringUnitDateCountByTenantIdAndUnitNameToday", make(
                vars -> metering.getMeteringUnitDateCountByTenantIdAndUnitNameToday(tenant(vars), name(vars)),
                vars -> httpInfo(metering.getMeteringUnitDateCountByTenantIdAndUnitNameTodayWithHttpInfo(
                        tenant(vars), name(vars))),
                vars -> metering.getMeteringUnitDateCountByTenantIdAndUnitNameTodayCall(tenant(vars), name(vars), null),
                T_DATE_COUNT));
        r.register("getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod", make(
                vars -> metering.getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod(tenant(vars), name(vars),
                        null, null),
                vars -> httpInfo(metering.getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriodWithHttpInfo(
                        tenant(vars), name(vars), null, null)),
                vars -> metering.getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriodCall(tenant(vars),
                        name(vars), null, null, null),
                T_DATE_PERIOD_COUNTS));
        r.register("getMeteringUnitDateCountsByTenantIdAndDate", make(
                vars -> metering.getMeteringUnitDateCountsByTenantIdAndDate(tenant(vars), PricingParams.DATE),
                vars -> httpInfo(metering.getMeteringUnitDateCountsByTenantIdAndDateWithHttpInfo(tenant(vars),
                        PricingParams.DATE)),
                vars -> metering.getMeteringUnitDateCountsByTenantIdAndDateCall(tenant(vars), PricingParams.DATE, null),
                T_DATE_COUNTS));
        r.register("getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth", make(
                vars -> metering.getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth(tenant(vars), name(vars)),
                vars -> httpInfo(metering.getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonthWithHttpInfo(
                        tenant(vars), name(vars))),
                vars -> metering.getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonthCall(tenant(vars),
                        name(vars), null),
                T_MONTH_COUNT));
        r.register("getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth", make(
                vars -> metering.getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth(tenant(vars), name(vars),
                        PricingParams.MONTH),
                vars -> httpInfo(metering.getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonthWithHttpInfo(
                        tenant(vars), name(vars), PricingParams.MONTH)),
                vars -> metering.getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonthCall(tenant(vars), name(vars),
                        PricingParams.MONTH, null),
                T_MONTH_COUNT));
        r.register("getMeteringUnitMonthCountsByTenantIdAndMonth", make(
                vars -> metering.getMeteringUnitMonthCountsByTenantIdAndMonth(tenant(vars), PricingParams.MONTH),
                vars -> httpInfo(metering.getMeteringUnitMonthCountsByTenantIdAndMonthWithHttpInfo(tenant(vars),
                        PricingParams.MONTH)),
                vars -> metering.getMeteringUnitMonthCountsByTenantIdAndMonthCall(tenant(vars), PricingParams.MONTH,
                        null),
                T_MONTH_COUNTS));

        // ---- Pricing units ----
        r.register("createPricingUnit", make(
                vars -> units.createPricingUnit(PricingParams.pricingUnitForSave(vars)),
                vars -> httpInfo(units.createPricingUnitWithHttpInfo(PricingParams.pricingUnitForSave(vars))),
                vars -> units.createPricingUnitCall(PricingParams.pricingUnitForSave(vars), null),
                T_PRICING_UNIT));
        r.register("getPricingUnits", make(
                vars -> units.getPricingUnits(),
                vars -> httpInfo(units.getPricingUnitsWithHttpInfo()),
                vars -> units.getPricingUnitsCall(null),
                T_PRICING_UNITS));
        r.register("getPricingUnit", make(
                vars -> units.getPricingUnit(str(vars, "pricing_unit_id")),
                vars -> httpInfo(units.getPricingUnitWithHttpInfo(str(vars, "pricing_unit_id"))),
                vars -> units.getPricingUnitCall(str(vars, "pricing_unit_id"), null),
                T_PRICING_UNIT));
        r.register("updatePricingUnit", make(
                vars -> {
                    units.updatePricingUnit(str(vars, "pricing_unit_id"), PricingParams.pricingUnitUpdate(vars));
                    return null;
                },
                vars -> httpInfo(units.updatePricingUnitWithHttpInfo(str(vars, "pricing_unit_id"),
                        PricingParams.pricingUnitUpdate(vars))),
                vars -> units.updatePricingUnitCall(str(vars, "pricing_unit_id"),
                        PricingParams.pricingUnitUpdate(vars), null),
                null));

        // ---- Pricing menus ----
        r.register("createPricingMenu", make(
                vars -> menus.createPricingMenu(PricingParams.savePricingMenuParam(vars)),
                vars -> httpInfo(menus.createPricingMenuWithHttpInfo(PricingParams.savePricingMenuParam(vars))),
                vars -> menus.createPricingMenuCall(PricingParams.savePricingMenuParam(vars), null),
                T_PRICING_MENU));
        r.register("getPricingMenus", make(
                vars -> menus.getPricingMenus(),
                vars -> httpInfo(menus.getPricingMenusWithHttpInfo()),
                vars -> menus.getPricingMenusCall(null),
                T_PRICING_MENUS));
        r.register("getPricingMenu", make(
                vars -> menus.getPricingMenu(str(vars, "pricing_menu_id")),
                vars -> httpInfo(menus.getPricingMenuWithHttpInfo(str(vars, "pricing_menu_id"))),
                vars -> menus.getPricingMenuCall(str(vars, "pricing_menu_id"), null),
                T_PRICING_MENU));
        r.register("updatePricingMenu", make(
                vars -> {
                    menus.updatePricingMenu(str(vars, "pricing_menu_id"), PricingParams.pricingMenuUpdate(vars));
                    return null;
                },
                vars -> httpInfo(menus.updatePricingMenuWithHttpInfo(str(vars, "pricing_menu_id"),
                        PricingParams.pricingMenuUpdate(vars))),
                vars -> menus.updatePricingMenuCall(str(vars, "pricing_menu_id"),
                        PricingParams.pricingMenuUpdate(vars), null),
                null));

        // ---- Pricing plans ----
        r.register("createPricingPlan", make(
                vars -> plans.createPricingPlan(PricingParams.savePricingPlanParam(vars)),
                vars -> httpInfo(plans.createPricingPlanWithHttpInfo(PricingParams.savePricingPlanParam(vars))),
                vars -> plans.createPricingPlanCall(PricingParams.savePricingPlanParam(vars), null),
                T_PRICING_PLAN));
        r.register("getPricingPlans", make(
                vars -> plans.getPricingPlans(),
                vars -> httpInfo(plans.getPricingPlansWithHttpInfo()),
                vars -> plans.getPricingPlansCall(null),
                T_PRICING_PLANS));
        r.register("getPricingPlan", make(
                vars -> plans.getPricingPlan(str(vars, "pricing_plan_id")),
                vars -> httpInfo(plans.getPricingPlanWithHttpInfo(str(vars, "pricing_plan_id"))),
                vars -> plans.getPricingPlanCall(str(vars, "pricing_plan_id"), null),
                T_PRICING_PLAN));
        r.register("updatePricingPlan", make(
                vars -> {
                    plans.updatePricingPlan(str(vars, "pricing_plan_id"), PricingParams.pricingPlanUpdate(vars));
                    return null;
                },
                vars -> httpInfo(plans.updatePricingPlanWithHttpInfo(str(vars, "pricing_plan_id"),
                        PricingParams.pricingPlanUpdate(vars))),
                vars -> plans.updatePricingPlanCall(str(vars, "pricing_plan_id"),
                        PricingParams.pricingPlanUpdate(vars), null),
                null));
        r.register("updatePricingPlansUsed", make(
                vars -> {
                    plans.updatePricingPlansUsed(PricingParams.updatePricingPlansUsedParam(vars));
                    return null;
                },
                vars -> httpInfo(plans.updatePricingPlansUsedWithHttpInfo(
                        PricingParams.updatePricingPlansUsedParam(vars))),
                vars -> plans.updatePricingPlansUsedCall(PricingParams.updatePricingPlansUsedParam(vars), null),
                null));

        // ---- Tax rates ----
        r.register("createTaxRate", make(
                vars -> taxRates.createTaxRate(PricingParams.taxRateProps(vars)),
                vars -> httpInfo(taxRates.createTaxRateWithHttpInfo(PricingParams.taxRateProps(vars))),
                vars -> taxRates.createTaxRateCall(PricingParams.taxRateProps(vars), null),
                T_TAX_RATE));
        r.register("getTaxRates", make(
                vars -> taxRates.getTaxRates(),
                vars -> httpInfo(taxRates.getTaxRatesWithHttpInfo()),
                vars -> taxRates.getTaxRatesCall(null),
                T_TAX_RATES));
        r.register("updateTaxRate", make(
                vars -> {
                    taxRates.updateTaxRate(str(vars, "tax_rate_id"), PricingParams.taxRateUpdate());
                    return null;
                },
                vars -> httpInfo(taxRates.updateTaxRateWithHttpInfo(str(vars, "tax_rate_id"),
                        PricingParams.taxRateUpdate())),
                vars -> taxRates.updateTaxRateCall(str(vars, "tax_rate_id"), PricingParams.taxRateUpdate(), null),
                null));

        // ---- Cleanup / initialization ----
        r.register("deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates", make(
                vars -> {
                    plans.deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates();
                    return null;
                },
                vars -> httpInfo(plans.deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRatesWithHttpInfo()),
                vars -> plans.deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRatesCall(null),
                null));

        return r;
    }

    /** Best-effort cleanup used as story teardown; ignores failures. */
    void deleteAllQuietly() {
        try {
            plans.deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates();
        } catch (Exception ignored) {
            // teardown is best-effort
        }
    }

    // ---- helpers ----------------------------------------------------------------

    private static String tenant(Map<String, Object> vars) {
        return PricingParams.resolveTenantId(vars);
    }

    private static String name(Map<String, Object> vars) {
        Object v = vars.get("metering_unit_name");
        if (v == null || v.toString().isEmpty()) {
            throw new IllegalStateException("required variable 'metering_unit_name' is missing");
        }
        return v.toString();
    }

    private static String str(Map<String, Object> vars, String key) {
        Object v = vars.get(key);
        if (v == null || v.toString().isEmpty()) {
            throw new IllegalStateException("required variable '" + key + "' is missing");
        }
        return v.toString();
    }

    private MethodInvokers make(NormalCall normal, HttpInfoCall httpInfo,
                                ThrowingCallSupplier callFactory, Type returnType) {
        return MethodInvokers.builder()
                .normal(normal)
                .withHttpInfo(httpInfo)
                .async((vars, sink) -> asyncSigned(vars, callFactory, returnType, sink))
                .call((vars, sink) -> callSigned(vars, callFactory, returnType, sink))
                .build();
    }

    private static HttpInfo httpInfo(ApiResponse<?> response) {
        return new HttpInfo(response.getData(), response.getStatusCode(), response.getHeaders());
    }

    private void asyncSigned(Map<String, Object> vars, ThrowingCallSupplier callFactory,
                             Type returnType, AsyncSink sink) throws Exception {
        okhttp3.Call unsigned = callFactory.get(vars);
        String signature = Utils.withSaasusSigV1(unsigned);
        Request signedRequest = unsigned.request().newBuilder().header("Authorization", signature).build();
        okhttp3.Call signed = client.getHttpClient().newCall(signedRequest);
        client.executeAsync(signed, returnType, new ApiCallback<Object>() {
            @Override
            public void onSuccess(Object result, int statusCode, Map<String, List<String>> headers) {
                sink.onSuccess(result, statusCode, headers);
            }

            @Override
            public void onFailure(ApiException e, int statusCode, Map<String, List<String>> headers) {
                sink.onFailure(e, statusCode, headers);
            }

            @Override
            public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
            }

            @Override
            public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
            }
        });
    }

    private void callSigned(Map<String, Object> vars, ThrowingCallSupplier callFactory,
                            Type returnType, AsyncSink sink) {
        try {
            okhttp3.Call unsigned = callFactory.get(vars);
            ApiResponse<?> response = (returnType == null)
                    ? client.execute(unsigned)
                    : client.execute(unsigned, returnType);
            sink.onSuccess(response.getData(), response.getStatusCode(), response.getHeaders());
        } catch (ApiException e) {
            sink.onFailure(e, e.getCode(), e.getResponseHeaders());
        } catch (Exception e) {
            sink.onFailure(e, 0, null);
        }
    }
}
