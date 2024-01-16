# CredentialApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAuthCredentials**](CredentialApi.md#createAuthCredentials) | **POST** /credentials | 認証・認可情報の保存(Save Authentication/Authorization Information) |
| [**getAuthCredentials**](CredentialApi.md#getAuthCredentials) | **GET** /credentials | 認証・認可情報の取得(Get Authentication/Authorization Information) |


<a id="createAuthCredentials"></a>
# **createAuthCredentials**
> AuthorizationTempCode createAuthCredentials(body)

認証・認可情報の保存(Save Authentication/Authorization Information)

引数のIDトークン・アクセストークン・リフレッシュトークンを一時保存し取得用の一時コードを返却する。 一時コードの有効期間は発行から10秒です。  Temporarily save the parameter for the ID token, access token, and refresh token and return a temporary code for obtaining. Temporary codes are valid for 10 seconds from issuance. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.CredentialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    CredentialApi apiInstance = new CredentialApi(defaultClient);
    Credentials body = new Credentials(); // Credentials | 
    try {
      AuthorizationTempCode result = apiInstance.createAuthCredentials(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CredentialApi#createAuthCredentials");
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
| **body** | **Credentials**|  | [optional] |

### Return type

[**AuthorizationTempCode**](AuthorizationTempCode.md)

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
| **401** | Unauthorized |  -  |
| **500** | Internal Server Error |  -  |

<a id="getAuthCredentials"></a>
# **getAuthCredentials**
> Credentials getAuthCredentials(code, authFlow, refreshToken)

認証・認可情報の取得(Get Authentication/Authorization Information)

一時コードまたはリフレッシュトークンを利用してIDトークン・アクセストークン・リフレッシュトークンを取得する。  Get ID token, access token, and refresh token using a temporary code or a refresh token. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.CredentialApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    CredentialApi apiInstance = new CredentialApi(defaultClient);
    String code = "code_example"; // String | 一時コード(Temp Code)
    String authFlow = "tempCodeAuth"; // String | 認証フロー（Authentication Flow） tempCodeAuth: 一時コードを利用した認証情報の取得 refreshTokenAuth: リフレッシュトークンを利用した認証情報の取得 指定されていない場合は tempCodeAuth になります 
    String refreshToken = "refreshToken_example"; // String | リフレッシュトークン(Refresh Token)
    try {
      Credentials result = apiInstance.getAuthCredentials(code, authFlow, refreshToken);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CredentialApi#getAuthCredentials");
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
| **code** | **String**| 一時コード(Temp Code) | [optional] |
| **authFlow** | **String**| 認証フロー（Authentication Flow） tempCodeAuth: 一時コードを利用した認証情報の取得 refreshTokenAuth: リフレッシュトークンを利用した認証情報の取得 指定されていない場合は tempCodeAuth になります  | [optional] [enum: tempCodeAuth, refreshTokenAuth] |
| **refreshToken** | **String**| リフレッシュトークン(Refresh Token) | [optional] |

### Return type

[**Credentials**](Credentials.md)

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

