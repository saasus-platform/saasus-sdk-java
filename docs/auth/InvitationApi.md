# InvitationApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTenantInvitation**](InvitationApi.md#createTenantInvitation) | **POST** /tenants/{tenant_id}/invitations | Create Tenant Invitation |
| [**deleteTenantInvitation**](InvitationApi.md#deleteTenantInvitation) | **DELETE** /tenants/{tenant_id}/invitations/{invitation_id} | Delete Tenant Invitation |
| [**getInvitationValidity**](InvitationApi.md#getInvitationValidity) | **GET** /invitations/{invitation_id}/validity | Get Invitation Validity |
| [**getTenantInvitation**](InvitationApi.md#getTenantInvitation) | **GET** /tenants/{tenant_id}/invitations/{invitation_id} | Get Tenant Invitation |
| [**getTenantInvitations**](InvitationApi.md#getTenantInvitations) | **GET** /tenants/{tenant_id}/invitations | Get Tenant Invitations |
| [**validateInvitation**](InvitationApi.md#validateInvitation) | **PATCH** /invitations/{invitation_id}/validate | Validate Invitation |


<a id="createTenantInvitation"></a>
# **createTenantInvitation**
> Invitation createTenantInvitation(tenantId, createTenantInvitationParam)

Create Tenant Invitation

Create an invitation to the tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.InvitationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    InvitationApi apiInstance = new InvitationApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    CreateTenantInvitationParam createTenantInvitationParam = new CreateTenantInvitationParam(); // CreateTenantInvitationParam | 
    try {
      Invitation result = apiInstance.createTenantInvitation(tenantId, createTenantInvitationParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InvitationApi#createTenantInvitation");
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
| **createTenantInvitationParam** | [**CreateTenantInvitationParam**](CreateTenantInvitationParam.md)|  | [optional] |

### Return type

[**Invitation**](Invitation.md)

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

<a id="deleteTenantInvitation"></a>
# **deleteTenantInvitation**
> deleteTenantInvitation(tenantId, invitationId)

Delete Tenant Invitation

Delete an invitation for the tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.InvitationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    InvitationApi apiInstance = new InvitationApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    String invitationId = "invitationId_example"; // String | Invitation ID
    try {
      apiInstance.deleteTenantInvitation(tenantId, invitationId);
    } catch (ApiException e) {
      System.err.println("Exception when calling InvitationApi#deleteTenantInvitation");
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
| **invitationId** | **String**| Invitation ID | |

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

<a id="getInvitationValidity"></a>
# **getInvitationValidity**
> InvitationValidity getInvitationValidity(invitationId)

Get Invitation Validity

Get the validity of an invitation to the tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.InvitationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    InvitationApi apiInstance = new InvitationApi(defaultClient);
    String invitationId = "invitationId_example"; // String | Invitation ID
    try {
      InvitationValidity result = apiInstance.getInvitationValidity(invitationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InvitationApi#getInvitationValidity");
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
| **invitationId** | **String**| Invitation ID | |

### Return type

[**InvitationValidity**](InvitationValidity.md)

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

<a id="getTenantInvitation"></a>
# **getTenantInvitation**
> Invitation getTenantInvitation(tenantId, invitationId)

Get Tenant Invitation

Get invitation information for the tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.InvitationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    InvitationApi apiInstance = new InvitationApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    String invitationId = "invitationId_example"; // String | Invitation ID
    try {
      Invitation result = apiInstance.getTenantInvitation(tenantId, invitationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InvitationApi#getTenantInvitation");
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
| **invitationId** | **String**| Invitation ID | |

### Return type

[**Invitation**](Invitation.md)

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

<a id="getTenantInvitations"></a>
# **getTenantInvitations**
> Invitations getTenantInvitations(tenantId)

Get Tenant Invitations

Get a list of invitations to the tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.InvitationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    InvitationApi apiInstance = new InvitationApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    try {
      Invitations result = apiInstance.getTenantInvitations(tenantId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InvitationApi#getTenantInvitations");
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

### Return type

[**Invitations**](Invitations.md)

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

<a id="validateInvitation"></a>
# **validateInvitation**
> validateInvitation(invitationId, validateInvitationParam)

Validate Invitation

Validate an invitation to the tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.InvitationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    InvitationApi apiInstance = new InvitationApi(defaultClient);
    String invitationId = "invitationId_example"; // String | Invitation ID
    ValidateInvitationParam validateInvitationParam = new ValidateInvitationParam(); // ValidateInvitationParam | 
    try {
      apiInstance.validateInvitation(invitationId, validateInvitationParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling InvitationApi#validateInvitation");
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
| **invitationId** | **String**| Invitation ID | |
| **validateInvitationParam** | [**ValidateInvitationParam**](ValidateInvitationParam.md)|  | [optional] |

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
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

