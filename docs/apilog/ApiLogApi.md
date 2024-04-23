# ApiLogApi

All URIs are relative to *https://api.saasus.io/v1/apilog*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getLog**](ApiLogApi.md#getLog) | **GET** /logs/{api_log_id} | Get API execution log |
| [**getLogs**](ApiLogApi.md#getLogs) | **GET** /logs | Get API execution log list |


<a id="getLog"></a>
# **getLog**
> ApiLog getLog(apiLogId)

Get API execution log

Retrieve the log of the API execution with the specified ID.

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
    String apiLogId = "apiLogId_example"; // String | API Log ID
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
| **apiLogId** | **String**| API Log ID | |

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
> ApiLogs getLogs(createdDate, createdAt, limit, cursor)

Get API execution log list

Retrieve the log of all API executions.

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
    LocalDate createdDate = LocalDate.now(); // LocalDate | The date, in format of YYYY-MM-DD, to retrieve the log.
    OffsetDateTime createdAt = OffsetDateTime.now(); // OffsetDateTime | The datetime, in ISO 8601 format, to retrieve the log.
    Long limit = 56L; // Long | Maximum number of logs to retrieve.
    String cursor = "cursor_example"; // String | Cursor for cursor pagination.
    try {
      ApiLogs result = apiInstance.getLogs(createdDate, createdAt, limit, cursor);
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

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createdDate** | **LocalDate**| The date, in format of YYYY-MM-DD, to retrieve the log. | [optional] |
| **createdAt** | **OffsetDateTime**| The datetime, in ISO 8601 format, to retrieve the log. | [optional] |
| **limit** | **Long**| Maximum number of logs to retrieve. | [optional] |
| **cursor** | **String**| Cursor for cursor pagination. | [optional] |

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

