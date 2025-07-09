

# PricingTieredUsageUnit


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**upperCount** | **Integer** | Upper limit |  |
|**meteringUnitName** | **String** | Metering unit name |  |
|**aggregateUsage** | **AggregateUsage** |  |  [optional] |
|**uType** | [**UTypeEnum**](#UTypeEnum) |  |  |
|**name** | **String** | Name |  |
|**displayName** | **String** | Display Name |  |
|**description** | **String** | Description |  |
|**currency** | **Currency** |  |  |
|**tiers** | [**List&lt;PricingTier&gt;**](PricingTier.md) |  |  |
|**id** | **String** | Universally Unique Identifier |  |
|**meteringUnitId** | **String** | Universally Unique Identifier |  |
|**recurringInterval** | **RecurringInterval** |  |  |
|**used** | **Boolean** | Indicates if the unit is used |  |



## Enum: UTypeEnum

| Name | Value |
|---- | -----|
| TIERED_USAGE | &quot;tiered_usage&quot; |



