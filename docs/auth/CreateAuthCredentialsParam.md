

# CreateAuthCredentialsParam


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**idToken** | **String** | ID token |  |
|**accessToken** | **String** | Access token |  |
|**refreshToken** | **String** | Refresh token |  [optional] |
|**codeChallenge** | **String** | PKCE code challenge derived from the code verifier. It must be specified together with code_challenge_method. |  [optional] |
|**codeChallengeMethod** | [**CodeChallengeMethodEnum**](#CodeChallengeMethodEnum) | Method used to derive the PKCE code challenge. It must be specified together with code_challenge. |  [optional] |



## Enum: CodeChallengeMethodEnum

| Name | Value |
|---- | -----|
| S256 | &quot;S256&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



