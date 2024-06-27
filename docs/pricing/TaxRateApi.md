# TaxRateApi

All URIs are relative to *https://api.saasus.io/v1/pricing*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTaxRate**](TaxRateApi.md#createTaxRate) | **POST** /tax-rates | Create Tax Rate |
| [**getTaxRates**](TaxRateApi.md#getTaxRates) | **GET** /tax-rates | Get Tax Rates |
| [**updateTaxRate**](TaxRateApi.md#updateTaxRate) | **PATCH** /tax-rates/{tax_rate_id} | Update Tax Rate |


<a id="createTaxRate"></a>
# **createTaxRate**
> TaxRate createTaxRate(body)

Create Tax Rate

Creates a tax rate. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.TaxRateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TaxRateApi apiInstance = new TaxRateApi(defaultClient);
    TaxRateProps body = new TaxRateProps(); // TaxRateProps | 
    try {
      TaxRate result = apiInstance.createTaxRate(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaxRateApi#createTaxRate");
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
| **body** | **TaxRateProps**|  | [optional] |

### Return type

[**TaxRate**](TaxRate.md)

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

<a id="getTaxRates"></a>
# **getTaxRates**
> TaxRates getTaxRates()

Get Tax Rates

Get all Tax Rates 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.TaxRateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TaxRateApi apiInstance = new TaxRateApi(defaultClient);
    try {
      TaxRates result = apiInstance.getTaxRates();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaxRateApi#getTaxRates");
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

[**TaxRates**](TaxRates.md)

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

<a id="updateTaxRate"></a>
# **updateTaxRate**
> updateTaxRate(taxRateId, updateTaxRateParam)

Update Tax Rate

Update tax rate. 

### Example
```java
// Import classes:
import saasus.sdk.pricing.ApiClient;
import saasus.sdk.pricing.ApiException;
import saasus.sdk.pricing.Configuration;
import saasus.sdk.pricing.auth.*;
import saasus.sdk.pricing.models.*;
import saasus.sdk.pricing.api.TaxRateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/pricing");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TaxRateApi apiInstance = new TaxRateApi(defaultClient);
    String taxRateId = "taxRateId_example"; // String | Tax Rate ID
    UpdateTaxRateParam updateTaxRateParam = new UpdateTaxRateParam(); // UpdateTaxRateParam | 
    try {
      apiInstance.updateTaxRate(taxRateId, updateTaxRateParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaxRateApi#updateTaxRate");
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
| **taxRateId** | **String**| Tax Rate ID | |
| **updateTaxRateParam** | [**UpdateTaxRateParam**](UpdateTaxRateParam.md)|  | [optional] |

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

