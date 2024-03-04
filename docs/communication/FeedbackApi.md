# FeedbackApi

All URIs are relative to *https://api.saasus.io/v1/communication*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createFeedback**](FeedbackApi.md#createFeedback) | **POST** /feedbacks | Create Feedback |
| [**createFeedbackComment**](FeedbackApi.md#createFeedbackComment) | **POST** /feedbacks/{feedback_id}/comments | Create Feedback Comment |
| [**createVoteUser**](FeedbackApi.md#createVoteUser) | **POST** /feedbacks/{feedback_id}/votes/users | Create Vote User |
| [**deleteFeedback**](FeedbackApi.md#deleteFeedback) | **DELETE** /feedbacks/{feedback_id} | Delete Feedback |
| [**deleteFeedbackComment**](FeedbackApi.md#deleteFeedbackComment) | **DELETE** /feedbacks/{feedback_id}/comments/{comment_id} | Delete Feedback Comment |
| [**deleteVoteForFeedback**](FeedbackApi.md#deleteVoteForFeedback) | **DELETE** /feedbacks/{feedback_id}/votes/users/{user_id} | Delete Vote For Feedback |
| [**getFeedback**](FeedbackApi.md#getFeedback) | **GET** /feedbacks/{feedback_id} | Get Feedback |
| [**getFeedbackComment**](FeedbackApi.md#getFeedbackComment) | **GET** /feedbacks/{feedback_id}/comments/{comment_id} | Get Feedback Comment |
| [**getFeedbacks**](FeedbackApi.md#getFeedbacks) | **GET** /feedbacks | Get Feedbacks |
| [**updateFeedback**](FeedbackApi.md#updateFeedback) | **PATCH** /feedbacks/{feedback_id} | Update Feedback |
| [**updateFeedbackComment**](FeedbackApi.md#updateFeedbackComment) | **PATCH** /feedbacks/{feedback_id}/comments/{comment_id} | Update Feedback Comment |
| [**updateFeedbackStatus**](FeedbackApi.md#updateFeedbackStatus) | **PATCH** /feedbacks/{feedback_id}/status | Update Feedback Status |


<a id="createFeedback"></a>
# **createFeedback**
> Feedback createFeedback(createFeedbackParam)

Create Feedback

Create Feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    CreateFeedbackParam createFeedbackParam = new CreateFeedbackParam(); // CreateFeedbackParam | 
    try {
      Feedback result = apiInstance.createFeedback(createFeedbackParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#createFeedback");
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
| **createFeedbackParam** | [**CreateFeedbackParam**](CreateFeedbackParam.md)|  | [optional] |

### Return type

[**Feedback**](Feedback.md)

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

<a id="createFeedbackComment"></a>
# **createFeedbackComment**
> Comment createFeedbackComment(feedbackId, createFeedbackCommentParam)

Create Feedback Comment

Post comment to feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    CreateFeedbackCommentParam createFeedbackCommentParam = new CreateFeedbackCommentParam(); // CreateFeedbackCommentParam | 
    try {
      Comment result = apiInstance.createFeedbackComment(feedbackId, createFeedbackCommentParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#createFeedbackComment");
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
| **feedbackId** | **String**|  | |
| **createFeedbackCommentParam** | [**CreateFeedbackCommentParam**](CreateFeedbackCommentParam.md)|  | [optional] |

### Return type

[**Comment**](Comment.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

<a id="createVoteUser"></a>
# **createVoteUser**
> Votes createVoteUser(feedbackId, createVoteUserParam)

Create Vote User

Vote for feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    CreateVoteUserParam createVoteUserParam = new CreateVoteUserParam(); // CreateVoteUserParam | 
    try {
      Votes result = apiInstance.createVoteUser(feedbackId, createVoteUserParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#createVoteUser");
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
| **feedbackId** | **String**|  | |
| **createVoteUserParam** | [**CreateVoteUserParam**](CreateVoteUserParam.md)|  | [optional] |

### Return type

[**Votes**](Votes.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

<a id="deleteFeedback"></a>
# **deleteFeedback**
> deleteFeedback(feedbackId)

Delete Feedback

Delete Feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    try {
      apiInstance.deleteFeedback(feedbackId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#deleteFeedback");
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
| **feedbackId** | **String**|  | |

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

<a id="deleteFeedbackComment"></a>
# **deleteFeedbackComment**
> deleteFeedbackComment(feedbackId, commentId)

Delete Feedback Comment

Delete comment for feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    String commentId = "commentId_example"; // String | 
    try {
      apiInstance.deleteFeedbackComment(feedbackId, commentId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#deleteFeedbackComment");
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
| **feedbackId** | **String**|  | |
| **commentId** | **String**|  | |

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

<a id="deleteVoteForFeedback"></a>
# **deleteVoteForFeedback**
> deleteVoteForFeedback(feedbackId, userId)

Delete Vote For Feedback

Cancel vote for feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    String userId = "userId_example"; // String | 
    try {
      apiInstance.deleteVoteForFeedback(feedbackId, userId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#deleteVoteForFeedback");
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
| **feedbackId** | **String**|  | |
| **userId** | **String**|  | |

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

<a id="getFeedback"></a>
# **getFeedback**
> Feedback getFeedback(feedbackId)

Get Feedback

Retrieve feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    try {
      Feedback result = apiInstance.getFeedback(feedbackId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#getFeedback");
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
| **feedbackId** | **String**|  | |

### Return type

[**Feedback**](Feedback.md)

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

<a id="getFeedbackComment"></a>
# **getFeedbackComment**
> Comment getFeedbackComment(feedbackId, commentId)

Get Feedback Comment

Retrieve comment from feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    String commentId = "commentId_example"; // String | 
    try {
      Comment result = apiInstance.getFeedbackComment(feedbackId, commentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#getFeedbackComment");
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
| **feedbackId** | **String**|  | |
| **commentId** | **String**|  | |

### Return type

[**Comment**](Comment.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Ok |  -  |
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

<a id="getFeedbacks"></a>
# **getFeedbacks**
> Feedbacks getFeedbacks()

Get Feedbacks

Get the list of feedbacks.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    try {
      Feedbacks result = apiInstance.getFeedbacks();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#getFeedbacks");
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

[**Feedbacks**](Feedbacks.md)

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

<a id="updateFeedback"></a>
# **updateFeedback**
> updateFeedback(feedbackId, updateFeedbackParam)

Update Feedback

Edit feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    UpdateFeedbackParam updateFeedbackParam = new UpdateFeedbackParam(); // UpdateFeedbackParam | 
    try {
      apiInstance.updateFeedback(feedbackId, updateFeedbackParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#updateFeedback");
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
| **feedbackId** | **String**|  | |
| **updateFeedbackParam** | [**UpdateFeedbackParam**](UpdateFeedbackParam.md)|  | [optional] |

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
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

<a id="updateFeedbackComment"></a>
# **updateFeedbackComment**
> updateFeedbackComment(feedbackId, commentId, updateFeedbackCommentParam)

Update Feedback Comment

Edit comment for feedback.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    String commentId = "commentId_example"; // String | 
    UpdateFeedbackCommentParam updateFeedbackCommentParam = new UpdateFeedbackCommentParam(); // UpdateFeedbackCommentParam | 
    try {
      apiInstance.updateFeedbackComment(feedbackId, commentId, updateFeedbackCommentParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#updateFeedbackComment");
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
| **feedbackId** | **String**|  | |
| **commentId** | **String**|  | |
| **updateFeedbackCommentParam** | [**UpdateFeedbackCommentParam**](UpdateFeedbackCommentParam.md)|  | [optional] |

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
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

<a id="updateFeedbackStatus"></a>
# **updateFeedbackStatus**
> updateFeedbackStatus(feedbackId, updateFeedbackStatusParam)

Update Feedback Status

Update Feedback Status.

### Example
```java
// Import classes:
import saasus.sdk.communication.ApiClient;
import saasus.sdk.communication.ApiException;
import saasus.sdk.communication.Configuration;
import saasus.sdk.communication.auth.*;
import saasus.sdk.communication.models.*;
import saasus.sdk.communication.api.FeedbackApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/communication");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FeedbackApi apiInstance = new FeedbackApi(defaultClient);
    String feedbackId = "feedbackId_example"; // String | 
    UpdateFeedbackStatusParam updateFeedbackStatusParam = new UpdateFeedbackStatusParam(); // UpdateFeedbackStatusParam | 
    try {
      apiInstance.updateFeedbackStatus(feedbackId, updateFeedbackStatusParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeedbackApi#updateFeedbackStatus");
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
| **feedbackId** | **String**|  | |
| **updateFeedbackStatusParam** | [**UpdateFeedbackStatusParam**](UpdateFeedbackStatusParam.md)|  | [optional] |

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
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

