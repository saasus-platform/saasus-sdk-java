/*
 * SaaSus Communication API Schema
 * SaaSus Communication API Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.communication.api;

import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.models.Error;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ErrorApi
 */
@Disabled
public class ErrorApiTest {

    private final ErrorApi api = new ErrorApi();

    /**
     * Return Internal Server Error
     *
     * This endpoint is used for testing purposes. Returns a server error with status code 500. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void returnInternalServerErrorTest() throws ApiException {
        api.returnInternalServerError();
        // TODO: test validations
    }

}
