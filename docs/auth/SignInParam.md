

# SignInParam

Parameters required for user sign-in The required parameters vary depending on the sign_in_flow. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**signInFlow** | [**SignInFlowEnum**](#SignInFlowEnum) | The sign-in flow to use for authentication. Currently, only USER_SRP_AUTH is supported.  |  |
|**signInParameters** | **Map&lt;String, String&gt;** | The required parameters vary depending on the sign_in_flow. USER_SRP_AUTH:   USERNAME: email address   SRP_A: SRP A value  |  [optional] |



## Enum: SignInFlowEnum

| Name | Value |
|---- | -----|
| USER_SRP_AUTH | &quot;USER_SRP_AUTH&quot; |



