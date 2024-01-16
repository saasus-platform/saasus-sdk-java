

# UserAvailableTenant


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**name** | **String** | テナント名(tenant name) |  |
|**completedSignUp** | **Boolean** |  |  |
|**envs** | [**List&lt;UserAvailableEnv&gt;**](UserAvailableEnv.md) | 環境情報、役割(ロール)情報(environmental info, role info) |  |
|**userAttribute** | **Map&lt;String, Object&gt;** | ユーザー追加属性(user additional attributes) |  |
|**backOfficeStaffEmail** | **String** | バックオフィス担当者のメール(back office contact email) |  |
|**planId** | **String** |  |  [optional] |
|**isPaid** | **Boolean** | テナントの支払い状況(tenant payment status)  ※ 現在はストライプ連携時のみ返却されます。Currently, it is returned only when stripe is linked.  |  [optional] |



