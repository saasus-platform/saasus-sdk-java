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
import saasus.sdk.auth.models.AuthorizationTempCode;
import saasus.sdk.auth.models.Credentials;
import saasus.sdk.auth.models.Error;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CredentialApi
 */
@Disabled
public class CredentialApiTest {

    private final CredentialApi api = new CredentialApi();

    /**
     * Save Authentication/Authorization Information
     *
     * Temporarily save the parameter for the ID token, access token, and refresh token and return a temporary code for obtaining. Temporary codes are valid for 10 seconds from issuance. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createAuthCredentialsTest() throws ApiException {
        Credentials body = null;
        AuthorizationTempCode response = api.createAuthCredentials(body);
        // TODO: test validations
    }

    /**
     * Get Authentication/Authorization Information
     *
     * Get ID token, access token, and refresh token using a temporary code or a refresh token. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAuthCredentialsTest() throws ApiException {
        String code = null;
        String authFlow = null;
        String refreshToken = null;
        Credentials response = api.getAuthCredentials(code, authFlow, refreshToken);
        // TODO: test validations
    }

}
