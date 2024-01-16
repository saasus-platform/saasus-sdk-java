# SaasUserApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**confirmEmailUpdate**](SaasUserApi.md#confirmEmailUpdate) | **POST** /users/{user_id}/email/confirm | ユーザーのメールアドレス変更確認(Confirm User Email Update) |
| [**confirmExternalUserLink**](SaasUserApi.md#confirmExternalUserLink) | **POST** /external-users/confirm | 外部アカウントのユーザーの連携確認(Confirm External User Account Link) |
| [**confirmSignUpWithAwsMarketplace**](SaasUserApi.md#confirmSignUpWithAwsMarketplace) | **POST** /aws-marketplace/sign-up-confirm | AWS Marketplaceによるユーザー新規登録の確定(Confirm Sign Up with AWS Marketplace) |
| [**createSaasUser**](SaasUserApi.md#createSaasUser) | **POST** /users | SaaSにユーザーを作成(Create SaaS User) |
| [**createSecretCode**](SaasUserApi.md#createSecretCode) | **POST** /users/{user_id}/mfa/software-token/secret-code | 認証アプリケーション登録用のシークレットコードを作成(Creates secret code for authentication application registration) |
| [**deleteSaasUser**](SaasUserApi.md#deleteSaasUser) | **DELETE** /users/{user_id} | ユーザー情報を削除(Delete User) |
| [**getSaasUser**](SaasUserApi.md#getSaasUser) | **GET** /users/{user_id} | ユーザー情報を取得(Get User) |
| [**getSaasUsers**](SaasUserApi.md#getSaasUsers) | **GET** /users | ユーザー一覧を取得(Get Users) |
| [**getUserMfaPreference**](SaasUserApi.md#getUserMfaPreference) | **GET** /users/{user_id}/mfa/preference | ユーザーのMFA設定を取得(Get User&#39;s MFA Settings) |
| [**linkAwsMarketplace**](SaasUserApi.md#linkAwsMarketplace) | **PATCH** /aws-marketplace/link | AWS Marketplaceと既存のテナントの連携(Link an existing tenant with AWS Marketplace) |
| [**requestEmailUpdate**](SaasUserApi.md#requestEmailUpdate) | **POST** /users/{user_id}/email/request | ユーザーのメールアドレス変更要求(Request User Email Update) |
| [**requestExternalUserLink**](SaasUserApi.md#requestExternalUserLink) | **POST** /external-users/request | 外部アカウントのユーザー連携要求(Request External User Account Link) |
| [**resendSignUpConfirmationEmail**](SaasUserApi.md#resendSignUpConfirmationEmail) | **POST** /sign-up/resend | 新規登録時の確認メール再送信(Resend Sign Up Confirmation Email) |
| [**signUp**](SaasUserApi.md#signUp) | **POST** /sign-up | 新規登録(Sign Up) |
| [**signUpWithAwsMarketplace**](SaasUserApi.md#signUpWithAwsMarketplace) | **POST** /aws-marketplace/sign-up | AWS Marketplaceによるユーザー新規登録(Sign Up with AWS Marketplace) |
| [**unlinkProvider**](SaasUserApi.md#unlinkProvider) | **DELETE** /users/{user_id}/providers/{provider_name} | 外部IDプロバイダの連携解除(Unlink external identity providers) |
| [**updateSaasUserEmail**](SaasUserApi.md#updateSaasUserEmail) | **PATCH** /users/{user_id}/email | メールアドレスを変更(Change Email) |
| [**updateSaasUserPassword**](SaasUserApi.md#updateSaasUserPassword) | **PATCH** /users/{user_id}/password | パスワードを変更(Change Password) |
| [**updateSoftwareToken**](SaasUserApi.md#updateSoftwareToken) | **PUT** /users/{user_id}/mfa/software-token | 認証アプリケーションを登録(Register Authentication Application) |
| [**updateUserMfaPreference**](SaasUserApi.md#updateUserMfaPreference) | **PATCH** /users/{user_id}/mfa/preference | ユーザーのMFA設定を更新(Update User&#39;s MFA Settings) |


<a id="confirmEmailUpdate"></a>
# **confirmEmailUpdate**
> confirmEmailUpdate(userId, confirmEmailUpdateParam)

ユーザーのメールアドレス変更確認(Confirm User Email Update)

ユーザーのメールアドレス変更確認のためにコードを検証します。 ユーザーのアクセストークンが必要です。  Verify the code to confirm the user&#39;s email address update. Requires the user&#39;s access token. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    ConfirmEmailUpdateParam confirmEmailUpdateParam = new ConfirmEmailUpdateParam(); // ConfirmEmailUpdateParam | 
    try {
      apiInstance.confirmEmailUpdate(userId, confirmEmailUpdateParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#confirmEmailUpdate");
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
| **confirmEmailUpdateParam** | [**ConfirmEmailUpdateParam**](ConfirmEmailUpdateParam.md)|  | [optional] |

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

<a id="confirmExternalUserLink"></a>
# **confirmExternalUserLink**
> confirmExternalUserLink(confirmExternalUserLinkParam)

外部アカウントのユーザーの連携確認(Confirm External User Account Link)

外部アカウントのユーザー連携確認のためにコードを検証します。  Verify the code for external account user link confirmation. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    ConfirmExternalUserLinkParam confirmExternalUserLinkParam = new ConfirmExternalUserLinkParam(); // ConfirmExternalUserLinkParam | 
    try {
      apiInstance.confirmExternalUserLink(confirmExternalUserLinkParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#confirmExternalUserLink");
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
| **confirmExternalUserLinkParam** | [**ConfirmExternalUserLinkParam**](ConfirmExternalUserLinkParam.md)|  | [optional] |

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

<a id="confirmSignUpWithAwsMarketplace"></a>
# **confirmSignUpWithAwsMarketplace**
> Tenant confirmSignUpWithAwsMarketplace(confirmSignUpWithAwsMarketplaceParam)

AWS Marketplaceによるユーザー新規登録の確定(Confirm Sign Up with AWS Marketplace)

AWS Marketplaceと連携したユーザー新規登録を確定します。AWS Marketplaceと連携したテナントを新規作成します。 Registration Tokenが有効でない場合はエラーを返却します。  Confirm a new use registeration linked to AWS Marketplace. Create a new tenant linked to AWS Marketplace. If the Registration Token is not valid, an error is returned. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    ConfirmSignUpWithAwsMarketplaceParam confirmSignUpWithAwsMarketplaceParam = new ConfirmSignUpWithAwsMarketplaceParam(); // ConfirmSignUpWithAwsMarketplaceParam | 
    try {
      Tenant result = apiInstance.confirmSignUpWithAwsMarketplace(confirmSignUpWithAwsMarketplaceParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#confirmSignUpWithAwsMarketplace");
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
| **confirmSignUpWithAwsMarketplaceParam** | [**ConfirmSignUpWithAwsMarketplaceParam**](ConfirmSignUpWithAwsMarketplaceParam.md)|  | [optional] |

### Return type

[**Tenant**](Tenant.md)

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

<a id="createSaasUser"></a>
# **createSaasUser**
> SaasUser createSaasUser(createSaasUserParam)

SaaSにユーザーを作成(Create SaaS User)

SaaSにユーザーを作成します。  Create SaaS User. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    CreateSaasUserParam createSaasUserParam = new CreateSaasUserParam(); // CreateSaasUserParam | 
    try {
      SaasUser result = apiInstance.createSaasUser(createSaasUserParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#createSaasUser");
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
| **createSaasUserParam** | [**CreateSaasUserParam**](CreateSaasUserParam.md)|  | [optional] |

### Return type

[**SaasUser**](SaasUser.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | OK |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

<a id="createSecretCode"></a>
# **createSecretCode**
> SoftwareTokenSecretCode createSecretCode(userId, createSecretCodeParam)

認証アプリケーション登録用のシークレットコードを作成(Creates secret code for authentication application registration)

認証アプリケーション登録用のシークレットコードを作成します。  Create a secret code for authentication application registration. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    CreateSecretCodeParam createSecretCodeParam = new CreateSecretCodeParam(); // CreateSecretCodeParam | 
    try {
      SoftwareTokenSecretCode result = apiInstance.createSecretCode(userId, createSecretCodeParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#createSecretCode");
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
| **createSecretCodeParam** | [**CreateSecretCodeParam**](CreateSecretCodeParam.md)|  | [optional] |

### Return type

[**SoftwareTokenSecretCode**](SoftwareTokenSecretCode.md)

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

<a id="deleteSaasUser"></a>
# **deleteSaasUser**
> deleteSaasUser(userId)

ユーザー情報を削除(Delete User)

ユーザーIDを元に一致するユーザーをテナントからすべて削除し、SaaSからも削除します。  Delete all users with matching user ID from the tenant and SaaS. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    try {
      apiInstance.deleteSaasUser(userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#deleteSaasUser");
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

<a id="getSaasUser"></a>
# **getSaasUser**
> SaasUser getSaasUser(userId)

ユーザー情報を取得(Get User)

ユーザーIDからユーザー情報を取得します。  Get user information based on user ID. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    try {
      SaasUser result = apiInstance.getSaasUser(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#getSaasUser");
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

[**SaasUser**](SaasUser.md)

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

<a id="getSaasUsers"></a>
# **getSaasUsers**
> SaasUsers getSaasUsers()

ユーザー一覧を取得(Get Users)

SaaSのユーザー全件を取得します。  Get all SaaS users. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    try {
      SaasUsers result = apiInstance.getSaasUsers();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#getSaasUsers");
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

[**SaasUsers**](SaasUsers.md)

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

<a id="getUserMfaPreference"></a>
# **getUserMfaPreference**
> MfaPreference getUserMfaPreference(userId)

ユーザーのMFA設定を取得(Get User&#39;s MFA Settings)

ユーザーのMFA設定を取得します。  Get the user&#39;s MFA settings. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    try {
      MfaPreference result = apiInstance.getUserMfaPreference(userId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#getUserMfaPreference");
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

[**MfaPreference**](MfaPreference.md)

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

<a id="linkAwsMarketplace"></a>
# **linkAwsMarketplace**
> linkAwsMarketplace(linkAwsMarketplaceParam)

AWS Marketplaceと既存のテナントの連携(Link an existing tenant with AWS Marketplace)

AWS Marketplaceと既存のテナントを連携します。 Registration Tokenが有効でない場合はエラーを返却します。  Link an existing tenant with AWS Marketplace. If the Registration Token is not valid, an error is returned. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    LinkAwsMarketplaceParam linkAwsMarketplaceParam = new LinkAwsMarketplaceParam(); // LinkAwsMarketplaceParam | 
    try {
      apiInstance.linkAwsMarketplace(linkAwsMarketplaceParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#linkAwsMarketplace");
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
| **linkAwsMarketplaceParam** | [**LinkAwsMarketplaceParam**](LinkAwsMarketplaceParam.md)|  | [optional] |

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

<a id="requestEmailUpdate"></a>
# **requestEmailUpdate**
> requestEmailUpdate(userId, requestEmailUpdateParam)

ユーザーのメールアドレス変更要求(Request User Email Update)

ユーザーのメールアドレス変更を要求します。 要求されたメールアドレスに対して検証コードを送信します。 ユーザーのアクセストークンが必要です。 検証コードの有効期限は24時間です。  Request to update the user&#39;s email address. Sends a verification code to the requested email address. Requires the user&#39;s access token. The verification code is valid for 24 hours. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    RequestEmailUpdateParam requestEmailUpdateParam = new RequestEmailUpdateParam(); // RequestEmailUpdateParam | 
    try {
      apiInstance.requestEmailUpdate(userId, requestEmailUpdateParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#requestEmailUpdate");
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
| **requestEmailUpdateParam** | [**RequestEmailUpdateParam**](RequestEmailUpdateParam.md)|  | [optional] |

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

<a id="requestExternalUserLink"></a>
# **requestExternalUserLink**
> requestExternalUserLink(requestExternalUserLinkParam)

外部アカウントのユーザー連携要求(Request External User Account Link)

外部アカウントのユーザー連携を要求します。 アクセストークンから連携するユーザーのメールアドレスを取得し、そのメールアドレスに対して検証コードを送信します。 検証コードの有効期限は24時間です。  Request to link an external account user. Get the email address of the user to be linked from the access token and send a verification code to that email address. The verification code is valid for 24 hours. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    RequestExternalUserLinkParam requestExternalUserLinkParam = new RequestExternalUserLinkParam(); // RequestExternalUserLinkParam | 
    try {
      apiInstance.requestExternalUserLink(requestExternalUserLinkParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#requestExternalUserLink");
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
| **requestExternalUserLinkParam** | [**RequestExternalUserLinkParam**](RequestExternalUserLinkParam.md)|  | [optional] |

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

<a id="resendSignUpConfirmationEmail"></a>
# **resendSignUpConfirmationEmail**
> resendSignUpConfirmationEmail(resendSignUpConfirmationEmailParam)

新規登録時の確認メール再送信(Resend Sign Up Confirmation Email)

新規登録時の仮パスワードを再送信します。  Resend temporary password for the new registered user. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    ResendSignUpConfirmationEmailParam resendSignUpConfirmationEmailParam = new ResendSignUpConfirmationEmailParam(); // ResendSignUpConfirmationEmailParam | 
    try {
      apiInstance.resendSignUpConfirmationEmail(resendSignUpConfirmationEmailParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#resendSignUpConfirmationEmail");
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
| **resendSignUpConfirmationEmailParam** | [**ResendSignUpConfirmationEmailParam**](ResendSignUpConfirmationEmailParam.md)|  | [optional] |

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

<a id="signUp"></a>
# **signUp**
> SaasUser signUp(signUpParam)

新規登録(Sign Up)

ユーザーを新規登録します。登録されたメールアドレスに対して仮パスワードを送信します。  Register a new user. A temporary password will be sent to the registered email. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    SignUpParam signUpParam = new SignUpParam(); // SignUpParam | 
    try {
      SaasUser result = apiInstance.signUp(signUpParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#signUp");
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
| **signUpParam** | [**SignUpParam**](SignUpParam.md)|  | [optional] |

### Return type

[**SaasUser**](SaasUser.md)

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

<a id="signUpWithAwsMarketplace"></a>
# **signUpWithAwsMarketplace**
> SaasUser signUpWithAwsMarketplace(signUpWithAwsMarketplaceParam)

AWS Marketplaceによるユーザー新規登録(Sign Up with AWS Marketplace)

AWS Marketplaceと連携したユーザーを新規登録します。登録されたメールアドレスに対して仮パスワードを送信します。 Registration Tokenが有効でない場合はエラーを返却します。  Register a new user linked to AWS Marketplace. A temporary password will be sent to the registered email. If the Registration Token is not valid, an error is returned. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    SignUpWithAwsMarketplaceParam signUpWithAwsMarketplaceParam = new SignUpWithAwsMarketplaceParam(); // SignUpWithAwsMarketplaceParam | 
    try {
      SaasUser result = apiInstance.signUpWithAwsMarketplace(signUpWithAwsMarketplaceParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#signUpWithAwsMarketplace");
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
| **signUpWithAwsMarketplaceParam** | [**SignUpWithAwsMarketplaceParam**](SignUpWithAwsMarketplaceParam.md)|  | [optional] |

### Return type

[**SaasUser**](SaasUser.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | OK |  -  |
| **500** | Internal Server Error |  -  |

<a id="unlinkProvider"></a>
# **unlinkProvider**
> unlinkProvider(providerName, userId)

外部IDプロバイダの連携解除(Unlink external identity providers)

外部IDプロバイダの連携を解除します。  Unlink external identity providers. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String providerName = "Google"; // String | 
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    try {
      apiInstance.unlinkProvider(providerName, userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#unlinkProvider");
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
| **providerName** | **String**|  | |
| **userId** | **String**| ユーザーID(User ID) | |

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

<a id="updateSaasUserEmail"></a>
# **updateSaasUserEmail**
> updateSaasUserEmail(userId, updateSaasUserEmailParam)

メールアドレスを変更(Change Email)

ユーザーのメールアドレスを変更します。  Change user&#39;s email. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    UpdateSaasUserEmailParam updateSaasUserEmailParam = new UpdateSaasUserEmailParam(); // UpdateSaasUserEmailParam | 
    try {
      apiInstance.updateSaasUserEmail(userId, updateSaasUserEmailParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#updateSaasUserEmail");
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
| **updateSaasUserEmailParam** | [**UpdateSaasUserEmailParam**](UpdateSaasUserEmailParam.md)|  | [optional] |

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

<a id="updateSaasUserPassword"></a>
# **updateSaasUserPassword**
> updateSaasUserPassword(userId, updateSaasUserPasswordParam)

パスワードを変更(Change Password)

ユーザーのログインパスワードを変更します。  Change user&#39;s login password. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    UpdateSaasUserPasswordParam updateSaasUserPasswordParam = new UpdateSaasUserPasswordParam(); // UpdateSaasUserPasswordParam | 
    try {
      apiInstance.updateSaasUserPassword(userId, updateSaasUserPasswordParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#updateSaasUserPassword");
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
| **updateSaasUserPasswordParam** | [**UpdateSaasUserPasswordParam**](UpdateSaasUserPasswordParam.md)|  | [optional] |

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

<a id="updateSoftwareToken"></a>
# **updateSoftwareToken**
> updateSoftwareToken(userId, updateSoftwareTokenParam)

認証アプリケーションを登録(Register Authentication Application)

認証アプリケーションを登録します。  Register an authentication application. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    UpdateSoftwareTokenParam updateSoftwareTokenParam = new UpdateSoftwareTokenParam(); // UpdateSoftwareTokenParam | 
    try {
      apiInstance.updateSoftwareToken(userId, updateSoftwareTokenParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#updateSoftwareToken");
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
| **updateSoftwareTokenParam** | [**UpdateSoftwareTokenParam**](UpdateSoftwareTokenParam.md)|  | [optional] |

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

<a id="updateUserMfaPreference"></a>
# **updateUserMfaPreference**
> updateUserMfaPreference(userId, body)

ユーザーのMFA設定を更新(Update User&#39;s MFA Settings)

ユーザーのMFA設定を更新します。  Update user&#39;s MFA settings. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.SaasUserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SaasUserApi apiInstance = new SaasUserApi(defaultClient);
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | ユーザーID(User ID)
    MfaPreference body = new MfaPreference(); // MfaPreference | 
    try {
      apiInstance.updateUserMfaPreference(userId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#updateUserMfaPreference");
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
| **body** | **MfaPreference**|  | [optional] |

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

