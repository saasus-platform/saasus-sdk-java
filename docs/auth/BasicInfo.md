

# BasicInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domainName** | **String** | ドメイン名(Domain Name) |  |
|**isDnsValidated** | **Boolean** | DNSレコードの検証結果(DNS Record Verification Results) |  |
|**certificateDnsRecord** | [**DnsRecord**](DnsRecord.md) |  |  |
|**cloudFrontDnsRecord** | [**DnsRecord**](DnsRecord.md) |  |  |
|**dkimDnsRecords** | [**List&lt;DnsRecord&gt;**](DnsRecord.md) | DKIM DNS レコード(DKIM DNS Records) |  |
|**defaultDomainName** | **String** | デフォルトドメイン名(Default Domain Name) |  |
|**fromEmailAddress** | **String** | 認証メールの送信元メールアドレス(Sender Email for Authentication Email) |  |
|**replyEmailAddress** | **String** | 認証メールの返信元メールアドレス(Reply-from email address of authentication email) |  |
|**isSesSandboxGranted** | **Boolean** | SESのサンドボックス解除及びCognitoのSES設定結果(SES sandbox release and Cognito SES configuration results) |  |



