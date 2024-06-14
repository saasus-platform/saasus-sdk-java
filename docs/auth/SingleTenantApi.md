# SingleTenantApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getCloudFormationLaunchStackLinkForSingleTenant**](SingleTenantApi.md#getCloudFormationLaunchStackLinkForSingleTenant) | **GET** /single-tenant/cloudformation-launch-stack-link | Get CloudFormation Stack Launch Link For Single Tenant |
| [**getSingleTenantSettings**](SingleTenantApi.md#getSingleTenantSettings) | **GET** /single-tenant/settings | Retrieve the settings of the single tenant. |
| [**updateSingleTenantSettings**](SingleTenantApi.md#updateSingleTenantSettings) | **PATCH** /single-tenant/settings | Update configuration information for single-tenant functionality |


<a id="getCloudFormationLaunchStackLinkForSingleTenant"></a>
# **getCloudFormationLaunchStackLinkForSingleTenant**
> CloudFormationLaunchStackLink getCloudFormationLaunchStackLinkForSingleTenant()

Get CloudFormation Stack Launch Link For Single Tenant

Get the CloudFormation stack activation link for Single Tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SingleTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SingleTenantApi apiInstance = new SingleTenantApi(defaultClient);
    try {
      CloudFormationLaunchStackLink result = apiInstance.getCloudFormationLaunchStackLinkForSingleTenant();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SingleTenantApi#getCloudFormationLaunchStackLinkForSingleTenant");
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

[**CloudFormationLaunchStackLink**](CloudFormationLaunchStackLink.md)

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

<a id="getSingleTenantSettings"></a>
# **getSingleTenantSettings**
> SingleTenantSettings getSingleTenantSettings()

Retrieve the settings of the single tenant.

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SingleTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SingleTenantApi apiInstance = new SingleTenantApi(defaultClient);
    try {
      SingleTenantSettings result = apiInstance.getSingleTenantSettings();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SingleTenantApi#getSingleTenantSettings");
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

[**SingleTenantSettings**](SingleTenantSettings.md)

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

<a id="updateSingleTenantSettings"></a>
# **updateSingleTenantSettings**
> updateSingleTenantSettings(updateSingleTenantSettingsParam)

Update configuration information for single-tenant functionality

Updates configuration information for single-tenant functionality Returns error if single tenant feature cannot be enabled. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SingleTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SingleTenantApi apiInstance = new SingleTenantApi(defaultClient);
    UpdateSingleTenantSettingsParam updateSingleTenantSettingsParam = new UpdateSingleTenantSettingsParam(); // UpdateSingleTenantSettingsParam | 
    try {
      apiInstance.updateSingleTenantSettings(updateSingleTenantSettingsParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SingleTenantApi#updateSingleTenantSettings");
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
| **updateSingleTenantSettingsParam** | [**UpdateSingleTenantSettingsParam**](UpdateSingleTenantSettingsParam.md)|  | [optional] |

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

