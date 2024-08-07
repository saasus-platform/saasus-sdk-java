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
import saasus.sdk.pricing.models.PricingMenu;
import saasus.sdk.pricing.models.PricingMenus;
import saasus.sdk.pricing.models.SavePricingMenuParam;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PricingMenusApi
 */
@Disabled
public class PricingMenusApiTest {

    private final PricingMenusApi api = new PricingMenusApi();

    /**
     * Create a Pricing Feature Menu
     *
     * Create a pricing feature menu. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createPricingMenuTest() throws ApiException {
        SavePricingMenuParam body = null;
        PricingMenu response = api.createPricingMenu(body);
        // TODO: test validations
    }

    /**
     * Delete Pricing Feature Menu
     *
     * Delete pricing feature menu. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deletePricingMenuTest() throws ApiException {
        String menuId = null;
        api.deletePricingMenu(menuId);
        // TODO: test validations
    }

    /**
     * Get Pricing Feature Menu
     *
     * Get a pricing feature menu. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getPricingMenuTest() throws ApiException {
        String menuId = null;
        PricingMenu response = api.getPricingMenu(menuId);
        // TODO: test validations
    }

    /**
     * Get Pricing Feature Menus
     *
     * Get the feature menu list. Multiple measurement units are grouped together and defined as one feature menu. Multiple feature menus defined here are combined into one billing plan. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getPricingMenusTest() throws ApiException {
        PricingMenus response = api.getPricingMenus();
        // TODO: test validations
    }

    /**
     * Update Pricing Feature Menu
     *
     * Update pricing feature menu. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updatePricingMenuTest() throws ApiException {
        String menuId = null;
        SavePricingMenuParam body = null;
        api.updatePricingMenu(menuId, body);
        // TODO: test validations
    }

}
