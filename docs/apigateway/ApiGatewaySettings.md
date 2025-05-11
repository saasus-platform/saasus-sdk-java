

# ApiGatewaySettings


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**generatedFileStatus** | **String** | Status of automatically generated files |  |
|**internalEndpointOpenapiDefinitionFileDownloadUrl** | **String** | URL to download the auto-generated openapi definition file, which will be used to build the API Gateway. |  |
|**internalEndpointMappingFileDownloadUrl** | **String** | The download URL for the auto-generated internal endpoint mapping file, which will be used to build the API Gateway. |  |
|**status** | **String** | API Gateway creation status |  |
|**roleArn** | **String** | ARN of the role for SaaSus Platform to AssumeRole |  |
|**roleExternalId** | **String** | External id used by SaaSus when AssumeRole to operate SaaS |  |
|**internalEndpointHealthCheckPath** | **String** | The path to be used for health checks on the internal endpoint. |  |
|**internalEndpointHealthCheckPort** | **Integer** | The port to be used for health checks on the internal endpoint. |  |
|**internalEndpointHealthCheckProtocol** | **String** | The protocol to be used for health checks on the internal endpoint. |  |
|**internalEndpointHealthStatusCodes** | **String** | The status codes to be used for health checks on the internal endpoint. |  |
|**saasSubnetIds** | **List&lt;String&gt;** | Subnet IDs for SaaS |  |
|**saasVpcId** | **String** | VPC ID for SaaS |  |
|**domainName** | **String** | Domain Name |  |
|**isDnsValidated** | **Boolean** | DNS Record Verification Results |  |
|**certificateDnsRecord** | [**DnsRecord**](DnsRecord.md) |  |  |
|**cloudFrontDnsRecord** | [**DnsRecord**](DnsRecord.md) |  |  |
|**vpcEndpointDnsRecord** | [**DnsRecord**](DnsRecord.md) |  |  |
|**defaultDomainName** | **String** | Default Domain Name |  |
|**saasAlbArn** | **String** | SaaS Application Load Balancer ARN |  |
|**restApiEndpoint** | **String** | The endpoint for the REST API |  |
|**endpointSettingsList** | [**List&lt;EndpointSettings&gt;**](EndpointSettings.md) | Endpoint Settings List |  |
|**tenantRoutingType** | **TenantRoutingType** |  |  |
|**docsCloudFrontFqdn** | **String** | CloudFront FQDN for Smart API Gateway Documentation |  |



