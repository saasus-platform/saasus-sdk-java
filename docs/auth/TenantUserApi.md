# TenantUserApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTenantUser**](TenantUserApi.md#createTenantUser) | **POST** /tenants/{tenant_id}/users | Create Tenant User |
| [**createTenantUserRoles**](TenantUserApi.md#createTenantUserRoles) | **POST** /tenants/{tenant_id}/users/{user_id}/envs/{env_id}/roles | Create Tenant User Role |
| [**deleteTenantUser**](TenantUserApi.md#deleteTenantUser) | **DELETE** /tenants/{tenant_id}/users/{user_id} | Delete Tenant User |
| [**deleteTenantUserRole**](TenantUserApi.md#deleteTenantUserRole) | **DELETE** /tenants/{tenant_id}/users/{user_id}/envs/{env_id}/roles/{role_name} | Remove Role From Tenant User |
| [**getAllTenantUser**](TenantUserApi.md#getAllTenantUser) | **GET** /tenants/all/users/{user_id} | Get User Info |
| [**getAllTenantUsers**](TenantUserApi.md#getAllTenantUsers) | **GET** /tenants/all/users | Get Users |
| [**getTenantUser**](TenantUserApi.md#getTenantUser) | **GET** /tenants/{tenant_id}/users/{user_id} | Get Tenant User |
| [**getTenantUsers**](TenantUserApi.md#getTenantUsers) | **GET** /tenants/{tenant_id}/users | Get Tenant Users |
| [**updateTenantUser**](TenantUserApi.md#updateTenantUser) | **PATCH** /tenants/{tenant_id}/users/{user_id} | Update Tenant User Attribute |


<a id="createTenantUser"></a>
# **createTenantUser**
> User createTenantUser(tenantId, createTenantUserParam)

Create Tenant User

Create a tenant user. If attributes is empty, the additional attributes will be created empty. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantUserApi apiInstance = new TenantUserApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    CreateTenantUserParam createTenantUserParam = new CreateTenantUserParam(); // CreateTenantUserParam | 
    try {
      User result = apiInstance.createTenantUser(tenantId, createTenantUserParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantUserApi#createTenantUser");
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
| **createTenantUserParam** | [**CreateTenantUserParam**](CreateTenantUserParam.md)|  | [optional] |

### Return type

[**User**](User.md)

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

<a id="createTenantUserRoles"></a>
# **createTenantUserRoles**
> createTenantUserRoles(tenantId, userId, envId, createTenantUserRolesParam)

Create Tenant User Role

Create roles on tenant users. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantUserApi apiInstance = new TenantUserApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
    Integer envId = 56; // Integer | Env ID
    CreateTenantUserRolesParam createTenantUserRolesParam = new CreateTenantUserRolesParam(); // CreateTenantUserRolesParam | 
    try {
      apiInstance.createTenantUserRoles(tenantId, userId, envId, createTenantUserRolesParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantUserApi#createTenantUserRoles");
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
| **userId** | **String**| User ID | |
| **envId** | **Integer**| Env ID | |
| **createTenantUserRolesParam** | [**CreateTenantUserRolesParam**](CreateTenantUserRolesParam.md)|  | [optional] |

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
| **201** | Created |  -  |
| **500** | Internal Server Error |  -  |

<a id="deleteTenantUser"></a>
# **deleteTenantUser**
> deleteTenantUser(tenantId, userId)

Delete Tenant User

Delete a user from the tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantUserApi apiInstance = new TenantUserApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
    try {
      apiInstance.deleteTenantUser(tenantId, userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantUserApi#deleteTenantUser");
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
| **userId** | **String**| User ID | |

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

<a id="deleteTenantUserRole"></a>
# **deleteTenantUserRole**
> deleteTenantUserRole(tenantId, userId, envId, roleName)

Remove Role From Tenant User

Remove a role from a tenant user. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantUserApi apiInstance = new TenantUserApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
    Integer envId = 56; // Integer | Env ID
    String roleName = "admin"; // String | Role name
    try {
      apiInstance.deleteTenantUserRole(tenantId, userId, envId, roleName);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantUserApi#deleteTenantUserRole");
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
| **userId** | **String**| User ID | |
| **envId** | **Integer**| Env ID | |
| **roleName** | **String**| Role name | |

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

<a id="getAllTenantUser"></a>
# **getAllTenantUser**
> Users getAllTenantUser(userId)

Get User Info

Get information on user belonging to the tenant from the user ID. If the user belongs to multiple tenants, it will be returned as another object. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantUserApi apiInstance = new TenantUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
    try {
      Users result = apiInstance.getAllTenantUser(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantUserApi#getAllTenantUser");
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
| **userId** | **String**| User ID | |

### Return type

[**Users**](Users.md)

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

<a id="getAllTenantUsers"></a>
# **getAllTenantUsers**
> Users getAllTenantUsers()

Get Users

Get all users belonging to the tenant. The same user belonging to multiple tenants will be returned as a different object. Id is not unique. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantUserApi apiInstance = new TenantUserApi(defaultClient);
    try {
      Users result = apiInstance.getAllTenantUsers();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantUserApi#getAllTenantUsers");
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

[**Users**](Users.md)

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

<a id="getTenantUser"></a>
# **getTenantUser**
> User getTenantUser(tenantId, userId)

Get Tenant User

Get one tenant user by specific ID. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantUserApi apiInstance = new TenantUserApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
    try {
      User result = apiInstance.getTenantUser(tenantId, userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantUserApi#getTenantUser");
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
| **userId** | **String**| User ID | |

### Return type

[**User**](User.md)

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

<a id="getTenantUsers"></a>
# **getTenantUsers**
> Users getTenantUsers(tenantId)

Get Tenant Users

Get all the users belonging to the tenant. Id is unique. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantUserApi apiInstance = new TenantUserApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    try {
      Users result = apiInstance.getTenantUsers(tenantId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantUserApi#getTenantUsers");
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

[**Users**](Users.md)

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

<a id="updateTenantUser"></a>
# **updateTenantUser**
> updateTenantUser(tenantId, userId, updateTenantUserParam)

Update Tenant User Attribute

Update tenant user attributes. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantUserApi apiInstance = new TenantUserApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
    UpdateTenantUserParam updateTenantUserParam = new UpdateTenantUserParam(); // UpdateTenantUserParam | 
    try {
      apiInstance.updateTenantUser(tenantId, userId, updateTenantUserParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantUserApi#updateTenantUser");
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
| **userId** | **String**| User ID | |
| **updateTenantUserParam** | [**UpdateTenantUserParam**](UpdateTenantUserParam.md)|  | [optional] |

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
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

