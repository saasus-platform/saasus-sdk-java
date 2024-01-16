# ErrorApi

All URIs are relative to *https://api.saasus.io/v1/integration*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**returnInternalServerError**](ErrorApi.md#returnInternalServerError) | **GET** /errors/internal-server-error | ステータスコード500でサーバーエラーを返却(Return Internal Server Error) |


<a id="returnInternalServerError"></a>
# **returnInternalServerError**
> returnInternalServerError()

ステータスコード500でサーバーエラーを返却(Return Internal Server Error)

テスト用途で使用するエンドポイントです。ステータスコード500でサーバーエラーを返却します。  This endpoint is used for testing purposes. Returns a server error with status code 500. 

### Example
```java
// Import classes:
import saasus.sdk.integration.ApiClient;
import saasus.sdk.integration.ApiException;
import saasus.sdk.integration.Configuration;
import saasus.sdk.integration.auth.*;
import saasus.sdk.integration.models.*;
import saasus.sdk.integration.api.ErrorApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/integration");
    
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

