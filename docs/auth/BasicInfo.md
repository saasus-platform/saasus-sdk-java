

# BasicInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domainName** | **String** | Domain Name |  |
|**isDnsValidated** | **Boolean** | DNS Record Verification Results |  |
|**domainSetupStatus** | [**DomainSetupStatusEnum**](#DomainSetupStatusEnum) | Domain setup status. Pending means validation or configuration is in progress; action_required means user action is needed; completed means configuration has been accepted. |  [optional] |
|**domainSetupReasonCode** | [**DomainSetupReasonCodeEnum**](#DomainSetupReasonCodeEnum) | Reason domain setup is incomplete. Omitted when no known reason is available. DNS validation may still be pending while records propagate. Failed or timed-out certificate requests require resubmitting the domain settings after correcting DNS. |  [optional] |
|**certificateDnsRecord** | [**DnsRecord**](DnsRecord.md) |  |  |
|**cloudFrontDnsRecord** | [**DnsRecord**](DnsRecord.md) |  |  |
|**dkimDnsRecords** | [**List&lt;DnsRecord&gt;**](DnsRecord.md) | DKIM DNS Records |  |
|**defaultDomainName** | **String** | Default Domain Name |  |
|**fromEmailAddress** | **String** | Sender Email for Authentication Email |  |
|**replyEmailAddress** | **String** | Reply-from email address of authentication email |  |
|**isSesSandboxGranted** | **Boolean** | SES sandbox release and Cognito SES configuration results |  |



## Enum: DomainSetupStatusEnum

| Name | Value |
|---- | -----|
| DomainSetupPending | &quot;pending&quot; |
| DomainSetupActionRequired | &quot;action_required&quot; |
| DomainSetupCompleted | &quot;completed&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



## Enum: DomainSetupReasonCodeEnum

| Name | Value |
|---- | -----|
| CNAME_ALREADY_EXISTS | &quot;CNAME_ALREADY_EXISTS&quot; |
| CERTIFICATE_VALIDATION_TIMED_OUT | &quot;CERTIFICATE_VALIDATION_TIMED_OUT&quot; |
| CERTIFICATE_CAA_ERROR | &quot;CERTIFICATE_CAA_ERROR&quot; |
| CERTIFICATE_PENDING_VALIDATION | &quot;CERTIFICATE_PENDING_VALIDATION&quot; |
| CLOUDFRONT_DNS_NOT_CONFIGURED | &quot;CLOUDFRONT_DNS_NOT_CONFIGURED&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



