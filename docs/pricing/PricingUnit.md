

# PricingUnit


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Universally Unique Identifier |  |
|**meteringUnitId** | **String** | Universally Unique Identifier |  |
|**recurringInterval** | **RecurringInterval** |  |  |
|**used** | **Boolean** |  |  |
|**uType** | [**UTypeEnum**](#UTypeEnum) |  |  |
|**upperCount** | **Integer** | Upper limit |  |
|**meteringUnitName** | **String** | Metering unit name |  |
|**aggregateUsage** | **AggregateUsage** |  |  [optional] |
|**name** | **String** | Name |  |
|**displayName** | **String** | Display Name |  |
|**description** | **String** | Description |  |
|**currency** | **Currency** |  |  |
|**tiers** | [**List&lt;PricingTier&gt;**](PricingTier.md) |  |  |
|**unitAmount** | **Integer** | Price |  |



## Enum: UTypeEnum

| Name | Value |
|---- | -----|
| FIXED | &quot;fixed&quot; |



