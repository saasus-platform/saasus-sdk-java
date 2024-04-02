# UserAttributeApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createUserAttribute**](UserAttributeApi.md#createUserAttribute) | **POST** /user-attributes | Create User Attributes |
| [**deleteUserAttribute**](UserAttributeApi.md#deleteUserAttribute) | **DELETE** /user-attributes/{attribute_name} | Delete User Attribute |
| [**getUserAttributes**](UserAttributeApi.md#getUserAttributes) | **GET** /user-attributes | Get User Attributes |


<a id="createUserAttribute"></a>
# **createUserAttribute**
> Attribute createUserAttribute(body)

Create User Attributes

Create additional user attributes to be kept on the SaaSus Platform. For example, you can define items associated with a user, such as user name, birthday, etc. If you don&#39;t want personal information on the SaaS Platform side, personal information can be kept on the SaaS side without user attribute definition. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.UserAttributeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    UserAttributeApi apiInstance = new UserAttributeApi(defaultClient);
    Attribute body = new Attribute(); // Attribute | 
    try {
      Attribute result = apiInstance.createUserAttribute(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserAttributeApi#createUserAttribute");
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
| **body** | **Attribute**|  | [optional] |

### Return type

[**Attribute**](Attribute.md)

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

<a id="deleteUserAttribute"></a>
# **deleteUserAttribute**
> deleteUserAttribute(attributeName)

Delete User Attribute

Delete user attributes kept on the SaaSus Platform. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.UserAttributeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    UserAttributeApi apiInstance = new UserAttributeApi(defaultClient);
    String attributeName = "birthday"; // String | Attribute Name
    try {
      apiInstance.deleteUserAttribute(attributeName);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserAttributeApi#deleteUserAttribute");
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
| **attributeName** | **String**| Attribute Name | |

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

<a id="getUserAttributes"></a>
# **getUserAttributes**
> UserAttributes getUserAttributes()

Get User Attributes

Get additional attributes of the user saved in the SaaSus Platform. For example, you can define items associated with a user, such as user name, birthday, etc. If you don&#39;t want personal information on the SaaS Platform side, personal information can be kept on the SaaS side without user attribute definition. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.UserAttributeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    UserAttributeApi apiInstance = new UserAttributeApi(defaultClient);
    try {
      UserAttributes result = apiInstance.getUserAttributes();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserAttributeApi#getUserAttributes");
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

[**UserAttributes**](UserAttributes.md)

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

