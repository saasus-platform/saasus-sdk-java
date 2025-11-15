

# UpdateApiGatewaySettingsParam


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**roleArn** | **String** | ARN of the role for SaaSus Platform to AssumeRole |  [optional] |
|**roleExternalId** | **String** | External id used by SaaSus when AssumeRole to operate SaaS |  [optional] |
|**internalEndpointHealthCheckPath** | **String** | The path to be used for health checks on the internal endpoint. |  [optional] |
|**internalEndpointHealthCheckPort** | **Integer** | The port to be used for health checks on the internal endpoint. |  [optional] |
|**internalEndpointHealthCheckProtocol** | **String** | The protocol to be used for health checks on the internal endpoint. |  [optional] |
|**internalEndpointHealthStatusCodes** | **String** | The status codes to be used for health checks on the internal endpoint. |  [optional] |
|**saasSubnetIds** | **List&lt;String&gt;** | Subnet IDs for SaaS |  [optional] |
|**saasVpcId** | **String** | VPC ID for SaaS |  [optional] |
|**domainName** | **String** | Domain Name |  [optional] |
|**saasAlbArn** | **String** | SaaS Application Load Balancer ARN |  [optional] |
|**endpointSettingsList** | [**List&lt;EndpointSettings&gt;**](EndpointSettings.md) | Endpoint Settings List |  [optional] |
|**tenantRoutingType** | **TenantRoutingType** |  |  [optional] |



