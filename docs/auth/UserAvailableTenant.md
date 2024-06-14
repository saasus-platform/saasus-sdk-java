

# UserAvailableTenant


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**name** | **String** | Tenant Name |  |
|**completedSignUp** | **Boolean** |  |  |
|**envs** | [**List&lt;UserAvailableEnv&gt;**](UserAvailableEnv.md) | environmental info, role info |  |
|**userAttribute** | **Map&lt;String, Object&gt;** | user additional attributes |  |
|**backOfficeStaffEmail** | **String** | back office contact email |  |
|**planId** | **String** |  |  [optional] |
|**isPaid** | **Boolean** | tenant payment status ※ Currently, it is returned only when stripe is linked.  |  [optional] |



