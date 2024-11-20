# SaasUserApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**confirmEmailUpdate**](SaasUserApi.md#confirmEmailUpdate) | **POST** /users/{user_id}/email/confirm | Confirm User Email Update |
| [**confirmExternalUserLink**](SaasUserApi.md#confirmExternalUserLink) | **POST** /external-users/confirm | Confirm External User Account Link |
| [**confirmSignUpWithAwsMarketplace**](SaasUserApi.md#confirmSignUpWithAwsMarketplace) | **POST** /aws-marketplace/sign-up-confirm | Confirm Sign Up with AWS Marketplace |
| [**createSaasUser**](SaasUserApi.md#createSaasUser) | **POST** /users | Create SaaS User |
| [**createSecretCode**](SaasUserApi.md#createSecretCode) | **POST** /users/{user_id}/mfa/software-token/secret-code | Create secret code for authentication application registration |
| [**deleteSaasUser**](SaasUserApi.md#deleteSaasUser) | **DELETE** /users/{user_id} | Delete User |
| [**getSaasUser**](SaasUserApi.md#getSaasUser) | **GET** /users/{user_id} | Get User |
| [**getSaasUsers**](SaasUserApi.md#getSaasUsers) | **GET** /users | Get Users |
| [**getUserMfaPreference**](SaasUserApi.md#getUserMfaPreference) | **GET** /users/{user_id}/mfa/preference | Get User&#39;s MFA Settings |
| [**linkAwsMarketplace**](SaasUserApi.md#linkAwsMarketplace) | **PATCH** /aws-marketplace/link | Link an existing tenant with AWS Marketplace |
| [**requestEmailUpdate**](SaasUserApi.md#requestEmailUpdate) | **POST** /users/{user_id}/email/request | Request User Email Update |
| [**requestExternalUserLink**](SaasUserApi.md#requestExternalUserLink) | **POST** /external-users/request | Request External User Account Link |
| [**resendSignUpConfirmationEmail**](SaasUserApi.md#resendSignUpConfirmationEmail) | **POST** /sign-up/resend | Resend Sign Up Confirmation Email |
| [**signUp**](SaasUserApi.md#signUp) | **POST** /sign-up | Sign Up |
| [**signUpWithAwsMarketplace**](SaasUserApi.md#signUpWithAwsMarketplace) | **POST** /aws-marketplace/sign-up | Sign Up with AWS Marketplace |
| [**unlinkProvider**](SaasUserApi.md#unlinkProvider) | **DELETE** /users/{user_id}/providers/{provider_name} | Unlink external identity providers |
| [**updateSaasUserAttributes**](SaasUserApi.md#updateSaasUserAttributes) | **PATCH** /users/{user_id}/attributes | Update SaaS User Attributes |
| [**updateSaasUserEmail**](SaasUserApi.md#updateSaasUserEmail) | **PATCH** /users/{user_id}/email | Change Email |
| [**updateSaasUserPassword**](SaasUserApi.md#updateSaasUserPassword) | **PATCH** /users/{user_id}/password | Change Password |
| [**updateSoftwareToken**](SaasUserApi.md#updateSoftwareToken) | **PUT** /users/{user_id}/mfa/software-token | Register Authentication Application |
| [**updateUserMfaPreference**](SaasUserApi.md#updateUserMfaPreference) | **PATCH** /users/{user_id}/mfa/preference | Update User&#39;s MFA Settings |


<a id="confirmEmailUpdate"></a>
# **confirmEmailUpdate**
> confirmEmailUpdate(userId, confirmEmailUpdateParam)

Confirm User Email Update

Verify the code to confirm the user&#39;s email address update. Requires the user&#39;s access token. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **userId** | **String**| User ID | |
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

Confirm External User Account Link

Verify the code for external account user link confirmation. 

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

Confirm Sign Up with AWS Marketplace

Confirm a new use registeration linked to AWS Marketplace. Create a new tenant linked to AWS Marketplace. If the Registration Token is not valid, an error is returned. 

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

Create SaaS User

Create SaaS User. If attributes is empty, a temporary password will be sent to the registered email. 

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

Create secret code for authentication application registration

Create a secret code for authentication application registration. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **userId** | **String**| User ID | |
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

Delete User

Delete all users with matching user ID from the tenant and SaaS. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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

<a id="getSaasUser"></a>
# **getSaasUser**
> SaasUser getSaasUser(userId)

Get User

Get user information based on user ID. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **userId** | **String**| User ID | |

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

Get Users

Get all SaaS users. 

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

Get User&#39;s MFA Settings

Get the user&#39;s MFA settings. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **userId** | **String**| User ID | |

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

Link an existing tenant with AWS Marketplace

Link an existing tenant with AWS Marketplace. If the Registration Token is not valid, an error is returned. 

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

Request User Email Update

Request to update the user&#39;s email address. Sends a verification code to the requested email address. Requires the user&#39;s access token. The verification code is valid for 24 hours. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **userId** | **String**| User ID | |
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

Request External User Account Link

Request to link an external account user. Get the email address of the user to be linked from the access token and send a verification code to that email address. The verification code is valid for 24 hours. 

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

Resend Sign Up Confirmation Email

Resend temporary password for the new registered user. 

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

Sign Up

Register a new user. A temporary password will be sent to the registered email. 

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

Sign Up with AWS Marketplace

Register a new user linked to AWS Marketplace. A temporary password will be sent to the registered email. If the Registration Token is not valid, an error is returned. 

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

Unlink external identity providers

Unlink external identity providers. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **500** | Internal Server Error |  -  |

<a id="updateSaasUserAttributes"></a>
# **updateSaasUserAttributes**
> updateSaasUserAttributes(userId, updateSaasUserAttributesParam)

Update SaaS User Attributes

Update the additional attributes of the SaaS user. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
    UpdateSaasUserAttributesParam updateSaasUserAttributesParam = new UpdateSaasUserAttributesParam(); // UpdateSaasUserAttributesParam | 
    try {
      apiInstance.updateSaasUserAttributes(userId, updateSaasUserAttributesParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SaasUserApi#updateSaasUserAttributes");
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
| **updateSaasUserAttributesParam** | [**UpdateSaasUserAttributesParam**](UpdateSaasUserAttributesParam.md)|  | [optional] |

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

<a id="updateSaasUserEmail"></a>
# **updateSaasUserEmail**
> updateSaasUserEmail(userId, updateSaasUserEmailParam)

Change Email

Change user&#39;s email. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **userId** | **String**| User ID | |
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

Change Password

Change user&#39;s login password. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **userId** | **String**| User ID | |
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

Register Authentication Application

Register an authentication application. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **userId** | **String**| User ID | |
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

Update User&#39;s MFA Settings

Update user&#39;s MFA settings. 

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
    String userId = "f94bfffc-8be2-11ec-b41a-0242ac120004"; // String | User ID
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
| **userId** | **String**| User ID | |
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

