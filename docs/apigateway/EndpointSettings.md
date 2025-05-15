

# EndpointSettings

Settings per endpoint

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**path** | **String** | Path |  |
|**method** | [**MethodEnum**](#MethodEnum) | Method |  |
|**throttling** | [**Throttling**](Throttling.md) |  |  [optional] |
|**roleNames** | **List&lt;String&gt;** | Role names that can access the endpoint |  [optional] |



## Enum: MethodEnum

| Name | Value |
|---- | -----|
| GET | &quot;GET&quot; |
| HEAD | &quot;HEAD&quot; |
| POST | &quot;POST&quot; |
| PUT | &quot;PUT&quot; |
| PATCH | &quot;PATCH&quot; |
| DELETE | &quot;DELETE&quot; |
| CONNECT | &quot;CONNECT&quot; |
| OPTIONS | &quot;OPTIONS&quot; |
| TRACE | &quot;TRACE&quot; |



