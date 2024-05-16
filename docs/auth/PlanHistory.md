

# PlanHistory


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**planId** | **String** |  |  |
|**planAppliedAt** | **Integer** | Registration date |  |
|**taxRateId** | **String** |  |  [optional] |
|**prorationBehavior** | **ProrationBehavior** |  |  [optional] |
|**deleteUsage** | **Boolean** | If you have a stripe linkage,  you can set whether to delete pay-as-you-go items when changing plans. When you change plan, you can remove all pay-as-you-go items included in your current subscription to stop being billed based on pay-as-you-go items. The recorded usage is cleared immediately. Since it cannot be restored, please note that plan change reservations with delete_usage set to true cannot be canceled.  |  [optional] |



