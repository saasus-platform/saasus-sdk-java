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
import saasus.sdk.pricing.models.PricingUnit;
import saasus.sdk.pricing.models.PricingUnitForSave;
import saasus.sdk.pricing.models.PricingUnits;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PricingUnitsApi
 */
@Disabled
public class PricingUnitsApiTest {

    private final PricingUnitsApi api = new PricingUnitsApi();

    /**
     * Create Pricing Unit
     *
     * Create a pricing unit. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createPricingUnitTest() throws ApiException {
        PricingUnitForSave body = null;
        PricingUnit response = api.createPricingUnit(body);
        // TODO: test validations
    }

    /**
     * Delete Pricing Unit
     *
     * Delete a pricing unit. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deletePricingUnitTest() throws ApiException {
        String pricingUnitId = null;
        api.deletePricingUnit(pricingUnitId);
        // TODO: test validations
    }

    /**
     * Get Pricing Unit
     *
     * Get a pricing unit. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getPricingUnitTest() throws ApiException {
        String pricingUnitId = null;
        PricingUnit response = api.getPricingUnit(pricingUnitId);
        // TODO: test validations
    }

    /**
     * Get Pricing Units
     *
     * Gets the smallest unit of measure on which the charges are based. \&quot;Fixed Unit\&quot; (type&#x3D;fixed) is a unit of a monthly fixed charge such as a basic charge, \&quot;Usage Unit\&quot; (type&#x3D;usage) is a unit in which a charge is generated per unit such as billing for the number of users, \&quot;Tiered Unit\&quot; (type&#x3D;tiered) is a fixed charge unit for each tier of usage, such as the tiered packet charge for mobile phones, \&quot;Tiered Usage Unit\&quot; (type&#x3D;tiered_usage) is a unit where the charge per unit changes according to the usage amount, such as a volume discount. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getPricingUnitsTest() throws ApiException {
        PricingUnits response = api.getPricingUnits();
        // TODO: test validations
    }

    /**
     * Update Pricing Unit
     *
     * Update pricing unit. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updatePricingUnitTest() throws ApiException {
        String pricingUnitId = null;
        PricingUnitForSave body = null;
        api.updatePricingUnit(pricingUnitId, body);
        // TODO: test validations
    }

}
