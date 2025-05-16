

# Throttling

Permit requests up to the limit number of times within a range (seconds) time for each target.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**target** | [**TargetEnum**](#TargetEnum) | Target of restriction |  |
|**range** | **Integer** | Throttling time range (seconds) |  |
|**limit** | **Integer** | Throttling limit |  |



## Enum: TargetEnum

| Name | Value |
|---- | -----|
| TENANT | &quot;tenant&quot; |
| USER | &quot;user&quot; |



