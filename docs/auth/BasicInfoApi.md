# BasicInfoApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**findNotificationMessages**](BasicInfoApi.md#findNotificationMessages) | **GET** /notification-messages | 通知メールテンプレートを取得(Get Notification Email Templates) |
| [**getBasicInfo**](BasicInfoApi.md#getBasicInfo) | **GET** /basic-info | 基本設定情報の取得(Get Basic Configurations) |
| [**getCustomizePageSettings**](BasicInfoApi.md#getCustomizePageSettings) | **GET** /customize-page-settings | 認証認可基本情報取得(Get Authentication Authorization Basic Information) |
| [**getCustomizePages**](BasicInfoApi.md#getCustomizePages) | **GET** /customize-pages | 認証系画面設定情報取得(Get Authentication Page Setting) |
| [**updateBasicInfo**](BasicInfoApi.md#updateBasicInfo) | **PUT** /basic-info | 基本設定情報の更新(Update Basic Configurations) |
| [**updateCustomizePageSettings**](BasicInfoApi.md#updateCustomizePageSettings) | **PATCH** /customize-page-settings | 認証認可基本情報更新(Update Authentication Authorization Basic Information) |
| [**updateCustomizePages**](BasicInfoApi.md#updateCustomizePages) | **PATCH** /customize-pages | 認証系画面設定情報設定(Authentication Page Setting) |
| [**updateNotificationMessages**](BasicInfoApi.md#updateNotificationMessages) | **PUT** /notification-messages | 通知メールテンプレートを更新(Update Notification Email Template) |


<a id="findNotificationMessages"></a>
# **findNotificationMessages**
> NotificationMessages findNotificationMessages()

通知メールテンプレートを取得(Get Notification Email Templates)

各種通知メールテンプレートを取得します。  Get notification email templates. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.BasicInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    BasicInfoApi apiInstance = new BasicInfoApi(defaultClient);
    try {
      NotificationMessages result = apiInstance.findNotificationMessages();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicInfoApi#findNotificationMessages");
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

[**NotificationMessages**](NotificationMessages.md)

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

<a id="getBasicInfo"></a>
# **getBasicInfo**
> BasicInfo getBasicInfo()

基本設定情報の取得(Get Basic Configurations)

SaaS ID を元に設定されているドメイン名と CNAME レコードを取得します。 取得した CNAME レコードを DNS に設定することで、ログイン画面を生成します。  Get the domain name and CNAME record based on the SaaS ID. By setting the CNAME record on the DNS the login screen will be generated. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.BasicInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    BasicInfoApi apiInstance = new BasicInfoApi(defaultClient);
    try {
      BasicInfo result = apiInstance.getBasicInfo();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicInfoApi#getBasicInfo");
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

[**BasicInfo**](BasicInfo.md)

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

<a id="getCustomizePageSettings"></a>
# **getCustomizePageSettings**
> CustomizePageSettings getCustomizePageSettings()

認証認可基本情報取得(Get Authentication Authorization Basic Information)

認証認可基本情報を取得します。  Get authentication authorization basic information. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.BasicInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    BasicInfoApi apiInstance = new BasicInfoApi(defaultClient);
    try {
      CustomizePageSettings result = apiInstance.getCustomizePageSettings();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicInfoApi#getCustomizePageSettings");
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

[**CustomizePageSettings**](CustomizePageSettings.md)

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

<a id="getCustomizePages"></a>
# **getCustomizePages**
> CustomizePages getCustomizePages()

認証系画面設定情報取得(Get Authentication Page Setting)

認証系画面設定情報（新規登録・ログイン・パスワードリセット等）を取得します。  Get the authentication screen setting information (new registration, login, password reset, etc.). 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.BasicInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    BasicInfoApi apiInstance = new BasicInfoApi(defaultClient);
    try {
      CustomizePages result = apiInstance.getCustomizePages();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicInfoApi#getCustomizePages");
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

[**CustomizePages**](CustomizePages.md)

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

<a id="updateBasicInfo"></a>
# **updateBasicInfo**
> updateBasicInfo(updateBasicInfoParam)

基本設定情報の更新(Update Basic Configurations)

SaaS ID を元にパラメータとして設定したドメイン名を設定更新します。 CNAME レコードが生成されますので、 DNS に設定して下さい。 既に稼働中の SaaS アプリケーションに設定している場合には、動作に影響があります。  Update the domain name that was set as a parameter based on the SaaS ID. After the CNAME record is generated, set it in your DNS. If it is set on a SaaS application that is already running, it will affect the behavior. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.BasicInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    BasicInfoApi apiInstance = new BasicInfoApi(defaultClient);
    UpdateBasicInfoParam updateBasicInfoParam = new UpdateBasicInfoParam(); // UpdateBasicInfoParam | 
    try {
      apiInstance.updateBasicInfo(updateBasicInfoParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicInfoApi#updateBasicInfo");
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
| **updateBasicInfoParam** | [**UpdateBasicInfoParam**](UpdateBasicInfoParam.md)|  | [optional] |

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

<a id="updateCustomizePageSettings"></a>
# **updateCustomizePageSettings**
> updateCustomizePageSettings(updateCustomizePageSettingsParam)

認証認可基本情報更新(Update Authentication Authorization Basic Information)

認証認可基本情報を更新します。  Update authentication authorization basic information. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.BasicInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    BasicInfoApi apiInstance = new BasicInfoApi(defaultClient);
    UpdateCustomizePageSettingsParam updateCustomizePageSettingsParam = new UpdateCustomizePageSettingsParam(); // UpdateCustomizePageSettingsParam | 
    try {
      apiInstance.updateCustomizePageSettings(updateCustomizePageSettingsParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicInfoApi#updateCustomizePageSettings");
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
| **updateCustomizePageSettingsParam** | [**UpdateCustomizePageSettingsParam**](UpdateCustomizePageSettingsParam.md)|  | [optional] |

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

<a id="updateCustomizePages"></a>
# **updateCustomizePages**
> updateCustomizePages(updateCustomizePagesParam)

認証系画面設定情報設定(Authentication Page Setting)

認証系画面設定情報（新規登録・ログイン・パスワードリセット等）を更新します。  Update the authentication page setting information (new registration, login, password reset, etc.). 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.BasicInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    BasicInfoApi apiInstance = new BasicInfoApi(defaultClient);
    UpdateCustomizePagesParam updateCustomizePagesParam = new UpdateCustomizePagesParam(); // UpdateCustomizePagesParam | 
    try {
      apiInstance.updateCustomizePages(updateCustomizePagesParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicInfoApi#updateCustomizePages");
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
| **updateCustomizePagesParam** | [**UpdateCustomizePagesParam**](UpdateCustomizePagesParam.md)|  | [optional] |

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

<a id="updateNotificationMessages"></a>
# **updateNotificationMessages**
> updateNotificationMessages(updateNotificationMessagesParam)

通知メールテンプレートを更新(Update Notification Email Template)

各種通知メールテンプレート更新します。  Update notification email template. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.BasicInfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    BasicInfoApi apiInstance = new BasicInfoApi(defaultClient);
    UpdateNotificationMessagesParam updateNotificationMessagesParam = new UpdateNotificationMessagesParam(); // UpdateNotificationMessagesParam | 
    try {
      apiInstance.updateNotificationMessages(updateNotificationMessagesParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicInfoApi#updateNotificationMessages");
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
| **updateNotificationMessagesParam** | [**UpdateNotificationMessagesParam**](UpdateNotificationMessagesParam.md)|  | [optional] |

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

