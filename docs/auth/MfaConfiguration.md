

# MfaConfiguration

MFAデバイス認証設定(MFA device authentication settings) ※ 未提供の機能のため、変更・保存はできません(This function is not yet provided, so it cannot be changed or saved.) 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**mfaConfiguration** | [**MfaConfigurationEnum**](#MfaConfigurationEnum) | on: 全ユーザーがログイン時に適用(apply when all users log in) optional: MFA要素が有効になっている個別ユーザーに適用(apply to individual users with MFA factor enabled) ※ パラメータは現在optionalで固定となります。(The parameter is currently optional and fixed.)  |  |



## Enum: MfaConfigurationEnum

| Name | Value |
|---- | -----|
| ON | &quot;on&quot; |
| OPTIONAL | &quot;optional&quot; |



