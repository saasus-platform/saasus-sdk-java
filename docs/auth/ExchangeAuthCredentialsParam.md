

# ExchangeAuthCredentialsParam


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**authFlow** | [**AuthFlowEnum**](#AuthFlowEnum) | Authentication flow used for the exchange |  |
|**code** | **String** |  |  [optional] |
|**codeVerifier** | **String** | PKCE code verifier associated with the temporary code |  [optional] |



## Enum: AuthFlowEnum

| Name | Value |
|---- | -----|
| TEMPCODEAUTH | &quot;tempCodeAuth&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



