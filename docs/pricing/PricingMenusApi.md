# PricingMenusApi

All URIs are relative to *https://api.saasus.io/v1/pricing*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPricingMenu**](PricingMenusApi.md#createPricingMenu) | **POST** /menus | Create a Pricing Feature Menu |
| [**deletePricingMenu**](PricingMenusApi.md#deletePricingMenu) | **DELETE** /menus/{menu_id} | Delete Pricing Feature Menu |
| [**getPricingMenu**](PricingMenusApi.md#getPricingMenu) | **GET** /menus/{menu_id} | Get Pricing Feature Menu |
| [**getPricingMenus**](PricingMenusApi.md#getPricingMenus) | **GET** /menus | Get Pricing Feature Menus |
| [**updatePricingMenu**](PricingMenusApi.md#updatePricingMenu) | **PATCH** /menus/{menu_id} | Update Pricing Feature Menu |


<a id="createPricingMenu"></a>
# **createPricingMenu**
> PricingMenu createPricingMenu(body)

Create a Pricing Feature Menu

Create a pricing feature menu. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingMenusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingMenusApi apiInstance = new PricingMenusApi(defaultClient);
    SavePricingMenuParam body = new SavePricingMenuParam(); // SavePricingMenuParam | 
    try {
      PricingMenu result = apiInstance.createPricingMenu(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingMenusApi#createPricingMenu");
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
| **body** | **SavePricingMenuParam**|  | [optional] |

### Return type

[**PricingMenu**](PricingMenu.md)

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

<a id="deletePricingMenu"></a>
# **deletePricingMenu**
> deletePricingMenu(menuId)

Delete Pricing Feature Menu

Delete pricing feature menu. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingMenusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingMenusApi apiInstance = new PricingMenusApi(defaultClient);
    String menuId = "menuId_example"; // String | Menu ID
    try {
      apiInstance.deletePricingMenu(menuId);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingMenusApi#deletePricingMenu");
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
| **menuId** | **String**| Menu ID | |

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

<a id="getPricingMenu"></a>
# **getPricingMenu**
> PricingMenu getPricingMenu(menuId)

Get Pricing Feature Menu

Get a pricing feature menu. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingMenusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingMenusApi apiInstance = new PricingMenusApi(defaultClient);
    String menuId = "menuId_example"; // String | Menu ID
    try {
      PricingMenu result = apiInstance.getPricingMenu(menuId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingMenusApi#getPricingMenu");
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
| **menuId** | **String**| Menu ID | |

### Return type

[**PricingMenu**](PricingMenu.md)

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

<a id="getPricingMenus"></a>
# **getPricingMenus**
> PricingMenus getPricingMenus()

Get Pricing Feature Menus

Get the feature menu list. Multiple measurement units are grouped together and defined as one feature menu. Multiple feature menus defined here are combined into one billing plan. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingMenusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingMenusApi apiInstance = new PricingMenusApi(defaultClient);
    try {
      PricingMenus result = apiInstance.getPricingMenus();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingMenusApi#getPricingMenus");
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

[**PricingMenus**](PricingMenus.md)

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

<a id="updatePricingMenu"></a>
# **updatePricingMenu**
> updatePricingMenu(menuId, body)

Update Pricing Feature Menu

Update pricing feature menu. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.PricingMenusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    PricingMenusApi apiInstance = new PricingMenusApi(defaultClient);
    String menuId = "menuId_example"; // String | Menu ID
    SavePricingMenuParam body = new SavePricingMenuParam(); // SavePricingMenuParam | 
    try {
      apiInstance.updatePricingMenu(menuId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling PricingMenusApi#updatePricingMenu");
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
| **menuId** | **String**| Menu ID | |
| **body** | **SavePricingMenuParam**|  | [optional] |

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

