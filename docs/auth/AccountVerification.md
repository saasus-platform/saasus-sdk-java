

# AccountVerification

アカウント認証設定(account authentication settings) ※ 未提供の機能のため、変更・保存はできません(This function is not yet provided, so it cannot be changed or saved.) 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**verificationMethod** | [**VerificationMethodEnum**](#VerificationMethodEnum) | code: 検証コード(verification code) link: 検証リンク(verification link) ※ 未提供の機能のため、変更・保存はできません(This function is not yet provided, so it cannot be changed or saved.)  |  |
|**sendingTo** | [**SendingToEnum**](#SendingToEnum) | email: Eメール(e-mail) sms: SMS smsOrEmail: SMS不可の場合にEメール(email if SMS is not possible)  |  |



## Enum: VerificationMethodEnum

| Name | Value |
|---- | -----|
| CODE | &quot;code&quot; |
| LINK | &quot;link&quot; |



## Enum: SendingToEnum

| Name | Value |
|---- | -----|
| EMAIL | &quot;email&quot; |
| SMS | &quot;sms&quot; |
| SMSOREMAIL | &quot;smsOrEmail&quot; |



