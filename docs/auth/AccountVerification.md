

# AccountVerification

Account authentication settings ※ This function is not yet provided, so it cannot be changed or saved. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**verificationMethod** | [**VerificationMethodEnum**](#VerificationMethodEnum) | code: verification code link: verification link ※ This function is not yet provided, so it cannot be changed or saved.  |  |
|**sendingTo** | [**SendingToEnum**](#SendingToEnum) | email: e-mail sms: SMS smsOrEmail: email if SMS is not possible  |  |



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



