/*
 * SaaSus Pricing API Schema
 * SaaSus Pricing API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.pricing.api;

import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.models.Error;
import saasus.sdk.pricing.models.PricingPlan;
import saasus.sdk.pricing.models.PricingPlans;
import saasus.sdk.pricing.models.SavePricingPlanParam;
import saasus.sdk.pricing.models.UpdatePricingPlansUsedParam;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PricingPlansApi
 */
@Disabled
public class PricingPlansApiTest {

    private final PricingPlansApi api = new PricingPlansApi();

    /**
     * Create Pricing Plan
     *
     * Create a pricing plan. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createPricingPlanTest() throws ApiException {
        SavePricingPlanParam body = null;
        PricingPlan response = api.createPricingPlan(body);
        // TODO: test validations
    }

    /**
     * Delete all Plans, Menus, Units, Meters and Tax Rates
     *
     * Unconditionally remove all rate plans, menus, units, meters and tax rates. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRatesTest() throws ApiException {
        api.deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates();
        // TODO: test validations
    }

    /**
     * Delete Pricing Plan
     *
     * Delete a pricing plan. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deletePricingPlanTest() throws ApiException {
        String planId = null;
        api.deletePricingPlan(planId);
        // TODO: test validations
    }

    /**
     * Delete Product Data from Stripe
     *
     * Delete product data from Stripe. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteStripePlanTest() throws ApiException {
        api.deleteStripePlan();
        // TODO: test validations
    }

    /**
     * Get Pricing Plan
     *
     * Get a pricing plan. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getPricingPlanTest() throws ApiException {
        String planId = null;
        PricingPlan response = api.getPricingPlan(planId);
        // TODO: test validations
    }

    /**
     * Get Pricing Plans
     *
     * Get pricing plans. Multiple feature menus are grouped together and defined as one pricing plan. Each tenant can choose a pricing plan defined here. If you have a specific tenant-specific rate (private pricing), create and connect the pricing plan specifically for that tenant. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getPricingPlansTest() throws ApiException {
        PricingPlans response = api.getPricingPlans();
        // TODO: test validations
    }

    /**
     * Connect to Stripe
     *
     * Connect information to Stripe. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void linkPlanToStripeTest() throws ApiException {
        api.linkPlanToStripe();
        // TODO: test validations
    }

    /**
     * Update Pricing Plan
     *
     * Update a pricing plan. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updatePricingPlanTest() throws ApiException {
        String planId = null;
        SavePricingPlanParam body = null;
        api.updatePricingPlan(planId, body);
        // TODO: test validations
    }

    /**
     * Update Used Flag
     *
     * Update price plan and feature menu/pricing unit to used. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updatePricingPlansUsedTest() throws ApiException {
        UpdatePricingPlansUsedParam updatePricingPlansUsedParam = null;
        api.updatePricingPlansUsed(updatePricingPlansUsedParam);
        // TODO: test validations
    }

}
