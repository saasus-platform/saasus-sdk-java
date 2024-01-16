# EnvApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createEnv**](EnvApi.md#createEnv) | **POST** /envs | 環境情報を作成(Create Env Info) |
| [**deleteEnv**](EnvApi.md#deleteEnv) | **DELETE** /envs/{env_id} | 環境情報を削除(Delete Env Info) |
| [**getEnv**](EnvApi.md#getEnv) | **GET** /envs/{env_id} | 環境情報を取得(Get Env Details) |
| [**getEnvs**](EnvApi.md#getEnvs) | **GET** /envs | 環境情報一覧を取得(Get Env Info) |
| [**updateEnv**](EnvApi.md#updateEnv) | **PATCH** /envs/{env_id} | 環境情報を更新(Update Env Info) |


<a id="createEnv"></a>
# **createEnv**
> Env createEnv(body)

環境情報を作成(Create Env Info)

環境情報を作成します。 連携のテストや開発用環境や実際の運用で利用する環境など複数の環境を定義することができます。  Create environment information. Multiple environments can be defined, such as an environment for testing linkage, an environment for development, and an environment for actual operation. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.EnvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EnvApi apiInstance = new EnvApi(defaultClient);
    Env body = new Env(); // Env | 
    try {
      Env result = apiInstance.createEnv(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EnvApi#createEnv");
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
| **body** | **Env**|  | [optional] |

### Return type

[**Env**](Env.md)

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

<a id="deleteEnv"></a>
# **deleteEnv**
> deleteEnv(envId)

環境情報を削除(Delete Env Info)

環境情報を削除します。  Delete env info. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.EnvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EnvApi apiInstance = new EnvApi(defaultClient);
    Integer envId = 56; // Integer | 環境ID(Env ID)
    try {
      apiInstance.deleteEnv(envId);
    } catch (ApiException e) {
      System.err.println("Exception when calling EnvApi#deleteEnv");
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
| **envId** | **Integer**| 環境ID(Env ID) | |

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

<a id="getEnv"></a>
# **getEnv**
> Env getEnv(envId)

環境情報を取得(Get Env Details)

環境情報の詳細を取得します。  Get environment details. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.EnvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EnvApi apiInstance = new EnvApi(defaultClient);
    Integer envId = 56; // Integer | 環境ID(Env ID)
    try {
      Env result = apiInstance.getEnv(envId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EnvApi#getEnv");
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
| **envId** | **Integer**| 環境ID(Env ID) | |

### Return type

[**Env**](Env.md)

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

<a id="getEnvs"></a>
# **getEnvs**
> Envs getEnvs()

環境情報一覧を取得(Get Env Info)

登録されている環境情報を取得します。 連携のテストや開発用環境や実際の運用で利用する環境など複数の環境を定義することができます。  Get registered environment information. Multiple environments can be defined, such as an environment for testing linkage, an environment for development, and an environment for actual operation. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.EnvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EnvApi apiInstance = new EnvApi(defaultClient);
    try {
      Envs result = apiInstance.getEnvs();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EnvApi#getEnvs");
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

[**Envs**](Envs.md)

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

<a id="updateEnv"></a>
# **updateEnv**
> updateEnv(envId, updateEnvParam)

環境情報を更新(Update Env Info)

環境情報を更新します。  Update env info. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.EnvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EnvApi apiInstance = new EnvApi(defaultClient);
    Integer envId = 56; // Integer | 環境ID(Env ID)
    UpdateEnvParam updateEnvParam = new UpdateEnvParam(); // UpdateEnvParam | 
    try {
      apiInstance.updateEnv(envId, updateEnvParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling EnvApi#updateEnv");
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
| **envId** | **Integer**| 環境ID(Env ID) | |
| **updateEnvParam** | [**UpdateEnvParam**](UpdateEnvParam.md)|  | [optional] |

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

