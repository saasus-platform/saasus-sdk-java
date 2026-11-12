# UserInfoApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getUserInfo**](UserInfoApi.md#getUserInfo) | **GET** /userinfo | Get User Info |
| [**getUserInfoByEmail**](UserInfoApi.md#getUserInfoByEmail) | **GET** /userinfo/search/email | Get User Info by Email |
| [**getUserInfoBySignInId**](UserInfoApi.md#getUserInfoBySignInId) | **GET** /userinfo/search/sign-in-id | Get User Info by Sign-in ID |


<a id="getUserInfo"></a>
# **getUserInfo**
> UserInfo getUserInfo(token)

Get User Info

User information is obtained based on the ID token of the SaaS user (registered user). The ID token is passed to the Callback URL during login from the SaaSus Platform generated login screen. User information can be obtained from calling this API with an ID token from the URL on the server side. Since the acquired tenant, role (role), price plan, etc. are included, it is possible to implement authorization based on it. If the ID token validation fails and 401 Unauthorized is returned, the login screen URL will be returned in data.sign_in_page_url of the response, so the client can respond by redirecting to it, etc. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.UserInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    UserInfoApi apiInstance = new UserInfoApi(defaultClient);
    String token = "token_example"; // String | ID Token
    try {
      UserInfo result = apiInstance.getUserInfo(token);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserInfoApi#getUserInfo");
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
| **token** | **String**| ID Token | |

### Return type

[**UserInfo**](UserInfo.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **500** | Internal Server Error |  -  |

<a id="getUserInfoByEmail"></a>
# **getUserInfoByEmail**
> UserInfo getUserInfoByEmail(email)

Get User Info by Email

Get user information by email address. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.UserInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    UserInfoApi apiInstance = new UserInfoApi(defaultClient);
    String email = "email_example"; // String | Email
    try {
      UserInfo result = apiInstance.getUserInfoByEmail(email);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserInfoApi#getUserInfoByEmail");
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
| **email** | **String**| Email | |

### Return type

[**UserInfo**](UserInfo.md)

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

<a id="getUserInfoBySignInId"></a>
# **getUserInfoBySignInId**
> UserInfo getUserInfoBySignInId(signInId)

Get User Info by Sign-in ID

Get user information by sign-in ID. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.UserInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    UserInfoApi apiInstance = new UserInfoApi(defaultClient);
    String signInId = "signInId_example"; // String | Sign-in ID. 
    try {
      UserInfo result = apiInstance.getUserInfoBySignInId(signInId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserInfoApi#getUserInfoBySignInId");
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
| **signInId** | **String**| Sign-in ID.  | |

### Return type

[**UserInfo**](UserInfo.md)

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

