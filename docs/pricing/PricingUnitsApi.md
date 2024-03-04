# PricingUnitsApi

All URIs are relative to *https://api.saasus.io/v1/pricing*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPricingUnit**](PricingUnitsApi.md#createPricingUnit) | **POST** /units | Create Pricing Unit |
| [**deletePricingUnit**](PricingUnitsApi.md#deletePricingUnit) | **DELETE** /units/{pricing_unit_id} | Delete Pricing Unit |
| [**getPricingUnit**](PricingUnitsApi.md#getPricingUnit) | **GET** /units/{pricing_unit_id} | Get Pricing Unit |
| [**getPricingUnits**](PricingUnitsApi.md#getPricingUnits) | **GET** /units | Get Pricing Units |
| [**updatePricingUnit**](PricingUnitsApi.md#updatePricingUnit) | **PATCH** /units/{pricing_unit_id} | Update Pricing Unit |


<a id="createPricingUnit"></a>
# **createPricingUnit**
> PricingUnit createPricingUnit(body)

Create Pricing Unit

Create a pricing unit. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingUnitsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingUnitsApi apiInstance = new PricingUnitsApi(defaultClient);
    PricingUnitForSave body = new PricingUnitForSave(); // PricingUnitForSave | 
    try {
      PricingUnit result = apiInstance.createPricingUnit(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingUnitsApi#createPricingUnit");
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
| **body** | **PricingUnitForSave**|  | [optional] |

### Return type

[**PricingUnit**](PricingUnit.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **500** | Internal Server Error |  -  |

<a id="deletePricingUnit"></a>
# **deletePricingUnit**
> deletePricingUnit(pricingUnitId)

Delete Pricing Unit

Delete a pricing unit. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingUnitsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingUnitsApi apiInstance = new PricingUnitsApi(defaultClient);
    String pricingUnitId = "pricingUnitId_example"; // String | Unit ID
    try {
      apiInstance.deletePricingUnit(pricingUnitId);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingUnitsApi#deletePricingUnit");
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
| **pricingUnitId** | **String**| Unit ID | |

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

<a id="getPricingUnit"></a>
# **getPricingUnit**
> PricingUnit getPricingUnit(pricingUnitId)

Get Pricing Unit

Get a pricing unit. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingUnitsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingUnitsApi apiInstance = new PricingUnitsApi(defaultClient);
    String pricingUnitId = "pricingUnitId_example"; // String | Unit ID
    try {
      PricingUnit result = apiInstance.getPricingUnit(pricingUnitId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingUnitsApi#getPricingUnit");
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
| **pricingUnitId** | **String**| Unit ID | |

### Return type

[**PricingUnit**](PricingUnit.md)

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

<a id="getPricingUnits"></a>
# **getPricingUnits**
> PricingUnits getPricingUnits()

Get Pricing Units

Gets the smallest unit of measure on which the charges are based. \&quot;Fixed Unit\&quot; (type&#x3D;fixed) is a unit of a monthly fixed charge such as a basic charge, \&quot;Usage Unit\&quot; (type&#x3D;usage) is a unit in which a charge is generated per unit such as billing for the number of users, \&quot;Tiered Unit\&quot; (type&#x3D;tiered) is a fixed charge unit for each tier of usage, such as the tiered packet charge for mobile phones, \&quot;Tiered Usage Unit\&quot; (type&#x3D;tiered_usage) is a unit where the charge per unit changes according to the usage amount, such as a volume discount. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingUnitsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingUnitsApi apiInstance = new PricingUnitsApi(defaultClient);
    try {
      PricingUnits result = apiInstance.getPricingUnits();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingUnitsApi#getPricingUnits");
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

[**PricingUnits**](PricingUnits.md)

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

<a id="updatePricingUnit"></a>
# **updatePricingUnit**
> updatePricingUnit(pricingUnitId, body)

Update Pricing Unit

Update pricing unit. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingUnitsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingUnitsApi apiInstance = new PricingUnitsApi(defaultClient);
    String pricingUnitId = "pricingUnitId_example"; // String | Unit ID
    PricingUnitForSave body = new PricingUnitForSave(); // PricingUnitForSave | 
    try {
      apiInstance.updatePricingUnit(pricingUnitId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingUnitsApi#updatePricingUnit");
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
| **pricingUnitId** | **String**| Unit ID | |
| **body** | **PricingUnitForSave**|  | [optional] |

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
| **500** | Internal Server Error |  -  |

