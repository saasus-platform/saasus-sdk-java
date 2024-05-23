# ErrorApi

All URIs are relative to *https://api.saasus.io/v1/apilog*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**returnInternalServerError**](ErrorApi.md#returnInternalServerError) | **GET** /errors/internal-server-error | Returns a server error with status code 500 |


<a id="returnInternalServerError"></a>
# **returnInternalServerError**
> returnInternalServerError()

Returns a server error with status code 500

This endpoint is used for testing purposes. Returns a server error with status code 500. 

### Example
```java
// Import classes:
import saasus.sdk.apilog.ApiClient;
import saasus.sdk.apilog.ApiException;
import saasus.sdk.apilog.Configuration;
import saasus.sdk.apilog.auth.*;
import saasus.sdk.apilog.models.*;
import saasus.sdk.apilog.api.ErrorApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apilog");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ErrorApi apiInstance = new ErrorApi(defaultClient);
    try {
      apiInstance.returnInternalServerError();
    } catch (ApiException e) {
      System.err.println("Exception when calling ErrorApi#returnInternalServerError");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **500** | Internal Server Error |  -  |

