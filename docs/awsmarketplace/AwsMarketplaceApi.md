# AwsMarketplaceApi

All URIs are relative to *https://api.saasus.io/v1/awsmarketplace*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCustomer**](AwsMarketplaceApi.md#createCustomer) | **POST** /customers | AWS Marketplaceに連携する顧客情報を新規作成(Create customer information to be linked to AWS Marketplace) |
| [**getCatalogEntityVisibility**](AwsMarketplaceApi.md#getCatalogEntityVisibility) | **GET** /catalog-entity/visibility | AWS Marketplaceから商品の公開状況を取得(Obtain product publication status from AWS Marketplace) |
| [**getCloudFormationLaunchStackLink**](AwsMarketplaceApi.md#getCloudFormationLaunchStackLink) | **GET** /cloudformation-launch-stack-link | AWS CloudFormationのスタック作成リンクを取得(Get the link to create the AWS CloudFormation stack) |
| [**getCustomer**](AwsMarketplaceApi.md#getCustomer) | **GET** /customers/{customer_identifier} | AWS Marketplaceに連携する顧客情報を取得(Get customer information to be linked to AWS Marketplace) |
| [**getCustomers**](AwsMarketplaceApi.md#getCustomers) | **GET** /customers | AWS Marketplaceに連携する顧客情報の一覧を取得(Get a list of customer information to be linked to AWS Marketplace) |
| [**getListingStatus**](AwsMarketplaceApi.md#getListingStatus) | **GET** /listing-status | AWS Marketplaceの出品状況を取得(Get AWS Marketplace Listing Status) |
| [**getPlanByPlanName**](AwsMarketplaceApi.md#getPlanByPlanName) | **GET** /plans/{plan_name} | AWSMarketplaceに連携するプラン情報を取得(Obtain plan information to link to AWS Marketplace) |
| [**getPlans**](AwsMarketplaceApi.md#getPlans) | **GET** /plans | AWS Marketplaceに連携するプラン情報を取得(Obtain plan information to link to AWS Marketplace) |
| [**getSettings**](AwsMarketplaceApi.md#getSettings) | **GET** /settings | AWS Marketplaceの設定を取得(Get AWS Marketplace Settings) |
| [**savePlan**](AwsMarketplaceApi.md#savePlan) | **PUT** /plans | AWS Marketplaceに連携するプラン情報を登録(Save plan information to be linked to AWSMarketplace) |
| [**syncCustomer**](AwsMarketplaceApi.md#syncCustomer) | **POST** /customers/{customer_identifier}/sync | AWS Marketplaceの顧客情報をSaaSusに同期します(Sync AWS Marketplace customer information to SaaSus) |
| [**updateListingStatus**](AwsMarketplaceApi.md#updateListingStatus) | **PUT** /listing-status | AWS Marketplaceの出品状況を更新(Update AWS Marketplace Listing Status) |
| [**updateSettings**](AwsMarketplaceApi.md#updateSettings) | **PUT** /settings | AWS Marketplaceの設定を更新(Update AWS Marketplace Settings) |
| [**verifyRegistrationToken**](AwsMarketplaceApi.md#verifyRegistrationToken) | **POST** /registration-token/verify | Registration Tokenを検証(Verify Registration Token) |


<a id="createCustomer"></a>
# **createCustomer**
> Customer createCustomer(createCustomerParam)

AWS Marketplaceに連携する顧客情報を新規作成(Create customer information to be linked to AWS Marketplace)

AWS Marketplaceに連携する顧客情報を新規作成します。  Create customer information to be linked to AWS Marketplace. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    CreateCustomerParam createCustomerParam = new CreateCustomerParam(); // CreateCustomerParam | 
    try {
      Customer result = apiInstance.createCustomer(createCustomerParam);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#createCustomer");
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
| **createCustomerParam** | [**CreateCustomerParam**](CreateCustomerParam.md)|  | [optional] |

### Return type

[**Customer**](Customer.md)

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

<a id="getCatalogEntityVisibility"></a>
# **getCatalogEntityVisibility**
> CatalogEntityVisibility getCatalogEntityVisibility()

AWS Marketplaceから商品の公開状況を取得(Obtain product publication status from AWS Marketplace)

AWS Marketplaceから商品の公開状況を取得します。  Retrieve the product&#39;s publication status from AWS Marketplace. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    try {
      CatalogEntityVisibility result = apiInstance.getCatalogEntityVisibility();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#getCatalogEntityVisibility");
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

[**CatalogEntityVisibility**](CatalogEntityVisibility.md)

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

AWS CloudFormationのスタック作成リンクを取得(Get the link to create the AWS CloudFormation stack)

CloudFormationのクイック作成リンクを取得します。  Get the CloudFormation Quick Create link. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    try {
      CloudFormationLaunchStackLink result = apiInstance.getCloudFormationLaunchStackLink();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#getCloudFormationLaunchStackLink");
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

<a id="getCustomer"></a>
# **getCustomer**
> Customer getCustomer(customerIdentifier)

AWS Marketplaceに連携する顧客情報を取得(Get customer information to be linked to AWS Marketplace)

AWS Marketplaceに連携する顧客情報を取得します。  Get customer information to be linked to AWS Marketplace. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    String customerIdentifier = "123456789012"; // String | 顧客ID
    try {
      Customer result = apiInstance.getCustomer(customerIdentifier);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#getCustomer");
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
| **customerIdentifier** | **String**| 顧客ID | |

### Return type

[**Customer**](Customer.md)

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

<a id="getCustomers"></a>
# **getCustomers**
> Customers getCustomers(tenantIds)

AWS Marketplaceに連携する顧客情報の一覧を取得(Get a list of customer information to be linked to AWS Marketplace)

AWS Marketplaceに連携する顧客情報の一覧を取得します。  Get a list of customer information to be linked to AWS Marketplace. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    List<String> tenantIds = Arrays.asList(); // List<String> | 指定したテナントIDの顧客を取得する(Get customers with the specified tenant ID)
    try {
      Customers result = apiInstance.getCustomers(tenantIds);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#getCustomers");
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
| **tenantIds** | [**List&lt;String&gt;**](String.md)| 指定したテナントIDの顧客を取得する(Get customers with the specified tenant ID) | [optional] |

### Return type

[**Customers**](Customers.md)

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

<a id="getListingStatus"></a>
# **getListingStatus**
> GetListingStatusResult getListingStatus()

AWS Marketplaceの出品状況を取得(Get AWS Marketplace Listing Status)

AWS Marketplaceの出品状況を取得します。  Get AWS Marketplace Listing Status. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    try {
      GetListingStatusResult result = apiInstance.getListingStatus();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#getListingStatus");
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

[**GetListingStatusResult**](GetListingStatusResult.md)

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

<a id="getPlanByPlanName"></a>
# **getPlanByPlanName**
> Plan getPlanByPlanName(planName)

AWSMarketplaceに連携するプラン情報を取得(Obtain plan information to link to AWS Marketplace)

Marketplaceと連携するプラン情報を取得します。  Obtain plan information to link to AWS Marketplace. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    String planName = "normal_plan_name_month"; // String | AWS Marketplace連携プラン名
    try {
      Plan result = apiInstance.getPlanByPlanName(planName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#getPlanByPlanName");
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
| **planName** | **String**| AWS Marketplace連携プラン名 | |

### Return type

[**Plan**](Plan.md)

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

<a id="getPlans"></a>
# **getPlans**
> Plans getPlans()

AWS Marketplaceに連携するプラン情報を取得(Obtain plan information to link to AWS Marketplace)

Marketplaceと連携するプラン情報を取得します。  Obtain plan information to link to AWS Marketplace. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    try {
      Plans result = apiInstance.getPlans();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#getPlans");
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

[**Plans**](Plans.md)

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

<a id="getSettings"></a>
# **getSettings**
> Settings getSettings()

AWS Marketplaceの設定を取得(Get AWS Marketplace Settings)

AWS Marketplaceの設定を取得します。  Get AWS Marketplace Settings. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    try {
      Settings result = apiInstance.getSettings();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#getSettings");
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

[**Settings**](Settings.md)

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

<a id="savePlan"></a>
# **savePlan**
> savePlan(savePlanParam)

AWS Marketplaceに連携するプラン情報を登録(Save plan information to be linked to AWSMarketplace)

AWSMarketplaceに連携するプラン情報を登録します。  Save plan information to be linked to AWSMarketplace. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    SavePlanParam savePlanParam = new SavePlanParam(); // SavePlanParam | 
    try {
      apiInstance.savePlan(savePlanParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#savePlan");
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
| **savePlanParam** | [**SavePlanParam**](SavePlanParam.md)|  | [optional] |

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

<a id="syncCustomer"></a>
# **syncCustomer**
> syncCustomer(customerIdentifier)

AWS Marketplaceの顧客情報をSaaSusに同期します(Sync AWS Marketplace customer information to SaaSus)

AWS Marketplaceの顧客情報をSaaSusに同期します。  Sync AWS Marketplace customer information to SaaSus. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    String customerIdentifier = "123456789012"; // String | 顧客ID
    try {
      apiInstance.syncCustomer(customerIdentifier);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#syncCustomer");
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
| **customerIdentifier** | **String**| 顧客ID | |

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

<a id="updateListingStatus"></a>
# **updateListingStatus**
> updateListingStatus(updateListingStatusParam)

AWS Marketplaceの出品状況を更新(Update AWS Marketplace Listing Status)

AWS Marketplaceの出品状況を更新します。  Update AWS Marketplace Listing Status. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    UpdateListingStatusParam updateListingStatusParam = new UpdateListingStatusParam(); // UpdateListingStatusParam | 
    try {
      apiInstance.updateListingStatus(updateListingStatusParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#updateListingStatus");
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
| **updateListingStatusParam** | [**UpdateListingStatusParam**](UpdateListingStatusParam.md)|  | [optional] |

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

<a id="updateSettings"></a>
# **updateSettings**
> updateSettings(updateSettingsParam)

AWS Marketplaceの設定を更新(Update AWS Marketplace Settings)

AWS Marketplaceの設定を更新します。  Update AWS Marketplace Settings. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    UpdateSettingsParam updateSettingsParam = new UpdateSettingsParam(); // UpdateSettingsParam | 
    try {
      apiInstance.updateSettings(updateSettingsParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#updateSettings");
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
| **updateSettingsParam** | [**UpdateSettingsParam**](UpdateSettingsParam.md)|  | [optional] |

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

<a id="verifyRegistrationToken"></a>
# **verifyRegistrationToken**
> verifyRegistrationToken(verifyRegistrationTokenParam)

Registration Tokenを検証(Verify Registration Token)

Registration Tokenを検証します。  Verify Registration Token. 

### Example
```java
// Import classes:
import saasus.sdk.awsmarketplace.ApiClient;
import saasus.sdk.awsmarketplace.ApiException;
import saasus.sdk.awsmarketplace.Configuration;
import saasus.sdk.awsmarketplace.auth.*;
import saasus.sdk.awsmarketplace.models.*;
import saasus.sdk.awsmarketplace.api.AwsMarketplaceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/awsmarketplace");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    AwsMarketplaceApi apiInstance = new AwsMarketplaceApi(defaultClient);
    VerifyRegistrationTokenParam verifyRegistrationTokenParam = new VerifyRegistrationTokenParam(); // VerifyRegistrationTokenParam | 
    try {
      apiInstance.verifyRegistrationToken(verifyRegistrationTokenParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling AwsMarketplaceApi#verifyRegistrationToken");
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
| **verifyRegistrationTokenParam** | [**VerifyRegistrationTokenParam**](VerifyRegistrationTokenParam.md)|  | [optional] |

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

