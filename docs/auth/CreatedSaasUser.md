

# CreatedSaasUser


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  |
|**email** | **String** | E-mail. For sign-in ID authentication users, this field is an empty string.  |  |
|**signInId** | **String** | Sign-in ID. For email authentication users, this field is an empty string.  |  |
|**attributes** | **Map&lt;String, Object&gt;** | Attribute information  |  |
|**lastLoginAt** | **Integer** | Last login date and time (unix timestamp). Null if the user has never logged in.  |  [optional] |
|**password** | **String** | Auto-generated password (only when sign_in_id authentication and password not specified)  |  [optional] |



