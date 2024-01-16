# TenantUserApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTenantUser**](TenantUserApi.md#createTenantUser) | **POST** /tenants/{tenant_id}/users | テナントにユーザーを作成(Create Tenant User) |
| [**createTenantUserRoles**](TenantUserApi.md#createTenantUserRoles) | **POST** /tenants/{tenant_id}/users/{user_id}/envs/{env_id}/roles | テナントのユーザー情報に役割(ロール)を作成(Create Tenant User Role) |
| [**deleteTenantUser**](TenantUserApi.md#deleteTenantUser) | **DELETE** /tenants/{tenant_id}/users/{user_id} | テナントのユーザー情報を削除(Delete Tenant User) |
| [**deleteTenantUserRole**](TenantUserApi.md#deleteTenantUserRole) | **DELETE** /tenants/{tenant_id}/users/{user_id}/envs/{env_id}/roles/{role_name} | テナントのユーザーから役割(ロール)を削除(Remove Role From Tenant User) |
| [**getAllTenantUser**](TenantUserApi.md#getAllTenantUser) | **GET** /tenants/all/users/{user_id} | ユーザー情報を取得(Get User Info) |
| [**getAllTenantUsers**](TenantUserApi.md#getAllTenantUsers) | **GET** /tenants/all/users | ユーザー一覧を取得(Get Users) |
| [**getTenantUser**](TenantUserApi.md#getTenantUser) | **GET** /tenants/{tenant_id}/users/{user_id} | テナントのユーザー情報を取得(Get Tenant User) |
| [**getTenantUsers**](TenantUserApi.md#getTenantUsers) | **GET** /tenants/{tenant_id}/users | テナントのユーザー一覧を取得(Get Tenant Users) |
| [**updateTenantUser**](TenantUserApi.md#updateTenantUser) | **PATCH** /tenants/{tenant_id}/users/{user_id} | テナントのユーザー属性情報を更新(Update Tenant User Attribute) |


<a id="createTenantUser"></a>
# **createTenantUser**
> User createTenantUser(tenantId, createTenantUserParam)

テナントにユーザーを作成(Create Tenant User)

テナントにユーザーを作成します。 attributesを空のオブジェクトにした場合、追加属性は空で作成されます。  Create a tenant user. If attributes is empty, the additional attributes will be created empty. 

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
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
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

テナントのユーザー情報に役割(ロール)を作成(Create Tenant User Role)

テナントのユーザーに役割(ロール)を作成します。  Create roles on tenant users. 

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
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    Integer envId = 56; // Integer | 環境ID(Env ID)
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
| **userId** | **String**| ユーザーID(User ID) | |
| **envId** | **Integer**| 環境ID(Env ID) | |
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

テナントのユーザー情報を削除(Delete Tenant User)

テナントからユーザーを削除します。  Delete a user from your tenant. 

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
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
| **userId** | **String**| ユーザーID(User ID) | |

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

テナントのユーザーから役割(ロール)を削除(Remove Role From Tenant User)

テナントのユーザーから役割(ロール)を削除します。  Remove a role from a tenant user. 

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
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    Integer envId = 56; // Integer | 環境ID(Env ID)
    String roleName = "admin"; // String | 役割(ロール)名(role name)
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
| **userId** | **String**| ユーザーID(User ID) | |
| **envId** | **Integer**| 環境ID(Env ID) | |
| **roleName** | **String**| 役割(ロール)名(role name) | |

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

ユーザー情報を取得(Get User Info)

ユーザーIDからテナントに所属しているユーザー情報を取得します。 複数テナントに所属している場合は別のオブジェクトとして返却されます。  Get information on user belonging to the tenant from the user ID. If the user belongs to multiple tenants, it will be returned as another object. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
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
| **userId** | **String**| ユーザーID(User ID) | |

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

ユーザー一覧を取得(Get Users)

テナントに所属しているユーザー全件を取得します。 複数テナントに所属する同一ユーザーは別のオブジェクトとして返却されます。 idは一意ではありません。  Get all users belonging to the tenant. The same user belonging to multiple tenants will be returned as a different object. Id is not unique. 

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

テナントのユーザー情報を取得(Get Tenant User)

テナントのユーザーをIDから一件取得します。  Get one tenant user by specific ID. 

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
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
| **userId** | **String**| ユーザーID(User ID) | |

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

テナントのユーザー一覧を取得(Get Tenant Users)

テナントに所属するユーザーを全件取得します。 idは一意です。  Get all the users belonging to the tenant. Id is unique. 

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
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
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
| **tenantId** | **String**| テナントID(Tenant ID) | |

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

テナントのユーザー属性情報を更新(Update Tenant User Attribute)

テナントのユーザー属性情報を更新します。  Update tenant user attributes. 

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
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
| **userId** | **String**| ユーザーID(User ID) | |
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

