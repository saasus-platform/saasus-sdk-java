# RoleApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createRole**](RoleApi.md#createRole) | **POST** /roles | 役割(ロール)を作成(Create Role) |
| [**deleteRole**](RoleApi.md#deleteRole) | **DELETE** /roles/{role_name} | 役割(ロール)を削除(Delete Role) |
| [**getRoles**](RoleApi.md#getRoles) | **GET** /roles | 役割(ロール)一覧を取得(Get Roles) |


<a id="createRole"></a>
# **createRole**
> Role createRole(body)

役割(ロール)を作成(Create Role)

役割(ロール)を作成します。 ここで作成した役割をユーザーに付与することによって、SaaS側で役割ベースの認可を実装することが用意になります。 また、同じユーザーでも、属するテナント・環境ごとに持っている役割を変えることが可能です。  Create a role. By granting users the roles created here, it becomes easier to implement role-based authorization on the SaaS side. In addition, even the same user can have different roles for each tenant/environment to which they belong. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.RoleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    RoleApi apiInstance = new RoleApi(defaultClient);
    Role body = new Role(); // Role | 
    try {
      Role result = apiInstance.createRole(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RoleApi#createRole");
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
| **body** | **Role**|  | [optional] |

### Return type

[**Role**](Role.md)

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

<a id="deleteRole"></a>
# **deleteRole**
> deleteRole(roleName)

役割(ロール)を削除(Delete Role)

役割(ロール)を削除します。  Delete role. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.RoleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    RoleApi apiInstance = new RoleApi(defaultClient);
    String roleName = "admin"; // String | 役割(ロール)名(role name)
    try {
      apiInstance.deleteRole(roleName);
    } catch (ApiException e) {
      System.err.println("Exception when calling RoleApi#deleteRole");
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
| **400** | Bad Request |  -  |
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

<a id="getRoles"></a>
# **getRoles**
> Roles getRoles()

役割(ロール)一覧を取得(Get Roles)

登録されている役割(ロール)を一覧として取得します。 ここで定義した役割をユーザーに付与することによって、SaaS側で役割ベースの認可を実装することが用意になります。 また、同じユーザーでも、属するテナント・環境ごとに持っている役割を変えることが可能です。  Get registered roles list. Granting users the roles defined here makes it easy to implement role-based authorization on the SaaS side. In addition, even the same user can have different roles for each tenant/environment to which they belong. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.RoleApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    RoleApi apiInstance = new RoleApi(defaultClient);
    try {
      Roles result = apiInstance.getRoles();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RoleApi#getRoles");
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

[**Roles**](Roles.md)

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

