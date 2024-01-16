# AuthInfoApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAuthInfo**](AuthInfoApi.md#getAuthInfo) | **GET** /auth-info | 認証情報を取得(Get Authentication Info) |
| [**getIdentityProviders**](AuthInfoApi.md#getIdentityProviders) | **GET** /identity-providers |  |
| [**getSignInSettings**](AuthInfoApi.md#getSignInSettings) | **GET** /sign-in-settings | パスワード要件を取得(Get Password Requirements) |
| [**updateAuthInfo**](AuthInfoApi.md#updateAuthInfo) | **PUT** /auth-info | 認証情報を更新(Update Authentication Info) |
| [**updateIdentityProvider**](AuthInfoApi.md#updateIdentityProvider) | **PUT** /identity-providers |  |
| [**updateSignInSettings**](AuthInfoApi.md#updateSignInSettings) | **PUT** /sign-in-settings | パスワード要件を更新(Update Password Requirements) |


<a id="getAuthInfo"></a>
# **getAuthInfo**
> AuthInfo getAuthInfo()

認証情報を取得(Get Authentication Info)

ログイン後に認証情報を渡す SaaS の URL を取得します。 ここで取得した URL へ認証情報を渡し、SaaSus SDK を利用してこの Callback の実装をすることが可能となります。  Get the post-login SaaS URL that contains authentication information. You can pass authentication information to the URL obtained here and implement this Callback using the SaaSus SDK. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.AuthInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AuthInfoApi apiInstance = new AuthInfoApi(defaultClient);
    try {
      AuthInfo result = apiInstance.getAuthInfo();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthInfoApi#getAuthInfo");
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

[**AuthInfo**](AuthInfo.md)

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

<a id="getIdentityProviders"></a>
# **getIdentityProviders**
> IdentityProviders getIdentityProviders()



cognitoに設定している外部プロバイダ経由のサインイン情報取得  Get sign-in information via external provider set in cognito 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.AuthInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AuthInfoApi apiInstance = new AuthInfoApi(defaultClient);
    try {
      IdentityProviders result = apiInstance.getIdentityProviders();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthInfoApi#getIdentityProviders");
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

[**IdentityProviders**](IdentityProviders.md)

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

<a id="getSignInSettings"></a>
# **getSignInSettings**
> SignInSettings getSignInSettings()

パスワード要件を取得(Get Password Requirements)

ユーザーパスワードの要件設定を取得します。 アルファベット、数字、記号の組み合わせで、桁数を長くすれば解読されづらい安全なパスワードを設定することが可能となります。  Get user password requirements. Set a secure password that is difficult to decipher by increasing the number of digits by combining alphabets, numbers, and symbols. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.AuthInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AuthInfoApi apiInstance = new AuthInfoApi(defaultClient);
    try {
      SignInSettings result = apiInstance.getSignInSettings();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthInfoApi#getSignInSettings");
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

[**SignInSettings**](SignInSettings.md)

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

<a id="updateAuthInfo"></a>
# **updateAuthInfo**
> updateAuthInfo(body)

認証情報を更新(Update Authentication Info)

ログイン後に認証情報を渡す SaaS の URL を登録します。 ここで登録した URL に認証情報を渡し、SaaSus SDK を利用してこの Callback の実装をすることが可能となります。  Register post-login SaaS URL for authentication information. It is possible to pass authentication information to the URL registered here and implement this Callback using the SaaSus SDK. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.AuthInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AuthInfoApi apiInstance = new AuthInfoApi(defaultClient);
    AuthInfo body = new AuthInfo(); // AuthInfo | 
    try {
      apiInstance.updateAuthInfo(body);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthInfoApi#updateAuthInfo");
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
| **body** | **AuthInfo**|  | [optional] |

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

<a id="updateIdentityProvider"></a>
# **updateIdentityProvider**
> updateIdentityProvider(updateIdentityProviderParam)



外部IDプロバイダのサインイン情報更新

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.AuthInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AuthInfoApi apiInstance = new AuthInfoApi(defaultClient);
    UpdateIdentityProviderParam updateIdentityProviderParam = new UpdateIdentityProviderParam(); // UpdateIdentityProviderParam | 
    try {
      apiInstance.updateIdentityProvider(updateIdentityProviderParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthInfoApi#updateIdentityProvider");
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
| **updateIdentityProviderParam** | [**UpdateIdentityProviderParam**](UpdateIdentityProviderParam.md)|  | [optional] |

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

<a id="updateSignInSettings"></a>
# **updateSignInSettings**
> updateSignInSettings(updateSignInSettingsParam)

パスワード要件を更新(Update Password Requirements)

ユーザーパスワードの要件設定を更新します。 アルファベット、数字、記号の組み合わせで、桁数を長くすれば解読されづらい安全なパスワードを設定することが可能となります。  Update user password requirements. Set a secure password that is difficult to decipher by increasing the number of digits by combining alphabets, numbers, and symbols. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.AuthInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AuthInfoApi apiInstance = new AuthInfoApi(defaultClient);
    UpdateSignInSettingsParam updateSignInSettingsParam = new UpdateSignInSettingsParam(); // UpdateSignInSettingsParam | 
    try {
      apiInstance.updateSignInSettings(updateSignInSettingsParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthInfoApi#updateSignInSettings");
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
| **updateSignInSettingsParam** | [**UpdateSignInSettingsParam**](UpdateSignInSettingsParam.md)|  | [optional] |

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

