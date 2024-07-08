# MeteringApi

All URIs are relative to *https://api.saasus.io/v1/pricing*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createMeteringUnit**](MeteringApi.md#createMeteringUnit) | **POST** /metering/units | Create Metering Unit |
| [**deleteMeteringUnitByID**](MeteringApi.md#deleteMeteringUnitByID) | **DELETE** /metering/units/{metering_unit_id} | Delete Metering Unit |
| [**deleteMeteringUnitTimestampCount**](MeteringApi.md#deleteMeteringUnitTimestampCount) | **DELETE** /metering/tenants/{tenant_id}/units/{metering_unit_name}/timestamp/{timestamp} | Delete Metering Unit Count for Specified Timestamp |
| [**getMeteringUnitDateCountByTenantIdAndUnitNameAndDate**](MeteringApi.md#getMeteringUnitDateCountByTenantIdAndUnitNameAndDate) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/date/{date} | Get Metering Unit Count for Specific Date |
| [**getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod**](MeteringApi.md#getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/date-period | Obtain metering unit counts for a specified date/time period |
| [**getMeteringUnitDateCountByTenantIdAndUnitNameToday**](MeteringApi.md#getMeteringUnitDateCountByTenantIdAndUnitNameToday) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/today | Get Metering Unit Count for the Current Day |
| [**getMeteringUnitDateCountsByTenantIdAndDate**](MeteringApi.md#getMeteringUnitDateCountsByTenantIdAndDate) | **GET** /metering/tenants/{tenant_id}/units/date/{date} | Get All Metering Unit Counts for a Specified Date |
| [**getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth**](MeteringApi.md#getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/month/{month} | Get the Metering Unit Count for the Specified Month |
| [**getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth**](MeteringApi.md#getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/thismonth | Get Metering Unit Count for the Current Month |
| [**getMeteringUnitMonthCountsByTenantIdAndMonth**](MeteringApi.md#getMeteringUnitMonthCountsByTenantIdAndMonth) | **GET** /metering/tenants/{tenant_id}/units/month/{month} | Get All Metering Unit Counts for the Specified Month |
| [**getMeteringUnits**](MeteringApi.md#getMeteringUnits) | **GET** /metering/units | Get all metering units |
| [**updateMeteringUnitByID**](MeteringApi.md#updateMeteringUnitByID) | **PATCH** /metering/units/{metering_unit_id} | Update Metering Unit |
| [**updateMeteringUnitTimestampCount**](MeteringApi.md#updateMeteringUnitTimestampCount) | **PUT** /metering/tenants/{tenant_id}/units/{metering_unit_name}/timestamp/{timestamp} | Update Metering Unit Count for Specified Timestamp |
| [**updateMeteringUnitTimestampCountNow**](MeteringApi.md#updateMeteringUnitTimestampCountNow) | **PUT** /metering/tenants/{tenant_id}/units/{metering_unit_name}/now | Update Metering Unit Count for Current Time |


<a id="createMeteringUnit"></a>
# **createMeteringUnit**
> MeteringUnit createMeteringUnit(body)

Create Metering Unit

Create a metering unit. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    MeteringUnitProps body = new MeteringUnitProps(); // MeteringUnitProps | 
    try {
      MeteringUnit result = apiInstance.createMeteringUnit(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#createMeteringUnit");
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
| **body** | **MeteringUnitProps**|  | [optional] |

### Return type

[**MeteringUnit**](MeteringUnit.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

<a id="deleteMeteringUnitByID"></a>
# **deleteMeteringUnitByID**
> deleteMeteringUnitByID(meteringUnitId)

Delete Metering Unit

Delete metering unit. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String meteringUnitId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Metering Unit ID
    try {
      apiInstance.deleteMeteringUnitByID(meteringUnitId);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#deleteMeteringUnitByID");
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
| **meteringUnitId** | **String**| Metering Unit ID | |

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
| **200** | OK |  -  |
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

<a id="deleteMeteringUnitTimestampCount"></a>
# **deleteMeteringUnitTimestampCount**
> deleteMeteringUnitTimestampCount(tenantId, meteringUnitName, timestamp)

Delete Metering Unit Count for Specified Timestamp

Deletes metering unit count for the specified timestamp. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String meteringUnitName = "storage_unit"; // String | Metering Unit Name
    Integer timestamp = 1640995200; // Integer | Timestamp
    try {
      apiInstance.deleteMeteringUnitTimestampCount(tenantId, meteringUnitName, timestamp);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#deleteMeteringUnitTimestampCount");
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
| **tenantId** | **String**| Tenant ID | |
| **meteringUnitName** | **String**| Metering Unit Name | |
| **timestamp** | **Integer**| Timestamp | |

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
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

<a id="getMeteringUnitDateCountByTenantIdAndUnitNameAndDate"></a>
# **getMeteringUnitDateCountByTenantIdAndUnitNameAndDate**
> MeteringUnitDateCount getMeteringUnitDateCountByTenantIdAndUnitNameAndDate(tenantId, meteringUnitName, date)

Get Metering Unit Count for Specific Date

Gets the metering unit count for a specific date. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String meteringUnitName = "storage_unit"; // String | Metering Unit Name
    String date = "2022-01-01"; // String | Date
    try {
      MeteringUnitDateCount result = apiInstance.getMeteringUnitDateCountByTenantIdAndUnitNameAndDate(tenantId, meteringUnitName, date);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#getMeteringUnitDateCountByTenantIdAndUnitNameAndDate");
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
| **tenantId** | **String**| Tenant ID | |
| **meteringUnitName** | **String**| Metering Unit Name | |
| **date** | **String**| Date | |

### Return type

[**MeteringUnitDateCount**](MeteringUnitDateCount.md)

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

<a id="getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod"></a>
# **getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod**
> MeteringUnitDatePeriodCounts getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod(tenantId, meteringUnitName, startTimestamp, endTimestamp)

Obtain metering unit counts for a specified date/time period

Obtain metering unit counts for a specified date/time period. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String meteringUnitName = "storage_unit"; // String | Metering Unit Name
    Integer startTimestamp = 1640995200; // Integer | Start Date-Time
    Integer endTimestamp = 1640995200; // Integer | End Date-Time
    try {
      MeteringUnitDatePeriodCounts result = apiInstance.getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod(tenantId, meteringUnitName, startTimestamp, endTimestamp);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod");
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
| **tenantId** | **String**| Tenant ID | |
| **meteringUnitName** | **String**| Metering Unit Name | |
| **startTimestamp** | **Integer**| Start Date-Time | [optional] |
| **endTimestamp** | **Integer**| End Date-Time | [optional] |

### Return type

[**MeteringUnitDatePeriodCounts**](MeteringUnitDatePeriodCounts.md)

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

<a id="getMeteringUnitDateCountByTenantIdAndUnitNameToday"></a>
# **getMeteringUnitDateCountByTenantIdAndUnitNameToday**
> MeteringUnitDateCount getMeteringUnitDateCountByTenantIdAndUnitNameToday(tenantId, meteringUnitName)

Get Metering Unit Count for the Current Day

Get the metering unit count for the current day. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String meteringUnitName = "storage_unit"; // String | Metering Unit Name
    try {
      MeteringUnitDateCount result = apiInstance.getMeteringUnitDateCountByTenantIdAndUnitNameToday(tenantId, meteringUnitName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#getMeteringUnitDateCountByTenantIdAndUnitNameToday");
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
| **tenantId** | **String**| Tenant ID | |
| **meteringUnitName** | **String**| Metering Unit Name | |

### Return type

[**MeteringUnitDateCount**](MeteringUnitDateCount.md)

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

<a id="getMeteringUnitDateCountsByTenantIdAndDate"></a>
# **getMeteringUnitDateCountsByTenantIdAndDate**
> MeteringUnitDateCounts getMeteringUnitDateCountsByTenantIdAndDate(tenantId, date)

Get All Metering Unit Counts for a Specified Date

Gets the total metering unit count for the specified date. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String date = "2022-01-01"; // String | Date
    try {
      MeteringUnitDateCounts result = apiInstance.getMeteringUnitDateCountsByTenantIdAndDate(tenantId, date);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#getMeteringUnitDateCountsByTenantIdAndDate");
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
| **tenantId** | **String**| Tenant ID | |
| **date** | **String**| Date | |

### Return type

[**MeteringUnitDateCounts**](MeteringUnitDateCounts.md)

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

<a id="getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth"></a>
# **getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth**
> MeteringUnitMonthCount getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth(tenantId, meteringUnitName, month)

Get the Metering Unit Count for the Specified Month

Gets the metering unit count for the specified month. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String meteringUnitName = "storage_unit"; // String | Metering Unit Name
    String month = "2022-01"; // String | Month
    try {
      MeteringUnitMonthCount result = apiInstance.getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth(tenantId, meteringUnitName, month);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth");
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
| **tenantId** | **String**| Tenant ID | |
| **meteringUnitName** | **String**| Metering Unit Name | |
| **month** | **String**| Month | |

### Return type

[**MeteringUnitMonthCount**](MeteringUnitMonthCount.md)

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

<a id="getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth"></a>
# **getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth**
> MeteringUnitMonthCount getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth(tenantId, meteringUnitName)

Get Metering Unit Count for the Current Month

Get the metering unit count for the current month. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String meteringUnitName = "storage_unit"; // String | Metering Unit Name
    try {
      MeteringUnitMonthCount result = apiInstance.getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth(tenantId, meteringUnitName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth");
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
| **tenantId** | **String**| Tenant ID | |
| **meteringUnitName** | **String**| Metering Unit Name | |

### Return type

[**MeteringUnitMonthCount**](MeteringUnitMonthCount.md)

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

<a id="getMeteringUnitMonthCountsByTenantIdAndMonth"></a>
# **getMeteringUnitMonthCountsByTenantIdAndMonth**
> MeteringUnitMonthCounts getMeteringUnitMonthCountsByTenantIdAndMonth(tenantId, month)

Get All Metering Unit Counts for the Specified Month

Gets all metering unit counts for the specified month. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String month = "2022-01"; // String | Month
    try {
      MeteringUnitMonthCounts result = apiInstance.getMeteringUnitMonthCountsByTenantIdAndMonth(tenantId, month);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#getMeteringUnitMonthCountsByTenantIdAndMonth");
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
| **tenantId** | **String**| Tenant ID | |
| **month** | **String**| Month | |

### Return type

[**MeteringUnitMonthCounts**](MeteringUnitMonthCounts.md)

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

<a id="getMeteringUnits"></a>
# **getMeteringUnits**
> MeteringUnits getMeteringUnits()

Get all metering units

Get all metering units. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    try {
      MeteringUnits result = apiInstance.getMeteringUnits();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#getMeteringUnits");
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

[**MeteringUnits**](MeteringUnits.md)

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

<a id="updateMeteringUnitByID"></a>
# **updateMeteringUnitByID**
> updateMeteringUnitByID(meteringUnitId, body)

Update Metering Unit

Update metering unit. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String meteringUnitId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Metering Unit ID
    MeteringUnitProps body = new MeteringUnitProps(); // MeteringUnitProps | 
    try {
      apiInstance.updateMeteringUnitByID(meteringUnitId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#updateMeteringUnitByID");
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
| **meteringUnitId** | **String**| Metering Unit ID | |
| **body** | **MeteringUnitProps**|  | [optional] |

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

<a id="updateMeteringUnitTimestampCount"></a>
# **updateMeteringUnitTimestampCount**
> MeteringUnitTimestampCount updateMeteringUnitTimestampCount(tenantId, meteringUnitName, timestamp, updateMeteringUnitTimestampCountParam)

Update Metering Unit Count for Specified Timestamp

Update metering unit count for the specified timestamp. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String meteringUnitName = "storage_unit"; // String | Metering Unit Name
    Integer timestamp = 1640995200; // Integer | Timestamp
    UpdateMeteringUnitTimestampCountParam updateMeteringUnitTimestampCountParam = new UpdateMeteringUnitTimestampCountParam(); // UpdateMeteringUnitTimestampCountParam | 
    try {
      MeteringUnitTimestampCount result = apiInstance.updateMeteringUnitTimestampCount(tenantId, meteringUnitName, timestamp, updateMeteringUnitTimestampCountParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#updateMeteringUnitTimestampCount");
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
| **tenantId** | **String**| Tenant ID | |
| **meteringUnitName** | **String**| Metering Unit Name | |
| **timestamp** | **Integer**| Timestamp | |
| **updateMeteringUnitTimestampCountParam** | [**UpdateMeteringUnitTimestampCountParam**](UpdateMeteringUnitTimestampCountParam.md)|  | [optional] |

### Return type

[**MeteringUnitTimestampCount**](MeteringUnitTimestampCount.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

<a id="updateMeteringUnitTimestampCountNow"></a>
# **updateMeteringUnitTimestampCountNow**
> MeteringUnitTimestampCount updateMeteringUnitTimestampCountNow(tenantId, meteringUnitName, updateMeteringUnitTimestampCountNowParam)

Update Metering Unit Count for Current Time

Update the metering unit count for the current time. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.MeteringApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MeteringApi apiInstance = new MeteringApi(defaultClient);
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | Tenant ID
    String meteringUnitName = "storage_unit"; // String | Metering Unit Name
    UpdateMeteringUnitTimestampCountNowParam updateMeteringUnitTimestampCountNowParam = new UpdateMeteringUnitTimestampCountNowParam(); // UpdateMeteringUnitTimestampCountNowParam | 
    try {
      MeteringUnitTimestampCount result = apiInstance.updateMeteringUnitTimestampCountNow(tenantId, meteringUnitName, updateMeteringUnitTimestampCountNowParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MeteringApi#updateMeteringUnitTimestampCountNow");
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
| **tenantId** | **String**| Tenant ID | |
| **meteringUnitName** | **String**| Metering Unit Name | |
| **updateMeteringUnitTimestampCountNowParam** | [**UpdateMeteringUnitTimestampCountNowParam**](UpdateMeteringUnitTimestampCountNowParam.md)|  | [optional] |

### Return type

[**MeteringUnitTimestampCount**](MeteringUnitTimestampCount.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

