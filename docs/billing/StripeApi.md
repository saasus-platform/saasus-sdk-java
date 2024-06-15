# StripeApi

All URIs are relative to *https://api.saasus.io/v1/billing*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteStripeInfo**](StripeApi.md#deleteStripeInfo) | **DELETE** /stripe/info | Delete Stripe Connection |
| [**getStripeInfo**](StripeApi.md#getStripeInfo) | **GET** /stripe/info | Get Stripe Connection information |
| [**updateStripeInfo**](StripeApi.md#updateStripeInfo) | **PUT** /stripe/info | Update Stripe Connection Info |


<a id="deleteStripeInfo"></a>
# **deleteStripeInfo**
> deleteStripeInfo()

Delete Stripe Connection

Delete connection with external billing SaaS 

### Example
```java
// Import classes:
import saasus.sdk.billing.ApiClient;
import saasus.sdk.billing.ApiException;
import saasus.sdk.billing.Configuration;
import saasus.sdk.billing.auth.*;
import saasus.sdk.billing.models.*;
import saasus.sdk.billing.api.StripeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/billing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    StripeApi apiInstance = new StripeApi(defaultClient);
    try {
      apiInstance.deleteStripeInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling StripeApi#deleteStripeInfo");
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

<a id="getStripeInfo"></a>
# **getStripeInfo**
> StripeInfo getStripeInfo()

Get Stripe Connection information

Get information on connnections with external billing SaaS. Currently possible to integrate with Stripe. Without integration, you will need to implement billing using the SaaSus SDK/API. 

### Example
```java
// Import classes:
import saasus.sdk.billing.ApiClient;
import saasus.sdk.billing.ApiException;
import saasus.sdk.billing.Configuration;
import saasus.sdk.billing.auth.*;
import saasus.sdk.billing.models.*;
import saasus.sdk.billing.api.StripeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/billing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    StripeApi apiInstance = new StripeApi(defaultClient);
    try {
      StripeInfo result = apiInstance.getStripeInfo();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StripeApi#getStripeInfo");
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

[**StripeInfo**](StripeInfo.md)

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

<a id="updateStripeInfo"></a>
# **updateStripeInfo**
> updateStripeInfo(updateStripeInfoParam)

Update Stripe Connection Info

Updates information on connection with external billing SaaS. Currently possible to connect to Stripe. 

### Example
```java
// Import classes:
import saasus.sdk.billing.ApiClient;
import saasus.sdk.billing.ApiException;
import saasus.sdk.billing.Configuration;
import saasus.sdk.billing.auth.*;
import saasus.sdk.billing.models.*;
import saasus.sdk.billing.api.StripeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/billing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    StripeApi apiInstance = new StripeApi(defaultClient);
    UpdateStripeInfoParam updateStripeInfoParam = new UpdateStripeInfoParam(); // UpdateStripeInfoParam | 
    try {
      apiInstance.updateStripeInfo(updateStripeInfoParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling StripeApi#updateStripeInfo");
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
| **updateStripeInfoParam** | [**UpdateStripeInfoParam**](UpdateStripeInfoParam.md)|  | [optional] |

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

