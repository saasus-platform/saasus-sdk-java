# TenantApi

All URIs are relative to *https://api.saasus.io/v1/auth*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTenant**](TenantApi.md#createTenant) | **POST** /tenants | テナントを作成(Create Tenant) |
| [**createTenantAndPricing**](TenantApi.md#createTenantAndPricing) | **PATCH** /stripe/init | stripe初期設定(Stripe Initial Setting) |
| [**deleteStripeTenantAndPricing**](TenantApi.md#deleteStripeTenantAndPricing) | **DELETE** /stripe | stripe上の顧客情報・商品情報の削除(Delete Customer and Product From Stripe) |
| [**deleteTenant**](TenantApi.md#deleteTenant) | **DELETE** /tenants/{tenant_id} | テナント情報を削除(Delete Tenant) |
| [**getTenant**](TenantApi.md#getTenant) | **GET** /tenants/{tenant_id} | テナント情報を取得(Get Tenant Details) |
| [**getTenantIdentityProviders**](TenantApi.md#getTenantIdentityProviders) | **GET** /tenants/{tenant_id}/identity-providers | テナント毎の外部IDプロバイダ取得(Get identity provider per tenant) |
| [**getTenants**](TenantApi.md#getTenants) | **GET** /tenants | テナント一覧取得(Get Tenants) |
| [**resetPlan**](TenantApi.md#resetPlan) | **PUT** /plans/reset | プランに関わる情報を全削除 |
| [**updateTenant**](TenantApi.md#updateTenant) | **PATCH** /tenants/{tenant_id} | テナント情報を更新(Update Tenant Details) |
| [**updateTenantBillingInfo**](TenantApi.md#updateTenantBillingInfo) | **PUT** /tenants/{tenant_id}/billing-info | テナントの請求先情報を更新(Update Tenant Billing Information) |
| [**updateTenantIdentityProvider**](TenantApi.md#updateTenantIdentityProvider) | **PUT** /tenants/{tenant_id}/identity-providers | テナント毎の外部IDプロバイダ更新(Update identity provider per tenant) |
| [**updateTenantPlan**](TenantApi.md#updateTenantPlan) | **PUT** /tenants/{tenant_id}/plans | テナントのプラン情報を更新(Update Tenant Plan Information) |


<a id="createTenant"></a>
# **createTenant**
> Tenant createTenant(body)

テナントを作成(Create Tenant)

SaaSus Platform で管理する、テナント情報を作成します。  Create a tenant managed by the SaaSus Platform. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    TenantProps body = new TenantProps(); // TenantProps | 
    try {
      Tenant result = apiInstance.createTenant(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#createTenant");
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
| **body** | **TenantProps**|  | [optional] |

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

<a id="createTenantAndPricing"></a>
# **createTenantAndPricing**
> createTenantAndPricing()

stripe初期設定(Stripe Initial Setting)

billing経由でstripeへ初期情報を設定  Set Stripe initial information via billing 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    try {
      apiInstance.createTenantAndPricing();
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#createTenantAndPricing");
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

<a id="deleteStripeTenantAndPricing"></a>
# **deleteStripeTenantAndPricing**
> deleteStripeTenantAndPricing()

stripe上の顧客情報・商品情報の削除(Delete Customer and Product From Stripe)

stripe上の顧客情報・商品情報を削除します  Delete customer and product from Stripe. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    try {
      apiInstance.deleteStripeTenantAndPricing();
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#deleteStripeTenantAndPricing");
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

<a id="deleteTenant"></a>
# **deleteTenant**
> deleteTenant(tenantId)

テナント情報を削除(Delete Tenant)

SaaSus Platform で管理する、テナントの詳細情報を削除します。  Delete SaaSus Platform tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    try {
      apiInstance.deleteTenant(tenantId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#deleteTenant");
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
| **tenantId** | **String**| テナントID(Tenant ID) | |

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

<a id="getTenant"></a>
# **getTenant**
> TenantDetail getTenant(tenantId)

テナント情報を取得(Get Tenant Details)

SaaSus Platform で管理する、テナントの詳細情報を取得します。  Get the details of tenant managed on the SaaSus Platform. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    try {
      TenantDetail result = apiInstance.getTenant(tenantId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#getTenant");
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
| **tenantId** | **String**| テナントID(Tenant ID) | |

### Return type

[**TenantDetail**](TenantDetail.md)

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

<a id="getTenantIdentityProviders"></a>
# **getTenantIdentityProviders**
> TenantIdentityProviders getTenantIdentityProviders(tenantId)

テナント毎の外部IDプロバイダ取得(Get identity provider per tenant)

テナント毎の外部IDプロバイダ経由のサインイン情報を取得します。  Get sign-in information via external identity provider per tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    try {
      TenantIdentityProviders result = apiInstance.getTenantIdentityProviders(tenantId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#getTenantIdentityProviders");
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
| **tenantId** | **String**| テナントID(Tenant ID) | |

### Return type

[**TenantIdentityProviders**](TenantIdentityProviders.md)

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

<a id="getTenants"></a>
# **getTenants**
> Tenants getTenants()

テナント一覧取得(Get Tenants)

SaaSus Platform で管理する、テナント情報の取得を行います。  Get tenants managed by SaaSus Platform. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    try {
      Tenants result = apiInstance.getTenants();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#getTenants");
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

[**Tenants**](Tenants.md)

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

<a id="resetPlan"></a>
# **resetPlan**
> resetPlan()

プランに関わる情報を全削除

料金プランに関わる情報を全削除します。 テナントに連携されたプランとプラン定義を削除します。 Stripe連携している場合、連携が解除されます。  Delete all information related to rate plans. Delete plans linked to tenants and plan definitions. If you are using the Stripe linkage, the linkage will be removed. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    try {
      apiInstance.resetPlan();
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#resetPlan");
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

<a id="updateTenant"></a>
# **updateTenant**
> updateTenant(tenantId, body)

テナント情報を更新(Update Tenant Details)

SaaSus Platform で管理する、テナントの詳細情報を更新します。  Update SaaSus Platform tenant details. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    TenantProps body = new TenantProps(); // TenantProps | 
    try {
      apiInstance.updateTenant(tenantId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#updateTenant");
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
| **body** | **TenantProps**|  | [optional] |

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

<a id="updateTenantBillingInfo"></a>
# **updateTenantBillingInfo**
> updateTenantBillingInfo(tenantId, body)

テナントの請求先情報を更新(Update Tenant Billing Information)

SaaSus Platform で管理しているテナントの請求先情報を更新します。  Update SaaSus Platform tenant billing information. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    BillingInfo body = new BillingInfo(); // BillingInfo | 
    try {
      apiInstance.updateTenantBillingInfo(tenantId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#updateTenantBillingInfo");
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
| **body** | **BillingInfo**|  | [optional] |

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
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

<a id="updateTenantIdentityProvider"></a>
# **updateTenantIdentityProvider**
> updateTenantIdentityProvider(tenantId, updateTenantIdentityProviderParam)

テナント毎の外部IDプロバイダ更新(Update identity provider per tenant)

テナント毎の外部IDプロバイダ経由のサインイン情報を更新します。  Update sign-in information via external identity provider per tenant. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    UpdateTenantIdentityProviderParam updateTenantIdentityProviderParam = new UpdateTenantIdentityProviderParam(); // UpdateTenantIdentityProviderParam | 
    try {
      apiInstance.updateTenantIdentityProvider(tenantId, updateTenantIdentityProviderParam);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#updateTenantIdentityProvider");
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
| **updateTenantIdentityProviderParam** | [**UpdateTenantIdentityProviderParam**](UpdateTenantIdentityProviderParam.md)|  | [optional] |

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

<a id="updateTenantPlan"></a>
# **updateTenantPlan**
> updateTenantPlan(tenantId, body)

テナントのプラン情報を更新(Update Tenant Plan Information)

SaaSus Platform で管理しているテナントのプラン情報を更新します。  Update SaaSus Platform tenant plan information. 

### Example
```java
// Import classes:
import saasus.sdk.auth.ApiClient;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.Configuration;
import saasus.sdk.auth.auth.*;
import saasus.sdk.auth.models.*;
import saasus.sdk.auth.api.TenantApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.saasus.io/v1/auth");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    TenantApi apiInstance = new TenantApi(defaultClient);
    String tenantId = "tenantId_example"; // String | テナントID(Tenant ID)
    PlanReservation body = new PlanReservation(); // PlanReservation | 
    try {
      apiInstance.updateTenantPlan(tenantId, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling TenantApi#updateTenantPlan");
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
| **tenantId** | **String**| テナントID(Tenant ID) | |
| **body** | **PlanReservation**|  | [optional] |

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
| **404** | Not Found |  -  |
| **500** | Internal Server Error |  -  |

