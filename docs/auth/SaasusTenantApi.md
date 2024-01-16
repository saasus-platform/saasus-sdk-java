# SaasusTenantApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createApiKey**](SaasusTenantApi.md#createApiKey) | **POST** /apikeys | APIキーを作成(Create API Key) |
| [**deleteApiKey**](SaasusTenantApi.md#deleteApiKey) | **DELETE** /apikeys/{api_key} | APIキーを削除(Delete API Key) |
| [**getApiKeys**](SaasusTenantApi.md#getApiKeys) | **GET** /apikeys | APIキー一覧を取得(Get API Keys) |
| [**getClientSecret**](SaasusTenantApi.md#getClientSecret) | **GET** /client-secret | クライアントシークレットを取得(Get Client Secret) |
| [**getSaasId**](SaasusTenantApi.md#getSaasId) | **GET** /saasid | SaasIDを取得(Get SaasID) |
| [**updateClientSecret**](SaasusTenantApi.md#updateClientSecret) | **PATCH** /client-secret | クライアントシークレットを更新(Update Client Secret) |
| [**updateSaasId**](SaasusTenantApi.md#updateSaasId) | **PATCH** /saasid | SaasIDを更新(Update SaasID) |


<a id="createApiKey"></a>
# **createApiKey**
> createApiKey()

APIキーを作成(Create API Key)

サーバサイド用に API キーを発行します。 最大 2 つまで発行できます。  Generate an API key for the server side. Up to 2 can be generated. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasusTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasusTenantApi apiInstance = new SaasusTenantApi(defaultClient);
    try {
      apiInstance.createApiKey();
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasusTenantApi#createApiKey");
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
| **201** | Created |  -  |
| **500** | Internal Server Error |  -  |

<a id="deleteApiKey"></a>
# **deleteApiKey**
> deleteApiKey(apiKey)

APIキーを削除(Delete API Key)

サーバサイド用の API キーを削除します。  Delete API Key. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasusTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasusTenantApi apiInstance = new SaasusTenantApi(defaultClient);
    String apiKey = "ZDMiIHN0UmVmOmRvY3VtZW50SUQ9Inhtc"; // String | APIキー(API key)
    try {
      apiInstance.deleteApiKey(apiKey);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasusTenantApi#deleteApiKey");
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
| **apiKey** | **String**| APIキー(API key) | |

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

<a id="getApiKeys"></a>
# **getApiKeys**
> ApiKeys getApiKeys()

APIキー一覧を取得(Get API Keys)

サーバサイド用に API キーを取得します。 最大 2 つまで発行できます。  Get API key for the server side. Up to 2 can be generated. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasusTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasusTenantApi apiInstance = new SaasusTenantApi(defaultClient);
    try {
      ApiKeys result = apiInstance.getApiKeys();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasusTenantApi#getApiKeys");
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

[**ApiKeys**](ApiKeys.md)

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

<a id="getClientSecret"></a>
# **getClientSecret**
> ClientSecret getClientSecret()

クライアントシークレットを取得(Get Client Secret)

API リクエストでアプリが使用する固定文字列を取得します。  Gets the fixed string that the app uses in API requests. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasusTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasusTenantApi apiInstance = new SaasusTenantApi(defaultClient);
    try {
      ClientSecret result = apiInstance.getClientSecret();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasusTenantApi#getClientSecret");
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

[**ClientSecret**](ClientSecret.md)

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

<a id="getSaasId"></a>
# **getSaasId**
> SaasId getSaasId()

SaasIDを取得(Get SaasID)

テナントのSaasIDを取得します。 SaaSus API および SaaSus SDK にて利用します。  Get the tenant&#39;s SaasID. Used by SaaSus API and SaaSus SDK. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasusTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasusTenantApi apiInstance = new SaasusTenantApi(defaultClient);
    try {
      SaasId result = apiInstance.getSaasId();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasusTenantApi#getSaasId");
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

[**SaasId**](SaasId.md)

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

<a id="updateClientSecret"></a>
# **updateClientSecret**
> updateClientSecret()

クライアントシークレットを更新(Update Client Secret)

API リクエストでアプリが使用する固定文字列を再発行します。 既に稼働中のSaaSアプリケーションに設定している場合には、動作に影響があります。  Reissue fixed strings that apps use in API requests. If changed on a SaaS application that is already running, it will affect the behavior. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasusTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasusTenantApi apiInstance = new SaasusTenantApi(defaultClient);
    try {
      apiInstance.updateClientSecret();
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasusTenantApi#updateClientSecret");
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

<a id="updateSaasId"></a>
# **updateSaasId**
> updateSaasId()

SaasIDを更新(Update SaasID)

テナントのSaasIDを更新します。 SaaSus API および SaaSus SDK にて利用します。 既に稼働中の SaaS アプリケーションに設定している場合には、動作に影響があります。  Update the tenant&#39;s SaasID. Used by SaaSus API and SaaSus SDK. If changed on an SaaS application that is already running, it will affect the behavior. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasusTenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasusTenantApi apiInstance = new SaasusTenantApi(defaultClient);
    try {
      apiInstance.updateSaasId();
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasusTenantApi#updateSaasId");
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

