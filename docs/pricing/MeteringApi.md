# MeteringApi

All URIs are relative to *https://api.saasus.io/v1/pricing*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteMeteringUnitTimestampCount**](MeteringApi.md#deleteMeteringUnitTimestampCount) | **DELETE** /metering/tenants/{tenant_id}/units/{metering_unit_name}/timestamp/{timestamp} | 指定したタイムスタンプのメータリングユニットカウントを削除(Delete Metering Uunit Count for Specified Timestamp) |
| [**getMeteringUnitDateCountByTenantIdAndUnitNameAndDate**](MeteringApi.md#getMeteringUnitDateCountByTenantIdAndUnitNameAndDate) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/date/{date} | 指定した日付のメータリングユニットカウントを取得(Get Metering Unit Count for Specific Date) |
| [**getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod**](MeteringApi.md#getMeteringUnitDateCountByTenantIdAndUnitNameAndDatePeriod) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/date-period | 指定した日時期間のメータリングユニットカウントを取得(Obtain metering unit counts for a specified date/time period) |
| [**getMeteringUnitDateCountByTenantIdAndUnitNameToday**](MeteringApi.md#getMeteringUnitDateCountByTenantIdAndUnitNameToday) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/today | 当日のメータリングユニットカウントを取得(Get Metering Unit Count for the Current Day) |
| [**getMeteringUnitDateCountsByTenantIdAndDate**](MeteringApi.md#getMeteringUnitDateCountsByTenantIdAndDate) | **GET** /metering/tenants/{tenant_id}/units/date/{date} | 指定日の全メータリングユニットカウントを取得(Get All Metering Unit Counts for a Specified Date) |
| [**getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth**](MeteringApi.md#getMeteringUnitMonthCountByTenantIdAndUnitNameAndMonth) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/month/{month} | 指定月のメータリングユニットカウントを取得(Get the Metering Unit Count for the Specified Month) |
| [**getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth**](MeteringApi.md#getMeteringUnitMonthCountByTenantIdAndUnitNameThisMonth) | **GET** /metering/tenants/{tenant_id}/units/{metering_unit_name}/thismonth | 当月のメータリングユニットカウントを取得(Get Metering Unit Count for the Current Month) |
| [**getMeteringUnitMonthCountsByTenantIdAndMonth**](MeteringApi.md#getMeteringUnitMonthCountsByTenantIdAndMonth) | **GET** /metering/tenants/{tenant_id}/units/month/{month} | 指定月の全メータリングユニットカウントを取得(Get All Metering Unit Counts for the Specified Month) |
| [**updateMeteringUnitTimestampCount**](MeteringApi.md#updateMeteringUnitTimestampCount) | **PUT** /metering/tenants/{tenant_id}/units/{metering_unit_name}/timestamp/{timestamp} | 指定したタイムスタンプのメータリングユニットカウントを更新(Update Metering Unit Count for Specified Timestamp) |
| [**updateMeteringUnitTimestampCountNow**](MeteringApi.md#updateMeteringUnitTimestampCountNow) | **PUT** /metering/tenants/{tenant_id}/units/{metering_unit_name}/now | 現在時刻のメータリングユニットカウントを更新(Update Metering Unit Count for Current Time) |


<a id="deleteMeteringUnitTimestampCount"></a>
# **deleteMeteringUnitTimestampCount**
> deleteMeteringUnitTimestampCount(tenantId, meteringUnitName, timestamp)

指定したタイムスタンプのメータリングユニットカウントを削除(Delete Metering Uunit Count for Specified Timestamp)

指定したタイムスタンプのメータリングユニットカウントを削除します。  Deletes metering unit count for the specified timestamp. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String meteringUnitName = "storage_unit"; // String | 計測ユニット名(metering unit name)
    Integer timestamp = 1640995200; // Integer | タイムスタンプ(timestamp)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **meteringUnitName** | **String**| 計測ユニット名(metering unit name) | |
| **timestamp** | **Integer**| タイムスタンプ(timestamp) | |

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

指定した日付のメータリングユニットカウントを取得(Get Metering Unit Count for Specific Date)

指定した日付のメータリングユニットカウントを取得します。  Gets the metering unit count for specific date. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String meteringUnitName = "storage_unit"; // String | 計測ユニット名(metering unit name)
    String date = "2022-01-01"; // String | 日(date)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **meteringUnitName** | **String**| 計測ユニット名(metering unit name) | |
| **date** | **String**| 日(date) | |

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

指定した日時期間のメータリングユニットカウントを取得(Obtain metering unit counts for a specified date/time period)

指定した日時期間のメータリングユニットカウントを取得します。  Obtain metering unit counts for a specified date/time period. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String meteringUnitName = "storage_unit"; // String | 計測ユニット名(metering unit name)
    Integer startTimestamp = 1640995200; // Integer | 開始日時(timestamp)
    Integer endTimestamp = 1640995200; // Integer | 終了日時(timestamp)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **meteringUnitName** | **String**| 計測ユニット名(metering unit name) | |
| **startTimestamp** | **Integer**| 開始日時(timestamp) | [optional] |
| **endTimestamp** | **Integer**| 終了日時(timestamp) | [optional] |

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

当日のメータリングユニットカウントを取得(Get Metering Unit Count for the Current Day)

当日のメータリングユニットカウントを取得します。  Get the metering unit count for the current day. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String meteringUnitName = "storage_unit"; // String | 計測ユニット名(metering unit name)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **meteringUnitName** | **String**| 計測ユニット名(metering unit name) | |

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

指定日の全メータリングユニットカウントを取得(Get All Metering Unit Counts for a Specified Date)

指定した日の全メータリングユニットカウントを取得します。  Gets the total metering unit count for the specified date. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String date = "2022-01-01"; // String | 日(date)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **date** | **String**| 日(date) | |

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

指定月のメータリングユニットカウントを取得(Get the Metering Unit Count for the Specified Month)

指定した月のメータリングユニットカウントを取得します。  Gets the metering unit count for the specified month. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String meteringUnitName = "storage_unit"; // String | 計測ユニット名(metering unit name)
    String month = "2022-01"; // String | 月(month)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **meteringUnitName** | **String**| 計測ユニット名(metering unit name) | |
| **month** | **String**| 月(month) | |

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

当月のメータリングユニットカウントを取得(Get Metering Unit Count for the Current Month)

当月のメータリングユニットカウントを取得します。  Get the metering unit count for the current month. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String meteringUnitName = "storage_unit"; // String | 計測ユニット名(metering unit name)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **meteringUnitName** | **String**| 計測ユニット名(metering unit name) | |

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

指定月の全メータリングユニットカウントを取得(Get All Metering Unit Counts for the Specified Month)

指定した月の全メータリングユニットカウントを取得します。  Gets all metering unit counts for the specified month. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String month = "2022-01"; // String | 月(month)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **month** | **String**| 月(month) | |

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

<a id="updateMeteringUnitTimestampCount"></a>
# **updateMeteringUnitTimestampCount**
> MeteringUnitTimestampCount updateMeteringUnitTimestampCount(tenantId, meteringUnitName, timestamp, updateMeteringUnitTimestampCountParam)

指定したタイムスタンプのメータリングユニットカウントを更新(Update Metering Unit Count for Specified Timestamp)

指定したタイムスタンプのメータリングユニットカウントを更新します。  Update metering unit count for the specified timestamp. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String meteringUnitName = "storage_unit"; // String | 計測ユニット名(metering unit name)
    Integer timestamp = 1640995200; // Integer | タイムスタンプ(timestamp)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **meteringUnitName** | **String**| 計測ユニット名(metering unit name) | |
| **timestamp** | **Integer**| タイムスタンプ(timestamp) | |
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

現在時刻のメータリングユニットカウントを更新(Update Metering Unit Count for Current Time)

現在時刻のメータリングユニットカウントを更新します。  Update the metering unit count for the current time. 

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
    String tenantId = "46af35b5-60de-4cd8-9412-19a3a5d1f838"; // String | テナントID(tenant id)
    String meteringUnitName = "storage_unit"; // String | 計測ユニット名(metering unit name)
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
| **tenantId** | **String**| テナントID(tenant id) | |
| **meteringUnitName** | **String**| 計測ユニット名(metering unit name) | |
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

