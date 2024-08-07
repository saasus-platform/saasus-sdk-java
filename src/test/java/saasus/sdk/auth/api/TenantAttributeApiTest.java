/*
 * SaaSus Auth API Schema
 * Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.auth.api;

import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.models.Attribute;
import saasus.sdk.auth.models.Error;
import saasus.sdk.auth.models.TenantAttributes;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TenantAttributeApi
 */
@Disabled
public class TenantAttributeApiTest {

    private final TenantAttributeApi api = new TenantAttributeApi();

    /**
     * Create Tenant Attribute
     *
     * Register additional tenant attributes to be managed by SaaSus Platform. For example, tenant name, memo, etc., then get the attributes from SaaS using the SaaSus SDK/API. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createTenantAttributeTest() throws ApiException {
        Attribute body = null;
        Attribute response = api.createTenantAttribute(body);
        // TODO: test validations
    }

    /**
     * Delete Tenant Attribute
     *
     * Deletes tenant attributes managed by SaaSus Platform. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteTenantAttributeTest() throws ApiException {
        String attributeName = null;
        api.deleteTenantAttribute(attributeName);
        // TODO: test validations
    }

    /**
     * Get Tenant Attributes
     *
     * Get definitions for additional tenant attributes managed by the SaaSus Platform. For example, tenant name, memo, etc., then get the attributes from SaaS using the SaaSus SDK/API. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTenantAttributesTest() throws ApiException {
        TenantAttributes response = api.getTenantAttributes();
        // TODO: test validations
    }

}
