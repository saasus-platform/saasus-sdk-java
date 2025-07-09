# SmartApiGatewayApi

All URIs are relative to *https://api.saasus.io/v1/apigateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**applyDraftApiGatewaySettings**](SmartApiGatewayApi.md#applyDraftApiGatewaySettings) | **POST** /draft/settings/apply | Apply draft configuration information for Smart API Gateway function |
| [**createApiGateway**](SmartApiGatewayApi.md#createApiGateway) | **POST** /create | Create the API Gateway |
| [**createApiKey**](SmartApiGatewayApi.md#createApiKey) | **POST** /api-keys | Create an API key |
| [**getApiGatewaySettings**](SmartApiGatewayApi.md#getApiGatewaySettings) | **GET** /settings | Obtain configuration information for api gateway function |
| [**getApiKey**](SmartApiGatewayApi.md#getApiKey) | **GET** /api-keys/{api_key} | get API key details by API key |
| [**getApiKeys**](SmartApiGatewayApi.md#getApiKeys) | **GET** /api-keys | API key list or get API key by condition |
| [**getCloudFormationLaunchStackLink**](SmartApiGatewayApi.md#getCloudFormationLaunchStackLink) | **GET** /cloudformation-launch-stack-link | Get the link to create the AWS CloudFormation stack |
| [**getDraftApiGatewaySettings**](SmartApiGatewayApi.md#getDraftApiGatewaySettings) | **GET** /draft/settings | Obtain draft configuration information for Smart API Gateway function |
| [**getTenant**](SmartApiGatewayApi.md#getTenant) | **GET** /tenants/{tenant_id} | Get tenant information |
| [**publishApiGateway**](SmartApiGatewayApi.md#publishApiGateway) | **POST** /publish | Publish the API Gateway |
| [**refreshClientSecret**](SmartApiGatewayApi.md#refreshClientSecret) | **POST** /api-keys/{api_key}/client-secret | Update the client secret of the API key |
| [**unpublishApiGateway**](SmartApiGatewayApi.md#unpublishApiGateway) | **POST** /unpublish | Unpublish the API Gateway |
| [**updateApiGatewaySettings**](SmartApiGatewayApi.md#updateApiGatewaySettings) | **PATCH** /settings | Update configuration information for api gateway function |
| [**updateOpenApiDefinition**](SmartApiGatewayApi.md#updateOpenApiDefinition) | **PUT** /settings/open-api-definition | Update OpenAPI definition file |
| [**updateTenant**](SmartApiGatewayApi.md#updateTenant) | **PATCH** /tenants/{tenant_id} | Update tenant information |
| [**uploadGenerationFiles**](SmartApiGatewayApi.md#uploadGenerationFiles) | **POST** /upload | Upload files to create an API Gateway |


<a id="applyDraftApiGatewaySettings"></a>
# **applyDraftApiGatewaySettings**
> applyDraftApiGatewaySettings()

Apply draft configuration information for Smart API Gateway function

Apply draft configuration information for Smart API Gateway function. This applies the changes made in the draft settings to the actual Smart API Gateway. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    try {
      apiInstance.applyDraftApiGatewaySettings();
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#applyDraftApiGatewaySettings");
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

<a id="createApiGateway"></a>
# **createApiGateway**
> createApiGateway()

Create the API Gateway

Create the API Gateway. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    try {
      apiInstance.createApiGateway();
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#createApiGateway");
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

<a id="createApiKey"></a>
# **createApiKey**
> ApiKey createApiKey(createApiKeyParam)

Create an API key

Creates or updates an API key based on the contents of the request body. All parameters are in the request body: - tenant_id, env_id (required) - user_id (optional) 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    CreateApiKeyParam createApiKeyParam = new CreateApiKeyParam(); // CreateApiKeyParam | Payload for API key creation or update.
    try {
      ApiKey result = apiInstance.createApiKey(createApiKeyParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#createApiKey");
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
| **createApiKeyParam** | [**CreateApiKeyParam**](CreateApiKeyParam.md)| Payload for API key creation or update. | |

### Return type

[**ApiKey**](ApiKey.md)

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

<a id="getApiGatewaySettings"></a>
# **getApiGatewaySettings**
> ApiGatewaySettings getApiGatewaySettings()

Obtain configuration information for api gateway function

Obtain configuration information for api gateway function. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    try {
      ApiGatewaySettings result = apiInstance.getApiGatewaySettings();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#getApiGatewaySettings");
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

[**ApiGatewaySettings**](ApiGatewaySettings.md)

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

<a id="getApiKey"></a>
# **getApiKey**
> ApiKey getApiKey(apiKey)

get API key details by API key

Get the details of the API key by specifying the API key. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    String apiKey = "1234567890abcdef"; // String | API Key
    try {
      ApiKey result = apiInstance.getApiKey(apiKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#getApiKey");
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
| **apiKey** | **String**| API Key | |

### Return type

[**ApiKey**](ApiKey.md)

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

<a id="getApiKeys"></a>
# **getApiKeys**
> ApiKeys getApiKeys(tenantId, envId, userId, tenantOnly)

API key list or get API key by condition

The response content changes based on the combination of parameters tenant_id, env_id, and user_id. - If tenant_id is not specified, the full list is returned. - If only tenant_id is specified, the API keys within that tenant are returned. - If tenant_id and env_id are specified, the keys are filtered by the environment. - If tenant_id, env_id, and user_id are specified, a complete match returns the API keys for the target user. - Additionally, searching is supported even when only env_id or only user_id are provided. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    String tenantId = "tenantId_example"; // String | If specified, the API keys for the target tenant are returned. 
    Integer envId = 56; // Integer | If specified, the API keys for the target environment are returned. 
    String userId = "userId_example"; // String | If specified, the API keys for the target user (up to 2) are returned. 
    Boolean tenantOnly = true; // Boolean | If true, only API keys that do not have a User_id specified are returned. 
    try {
      ApiKeys result = apiInstance.getApiKeys(tenantId, envId, userId, tenantOnly);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#getApiKeys");
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
| **tenantId** | **String**| If specified, the API keys for the target tenant are returned.  | [optional] |
| **envId** | **Integer**| If specified, the API keys for the target environment are returned.  | [optional] |
| **userId** | **String**| If specified, the API keys for the target user (up to 2) are returned.  | [optional] |
| **tenantOnly** | **Boolean**| If true, only API keys that do not have a User_id specified are returned.  | [optional] |

### Return type

[**ApiKeys**](ApiKeys.md)

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

<a id="getCloudFormationLaunchStackLink"></a>
# **getCloudFormationLaunchStackLink**
> CloudFormationLaunchStackLink getCloudFormationLaunchStackLink()

Get the link to create the AWS CloudFormation stack

Get the CloudFormation Quick Create link. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    try {
      CloudFormationLaunchStackLink result = apiInstance.getCloudFormationLaunchStackLink();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#getCloudFormationLaunchStackLink");
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

[**CloudFormationLaunchStackLink**](CloudFormationLaunchStackLink.md)

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

<a id="getDraftApiGatewaySettings"></a>
# **getDraftApiGatewaySettings**
> DraftApiGatewaySettings getDraftApiGatewaySettings()

Obtain draft configuration information for Smart API Gateway function

Obtain draft configuration information for Smart API Gateway function. You can check the settings generated from the uploaded source code before applying them. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    try {
      DraftApiGatewaySettings result = apiInstance.getDraftApiGatewaySettings();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#getDraftApiGatewaySettings");
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

[**DraftApiGatewaySettings**](DraftApiGatewaySettings.md)

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

<a id="getTenant"></a>
# **getTenant**
> ApiGatewayTenant getTenant(tenantId)

Get tenant information

Get tenant information. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    try {
      ApiGatewayTenant result = apiInstance.getTenant(tenantId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#getTenant");
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
| **tenantId** | **String**| Tenant ID | |

### Return type

[**ApiGatewayTenant**](ApiGatewayTenant.md)

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

<a id="publishApiGateway"></a>
# **publishApiGateway**
> publishApiGateway()

Publish the API Gateway

Publish the API Gateway. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    try {
      apiInstance.publishApiGateway();
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#publishApiGateway");
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

<a id="refreshClientSecret"></a>
# **refreshClientSecret**
> ApiKey refreshClientSecret(apiKey)

Update the client secret of the API key

Update the client secret of the API key. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    String apiKey = "1234567890abcdef"; // String | API Key
    try {
      ApiKey result = apiInstance.refreshClientSecret(apiKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#refreshClientSecret");
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
| **apiKey** | **String**| API Key | |

### Return type

[**ApiKey**](ApiKey.md)

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

<a id="unpublishApiGateway"></a>
# **unpublishApiGateway**
> unpublishApiGateway()

Unpublish the API Gateway

Unpublish the API Gateway. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    try {
      apiInstance.unpublishApiGateway();
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#unpublishApiGateway");
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

<a id="updateApiGatewaySettings"></a>
# **updateApiGatewaySettings**
> updateApiGatewaySettings(updateApiGatewaySettingsParam)

Update configuration information for api gateway function

Update configuration information for api gateway function. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    UpdateApiGatewaySettingsParam updateApiGatewaySettingsParam = new UpdateApiGatewaySettingsParam(); // UpdateApiGatewaySettingsParam | 
    try {
      apiInstance.updateApiGatewaySettings(updateApiGatewaySettingsParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#updateApiGatewaySettings");
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
| **updateApiGatewaySettingsParam** | [**UpdateApiGatewaySettingsParam**](UpdateApiGatewaySettingsParam.md)|  | |

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

<a id="updateOpenApiDefinition"></a>
# **updateOpenApiDefinition**
> updateOpenApiDefinition(updateOpenApiDefinitionParam)

Update OpenAPI definition file

Update OpenAPI definition file. The OpenAPI definition file is used for automatically generated documentation. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    UpdateOpenApiDefinitionParam updateOpenApiDefinitionParam = new UpdateOpenApiDefinitionParam(); // UpdateOpenApiDefinitionParam | 
    try {
      apiInstance.updateOpenApiDefinition(updateOpenApiDefinitionParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#updateOpenApiDefinition");
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
| **updateOpenApiDefinitionParam** | [**UpdateOpenApiDefinitionParam**](UpdateOpenApiDefinitionParam.md)|  | |

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

<a id="updateTenant"></a>
# **updateTenant**
> updateTenant(tenantId, updateTenantParam)

Update tenant information

Update tenant information. 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    String tenantId = "tenantId_example"; // String | Tenant ID
    UpdateTenantParam updateTenantParam = new UpdateTenantParam(); // UpdateTenantParam | 
    try {
      apiInstance.updateTenant(tenantId, updateTenantParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#updateTenant");
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
| **tenantId** | **String**| Tenant ID | |
| **updateTenantParam** | [**UpdateTenantParam**](UpdateTenantParam.md)|  | |

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

<a id="uploadGenerationFiles"></a>
# **uploadGenerationFiles**
> uploadGenerationFiles(apiGatewayInputFile)

Upload files to create an API Gateway

Upload files to create an API Gateway 

### Example
```java
// Import classes:
import saasus.sdk.apigateway.ApiClient;
import saasus.sdk.apigateway.ApiException;
import saasus.sdk.apigateway.Configuration;
import saasus.sdk.apigateway.auth.*;
import saasus.sdk.apigateway.models.*;
import saasus.sdk.apigateway.api.SmartApiGatewayApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/apigateway");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    SmartApiGatewayApi apiInstance = new SmartApiGatewayApi(defaultClient);
    ApiGatewayInputFile apiGatewayInputFile = new ApiGatewayInputFile(); // ApiGatewayInputFile | 
    try {
      apiInstance.uploadGenerationFiles(apiGatewayInputFile);
    } catch (ApiException e) {
      System.err.println("Exception when calling SmartApiGatewayApi#uploadGenerationFiles");
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
| **apiGatewayInputFile** | [**ApiGatewayInputFile**](ApiGatewayInputFile.md)|  | [optional] |

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

