# TenantAttributeApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTenantAttribute**](TenantAttributeApi.md#createTenantAttribute) | **POST** /tenant-attributes | Create Tenant Attribute |
| [**deleteTenantAttribute**](TenantAttributeApi.md#deleteTenantAttribute) | **DELETE** /tenant-attributes/{attribute_name} | Delete Tenant Attribute |
| [**getTenantAttributes**](TenantAttributeApi.md#getTenantAttributes) | **GET** /tenant-attributes | Get Tenant Attributes |


<a id="createTenantAttribute"></a>
# **createTenantAttribute**
> Attribute createTenantAttribute(body)

Create Tenant Attribute

Register additional tenant attributes to be managed by SaaSus Platform. For example, tenant name, memo, etc., then get the attributes from SaaS using the SaaSus SDK/API. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantAttributeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantAttributeApi apiInstance = new TenantAttributeApi(defaultClient);
    Attribute body = new Attribute(); // Attribute | 
    try {
      Attribute result = apiInstance.createTenantAttribute(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantAttributeApi#createTenantAttribute");
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
| **body** | **Attribute**|  | [optional] |

### Return type

[**Attribute**](Attribute.md)

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

<a id="deleteTenantAttribute"></a>
# **deleteTenantAttribute**
> deleteTenantAttribute(attributeName)

Delete Tenant Attribute

Deletes tenant attributes managed by SaaSus Platform. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantAttributeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantAttributeApi apiInstance = new TenantAttributeApi(defaultClient);
    String attributeName = "birthday"; // String | Attribute Name
    try {
      apiInstance.deleteTenantAttribute(attributeName);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantAttributeApi#deleteTenantAttribute");
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
| **attributeName** | **String**| Attribute Name | |

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

<a id="getTenantAttributes"></a>
# **getTenantAttributes**
> TenantAttributes getTenantAttributes()

Get Tenant Attributes

Get definitions for additional tenant attributes managed by the SaaSus Platform. For example, tenant name, memo, etc., then get the attributes from SaaS using the SaaSus SDK/API. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantAttributeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantAttributeApi apiInstance = new TenantAttributeApi(defaultClient);
    try {
      TenantAttributes result = apiInstance.getTenantAttributes();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantAttributeApi#getTenantAttributes");
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

[**TenantAttributes**](TenantAttributes.md)

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

