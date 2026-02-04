

# TenantDetail


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**planId** | **String** |  |  [optional] |
|**billingInfo** | [**BillingInfo**](BillingInfo.md) |  |  [optional] |
|**name** | **String** | tenant name |  |
|**attributes** | **Map&lt;String, Object&gt;** | attribute info |  |
|**backOfficeStaffEmail** | **String** | administrative staff email address |  |
|**nextPlanId** | **String** |  |  [optional] |
|**usingNextPlanFrom** | **Integer** | This parameter is set when reserving a pricing plan change for a future date and time. It is not required for immediate application. When specifying the next pricing plan start date and time, please specify a date and time at least 5 minutes after the current time. Note for Stripe integration: By specifying the beginning of the current month (00:00 UTC) as the start date and time, you can create a subscription that starts from the first day of that month. (Example: To specify January 1, 2023 00:00 UTC → 1672531200)  |  [optional] |
|**nextPlanTaxRateId** | **String** |  |  [optional] |
|**prorationBehavior** | **ProrationBehavior** |  |  [optional] |
|**deleteUsage** | **Boolean** | If you have a stripe linkage,  you can set whether to delete pay-as-you-go items when changing plans. When you change plan, you can remove all pay-as-you-go items included in your current subscription to stop being billed based on pay-as-you-go items. The recorded usage is cleared immediately. Since it cannot be restored, please note that plan change reservations with delete_usage set to true cannot be canceled.  |  [optional] |
|**planHistories** | [**List&lt;PlanHistory&gt;**](PlanHistory.md) | Plan History |  |
|**currentPlanPeriodStart** | **Integer** | current plan period start |  [optional] |
|**currentPlanPeriodEnd** | **Integer** | current plan period end |  [optional] |



