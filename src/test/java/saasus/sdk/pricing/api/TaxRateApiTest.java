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
import saasus.sdk.pricing.models.TaxRate;
import saasus.sdk.pricing.models.TaxRateProps;
import saasus.sdk.pricing.models.TaxRates;
import saasus.sdk.pricing.models.UpdateTaxRateParam;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TaxRateApi
 */
@Disabled
public class TaxRateApiTest {

    private final TaxRateApi api = new TaxRateApi();

    /**
     * Create Tax Rate
     *
     * Creates a tax rate. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createTaxRateTest() throws ApiException {
        TaxRateProps body = null;
        TaxRate response = api.createTaxRate(body);
        // TODO: test validations
    }

    /**
     * Get Tax Rates
     *
     * Get all Tax Rates 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTaxRatesTest() throws ApiException {
        TaxRates response = api.getTaxRates();
        // TODO: test validations
    }

    /**
     * Update Tax Rate
     *
     * Update tax rate. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateTaxRateTest() throws ApiException {
        String taxRateId = null;
        UpdateTaxRateParam updateTaxRateParam = null;
        api.updateTaxRate(taxRateId, updateTaxRateParam);
        // TODO: test validations
    }

}
