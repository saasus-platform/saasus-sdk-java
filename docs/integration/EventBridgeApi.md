# EventBridgeApi

All URIs are relative to *https://api.saasus.io/v1/integration*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createEventBridgeEvent**](EventBridgeApi.md#createEventBridgeEvent) | **POST** /eventbridge/event | イベント連携の送信(Send Events) |
| [**createEventBridgeTestEvent**](EventBridgeApi.md#createEventBridgeTestEvent) | **POST** /eventbridge/test-event | イベント連携のテスト送信(Test EventBridge Connection) |
| [**deleteEventBridgeSettings**](EventBridgeApi.md#deleteEventBridgeSettings) | **DELETE** /eventbridge/info | イベント連携設定を削除(Delete EventBridge Settings) |
| [**getEventBridgeSettings**](EventBridgeApi.md#getEventBridgeSettings) | **GET** /eventbridge/info | イベント連携設定を取得(Get EventBridge Settings) |
| [**saveEventBridgeSettings**](EventBridgeApi.md#saveEventBridgeSettings) | **PUT** /eventbridge/info | イベント連携設定を更新(Update EventBridge Settings) |


<a id="createEventBridgeEvent"></a>
# **createEventBridgeEvent**
> createEventBridgeEvent(createEventBridgeEventParam)

イベント連携の送信(Send Events)

Amazon EventBridge へイベントを送信します。  Send events to Amazon EventBridge. 

### Example
```java
// Import classes:
import saasus.sdk.integration.ApiClient;
import saasus.sdk.integration.ApiException;
import saasus.sdk.integration.Configuration;
import saasus.sdk.integration.auth.*;
import saasus.sdk.integration.models.*;
import saasus.sdk.integration.api.EventBridgeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/integration");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EventBridgeApi apiInstance = new EventBridgeApi(defaultClient);
    CreateEventBridgeEventParam createEventBridgeEventParam = new CreateEventBridgeEventParam(); // CreateEventBridgeEventParam | 
    try {
      apiInstance.createEventBridgeEvent(createEventBridgeEventParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling EventBridgeApi#createEventBridgeEvent");
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
| **createEventBridgeEventParam** | [**CreateEventBridgeEventParam**](CreateEventBridgeEventParam.md)|  | [optional] |

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

<a id="createEventBridgeTestEvent"></a>
# **createEventBridgeTestEvent**
> createEventBridgeTestEvent()

イベント連携のテスト送信(Test EventBridge Connection)

Amazon EventBridge との連携をテストする為のイベントを送信します。  Send events to test the connection with Amazon EventBridge. 

### Example
```java
// Import classes:
import saasus.sdk.integration.ApiClient;
import saasus.sdk.integration.ApiException;
import saasus.sdk.integration.Configuration;
import saasus.sdk.integration.auth.*;
import saasus.sdk.integration.models.*;
import saasus.sdk.integration.api.EventBridgeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/integration");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EventBridgeApi apiInstance = new EventBridgeApi(defaultClient);
    try {
      apiInstance.createEventBridgeTestEvent();
    } catch (ApiException e) {
      System.err.println("Exception when calling EventBridgeApi#createEventBridgeTestEvent");
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

<a id="deleteEventBridgeSettings"></a>
# **deleteEventBridgeSettings**
> deleteEventBridgeSettings()

イベント連携設定を削除(Delete EventBridge Settings)

ホストの状態を Amazon EventBridge 経由で提供するための設定を解除します。  Delete settings used to provide host state via Amazon EventBridge. 

### Example
```java
// Import classes:
import saasus.sdk.integration.ApiClient;
import saasus.sdk.integration.ApiException;
import saasus.sdk.integration.Configuration;
import saasus.sdk.integration.auth.*;
import saasus.sdk.integration.models.*;
import saasus.sdk.integration.api.EventBridgeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/integration");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EventBridgeApi apiInstance = new EventBridgeApi(defaultClient);
    try {
      apiInstance.deleteEventBridgeSettings();
    } catch (ApiException e) {
      System.err.println("Exception when calling EventBridgeApi#deleteEventBridgeSettings");
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

<a id="getEventBridgeSettings"></a>
# **getEventBridgeSettings**
> EventBridgeSettings getEventBridgeSettings()

イベント連携設定を取得(Get EventBridge Settings)

監視対象となっている全ホストの状態をリアルタイムにAmazon EventBridge 経由で提供するための設定を取得します。  Gets the settings for providing real-time status of all monitored hosts via Amazon EventBridge. 

### Example
```java
// Import classes:
import saasus.sdk.integration.ApiClient;
import saasus.sdk.integration.ApiException;
import saasus.sdk.integration.Configuration;
import saasus.sdk.integration.auth.*;
import saasus.sdk.integration.models.*;
import saasus.sdk.integration.api.EventBridgeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/integration");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EventBridgeApi apiInstance = new EventBridgeApi(defaultClient);
    try {
      EventBridgeSettings result = apiInstance.getEventBridgeSettings();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EventBridgeApi#getEventBridgeSettings");
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

[**EventBridgeSettings**](EventBridgeSettings.md)

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

<a id="saveEventBridgeSettings"></a>
# **saveEventBridgeSettings**
> saveEventBridgeSettings(body)

イベント連携設定を更新(Update EventBridge Settings)

ホストの状態を Amazon EventBridge 経由で提供するための設定を更新します。  Update configuration used to provide the host state via Amazon EventBridge. 

### Example
```java
// Import classes:
import saasus.sdk.integration.ApiClient;
import saasus.sdk.integration.ApiException;
import saasus.sdk.integration.Configuration;
import saasus.sdk.integration.auth.*;
import saasus.sdk.integration.models.*;
import saasus.sdk.integration.api.EventBridgeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/integration");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    EventBridgeApi apiInstance = new EventBridgeApi(defaultClient);
    EventBridgeSettings body = new EventBridgeSettings(); // EventBridgeSettings | 
    try {
      apiInstance.saveEventBridgeSettings(body);
    } catch (ApiException e) {
      System.err.println("Exception when calling EventBridgeApi#saveEventBridgeSettings");
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
| **body** | **EventBridgeSettings**|  | [optional] |

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

