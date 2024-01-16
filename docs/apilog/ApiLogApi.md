# ApiLogApi

All URIs are relative to *https://api.saasus.io/v1/apilog*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getLog**](ApiLogApi.md#getLog) | **GET** /logs/{api_log_id} | API実行ログ取得 |
| [**getLogs**](ApiLogApi.md#getLogs) | **GET** /logs | API実行ログ取得 |


<a id="getLog"></a>
# **getLog**
> ApiLog getLog(apiLogId)

API実行ログ取得

指定したIDのAPI実行のログ登録を取得します。

### Example
```java
// Import classes:
import saasus.sdk.apilog.ApiClient;
import saasus.sdk.apilog.ApiException;
import saasus.sdk.apilog.Configuration;
import saasus.sdk.apilog.auth.*;
import saasus.sdk.apilog.models.*;
import saasus.sdk.apilog.api.ApiLogApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apilog");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ApiLogApi apiInstance = new ApiLogApi(defaultClient);
    String apiLogId = "apiLogId_example"; // String | APIログID(API Log ID)
    try {
      ApiLog result = apiInstance.getLog(apiLogId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiLogApi#getLog");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **apiLogId** | **String**| APIログID(API Log ID) | |

### Return type

[**ApiLog**](ApiLog.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

<a id="getLogs"></a>
# **getLogs**
> ApiLogs getLogs()

API実行ログ取得

全API実行のログ登録を取得します。

### Example
```java
// Import classes:
import saasus.sdk.apilog.ApiClient;
import saasus.sdk.apilog.ApiException;
import saasus.sdk.apilog.Configuration;
import saasus.sdk.apilog.auth.*;
import saasus.sdk.apilog.models.*;
import saasus.sdk.apilog.api.ApiLogApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apilog");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ApiLogApi apiInstance = new ApiLogApi(defaultClient);
    try {
      ApiLogs result = apiInstance.getLogs();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ApiLogApi#getLogs");
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

[**ApiLogs**](ApiLogs.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

