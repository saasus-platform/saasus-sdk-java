# PricingPlansApi

All URIs are relative to *https://api.saasus.io/v1/pricing*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPricingPlan**](PricingPlansApi.md#createPricingPlan) | **POST** /plans | Create Pricing Plan |
| [**deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates**](PricingPlansApi.md#deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates) | **DELETE** /plans-initialization | Delete all Plans, Menus, Units, Meters and Tax Rates |
| [**deletePricingPlan**](PricingPlansApi.md#deletePricingPlan) | **DELETE** /plans/{plan_id} | Delete Pricing Plan |
| [**deleteStripePlan**](PricingPlansApi.md#deleteStripePlan) | **DELETE** /stripe | Delete Product Data from Stripe |
| [**getPricingPlan**](PricingPlansApi.md#getPricingPlan) | **GET** /plans/{plan_id} | Get Pricing Plan |
| [**getPricingPlans**](PricingPlansApi.md#getPricingPlans) | **GET** /plans | Get Pricing Plans |
| [**linkPlanToStripe**](PricingPlansApi.md#linkPlanToStripe) | **PATCH** /stripe/init | Connect to Stripe |
| [**updatePricingPlan**](PricingPlansApi.md#updatePricingPlan) | **PATCH** /plans/{plan_id} | Update Pricing Plan |
| [**updatePricingPlansUsed**](PricingPlansApi.md#updatePricingPlansUsed) | **PATCH** /plans/used | Update Used Flag |


<a id="createPricingPlan"></a>
# **createPricingPlan**
> PricingPlan createPricingPlan(body)

Create Pricing Plan

Create a pricing plan. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingPlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingPlansApi apiInstance = new PricingPlansApi(defaultClient);
    SavePricingPlanParam body = new SavePricingPlanParam(); // SavePricingPlanParam | 
    try {
      PricingPlan result = apiInstance.createPricingPlan(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingPlansApi#createPricingPlan");
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
| **body** | **SavePricingPlanParam**|  | [optional] |

### Return type

[**PricingPlan**](PricingPlan.md)

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

<a id="deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates"></a>
# **deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates**
> deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates()

Delete all Plans, Menus, Units, Meters and Tax Rates

Unconditionally remove all rate plans, menus, units, meters and tax rates. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingPlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingPlansApi apiInstance = new PricingPlansApi(defaultClient);
    try {
      apiInstance.deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates();
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingPlansApi#deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates");
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
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

<a id="deletePricingPlan"></a>
# **deletePricingPlan**
> deletePricingPlan(planId)

Delete Pricing Plan

Delete a pricing plan. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingPlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingPlansApi apiInstance = new PricingPlansApi(defaultClient);
    String planId = "planId_example"; // String | Pricing Plan ID
    try {
      apiInstance.deletePricingPlan(planId);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingPlansApi#deletePricingPlan");
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
| **planId** | **String**| Pricing Plan ID | |

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

<a id="deleteStripePlan"></a>
# **deleteStripePlan**
> deleteStripePlan()

Delete Product Data from Stripe

Delete product data from Stripe. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingPlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingPlansApi apiInstance = new PricingPlansApi(defaultClient);
    try {
      apiInstance.deleteStripePlan();
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingPlansApi#deleteStripePlan");
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
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

<a id="getPricingPlan"></a>
# **getPricingPlan**
> PricingPlan getPricingPlan(planId)

Get Pricing Plan

Get a pricing plan. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingPlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingPlansApi apiInstance = new PricingPlansApi(defaultClient);
    String planId = "planId_example"; // String | Pricing Plan ID
    try {
      PricingPlan result = apiInstance.getPricingPlan(planId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingPlansApi#getPricingPlan");
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
| **planId** | **String**| Pricing Plan ID | |

### Return type

[**PricingPlan**](PricingPlan.md)

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

<a id="getPricingPlans"></a>
# **getPricingPlans**
> PricingPlans getPricingPlans()

Get Pricing Plans

Get pricing plans. Multiple feature menus are grouped together and defined as one pricing plan. Each tenant can choose a pricing plan defined here. If you have a specific tenant-specific rate (private pricing), create and connect the pricing plan specifically for that tenant. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingPlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingPlansApi apiInstance = new PricingPlansApi(defaultClient);
    try {
      PricingPlans result = apiInstance.getPricingPlans();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingPlansApi#getPricingPlans");
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

[**PricingPlans**](PricingPlans.md)

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

<a id="linkPlanToStripe"></a>
# **linkPlanToStripe**
> linkPlanToStripe()

Connect to Stripe

Connect information to Stripe. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingPlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingPlansApi apiInstance = new PricingPlansApi(defaultClient);
    try {
      apiInstance.linkPlanToStripe();
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingPlansApi#linkPlanToStripe");
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
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

<a id="updatePricingPlan"></a>
# **updatePricingPlan**
> updatePricingPlan(planId, body)

Update Pricing Plan

Update a pricing plan. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingPlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingPlansApi apiInstance = new PricingPlansApi(defaultClient);
    String planId = "planId_example"; // String | Pricing Plan ID
    SavePricingPlanParam body = new SavePricingPlanParam(); // SavePricingPlanParam | 
    try {
      apiInstance.updatePricingPlan(planId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingPlansApi#updatePricingPlan");
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
| **planId** | **String**| Pricing Plan ID | |
| **body** | **SavePricingPlanParam**|  | [optional] |

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

<a id="updatePricingPlansUsed"></a>
# **updatePricingPlansUsed**
> updatePricingPlansUsed(updatePricingPlansUsedParam)

Update Used Flag

Update price plan and feature menu/pricing unit to used. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingPlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingPlansApi apiInstance = new PricingPlansApi(defaultClient);
    UpdatePricingPlansUsedParam updatePricingPlansUsedParam = new UpdatePricingPlansUsedParam(); // UpdatePricingPlansUsedParam | 
    try {
      apiInstance.updatePricingPlansUsed(updatePricingPlansUsedParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingPlansApi#updatePricingPlansUsed");
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
| **updatePricingPlansUsedParam** | [**UpdatePricingPlansUsedParam**](UpdatePricingPlansUsedParam.md)|  | [optional] |

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

