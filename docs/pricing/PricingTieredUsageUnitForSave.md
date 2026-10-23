

# PricingTieredUsageUnitForSave


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name |  |
|**displayName** | **String** | Display Name |  |
|**description** | **String** | Description |  |
|**type** | [**TypeEnum**](#TypeEnum) |  |  |
|**currency** | **Currency** |  |  |
|**tiers** | [**List&lt;PricingTier&gt;**](PricingTier.md) |  |  |
|**upperCount** | **Integer** | Upper limit |  |
|**meteringUnitName** | **String** | Metering unit name |  |
|**aggregateUsage** | **AggregateUsage** |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TIERED_USAGE | &quot;tiered_usage&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



