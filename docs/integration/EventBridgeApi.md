# EventBridgeApi

All URIs are relative to *https://api.saasus.io/v1/integration*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createEventBridgeEvent**](EventBridgeApi.md#createEventBridgeEvent) | **POST** /eventbridge/event | Send Events |
| [**createEventBridgeTestEvent**](EventBridgeApi.md#createEventBridgeTestEvent) | **POST** /eventbridge/test-event | Test EventBridge Connection |
| [**deleteEventBridgeSettings**](EventBridgeApi.md#deleteEventBridgeSettings) | **DELETE** /eventbridge/info | Delete EventBridge Settings |
| [**getEventBridgeSettings**](EventBridgeApi.md#getEventBridgeSettings) | **GET** /eventbridge/info | Get EventBridge Settings |
| [**saveEventBridgeSettings**](EventBridgeApi.md#saveEventBridgeSettings) | **PUT** /eventbridge/info | Update EventBridge Settings |


<a id="createEventBridgeEvent"></a>
# **createEventBridgeEvent**
> createEventBridgeEvent(createEventBridgeEventParam)

Send Events

Send events to Amazon EventBridge. 

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

Test EventBridge Connection

Send events to test the connection with Amazon EventBridge. 

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

Delete EventBridge Settings

Delete settings used to provide host state via Amazon EventBridge. 

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

Get EventBridge Settings

Gets the settings for providing real-time status of all monitored hosts via Amazon EventBridge. 

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

Update EventBridge Settings

Update configuration used to provide the host state via Amazon EventBridge. 

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

