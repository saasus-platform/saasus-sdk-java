# PricingPlansApi

All URIs are relative to *https://api.saasus.io/v1/pricing*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPricingPlan**](PricingPlansApi.md#createPricingPlan) | **POST** /plans | 料金プランを作成(Create Pricing Plan) |
| [**deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates**](PricingPlansApi.md#deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates) | **DELETE** /plans-initialization | 全てのPlans,Menus,Units,Metersの削除(Delete all Plans, Menus, Units, Meters and Tax Rates) |
| [**deletePricingPlan**](PricingPlansApi.md#deletePricingPlan) | **DELETE** /plans/{plan_id} | 料金プランを削除(Delete Pricing Plan) |
| [**deleteStripePlan**](PricingPlansApi.md#deleteStripePlan) | **DELETE** /stripe | stripe上の商品情報を削除(Delete Product Data from Stripe) |
| [**getPricingPlan**](PricingPlansApi.md#getPricingPlan) | **GET** /plans/{plan_id} | 料金プランを取得(Get Pricing Plan) |
| [**getPricingPlans**](PricingPlansApi.md#getPricingPlans) | **GET** /plans | 料金プラン一覧を取得(Get pricing plan list) |
| [**linkPlanToStripe**](PricingPlansApi.md#linkPlanToStripe) | **PATCH** /stripe/init | stripe連携(Connect to Stripe) |
| [**updatePricingPlan**](PricingPlansApi.md#updatePricingPlan) | **PATCH** /plans/{plan_id} | 料金プランを更新(Update Pricing Plan) |
| [**updatePricingPlansUsed**](PricingPlansApi.md#updatePricingPlansUsed) | **PATCH** /plans/used | 使用済みフラグ更新(Update Used Flag) |


<a id="createPricingPlan"></a>
# **createPricingPlan**
> PricingPlan createPricingPlan(body)

料金プランを作成(Create Pricing Plan)

料金プランを作成します。  Create pricing plan. 

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

全てのPlans,Menus,Units,Metersの削除(Delete all Plans, Menus, Units, Meters and Tax Rates)

無条件に全料金プラン、メニュー、ユニット、メーター、税率を削除します。  Unconditionally remove all rate plans, menus, units, meters and tax rates. 

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

料金プランを削除(Delete Pricing Plan)

料金プランを削除します。  Delete pricing plan. 

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
    String planId = "planId_example"; // String | 料金プランID(price plan ID)
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
| **planId** | **String**| 料金プランID(price plan ID) | |

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

stripe上の商品情報を削除(Delete Product Data from Stripe)

stripe上の商品情報を削除します。  Delete product data from Stripe. 

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

料金プランを取得(Get Pricing Plan)

料金プランを取得します。  Get pricing plan. 

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
    String planId = "planId_example"; // String | 料金プランID(price plan ID)
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
| **planId** | **String**| 料金プランID(price plan ID) | |

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

料金プラン一覧を取得(Get pricing plan list)

料金プラン一覧を取得します。 機能メニューを複数まとめて、１つの料金プランとして定義します。 ここで定義した料金プランを各テナントは選ぶことができます。 もし特定テナント特有の料金（プライベートプライシング）がある場合は、そのテナント専用の料金プランを作成して結びつけます。  Get pricing plans. Multiple feature menus are grouped together and defined as one pricing plan. Each tenant can choose a pricing plan defined here. If you have a specific tenant-specific rate (private pricing), create and connect the pricing plan specifically for that tenant. 

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

stripe連携(Connect to Stripe)

stripeへ情報を連携します。  Connect information to Stripe. 

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

料金プランを更新(Update Pricing Plan)

料金プランを更新します。  Update pricing plan. 

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
    String planId = "planId_example"; // String | 料金プランID(price plan ID)
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
| **planId** | **String**| 料金プランID(price plan ID) | |
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

使用済みフラグ更新(Update Used Flag)

料金プランと配下のメニュー・ユニットを使用済みに更新します。  Update price plan and feature menu/pricing unit to used. 

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

