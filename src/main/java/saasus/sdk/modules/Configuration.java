package saasus.sdk.modules;

public class Configuration {

    private static final AuthApiClient authApiClient = new AuthApiClient();
    private static final PricingApiClient pricingApiClient = new PricingApiClient();
    private static final ApiLogApiClient apiLogApiClient = new ApiLogApiClient();
    private static final AwsMarketplaceClient awsMarketplaceClient = new AwsMarketplaceClient();
    private static final BillingApiClient billingApiClient = new BillingApiClient();
    private static final CommunicationApiClient communicationApiClient = new CommunicationApiClient();
    private static final IntegrationApiClient integrationApiClient = new IntegrationApiClient();
    private static final SmartApiGatewayClient smartApiGatewayClient = new SmartApiGatewayClient();

    public Configuration() {
        String urlBase = System.getenv("SAASUS_API_URL_BASE");
        if (urlBase != null) {
            authApiClient.setBasePath(urlBase + "/v1/auth");
            pricingApiClient.setBasePath(urlBase + "/v1/pricing");
            apiLogApiClient.setBasePath(urlBase + "/v1/apilog");
            awsMarketplaceClient.setBasePath(urlBase + "/v1/awsmarketplace");
            billingApiClient.setBasePath(urlBase + "/v1/billing");
            communicationApiClient.setBasePath(urlBase + "/v1/communication");
            integrationApiClient.setBasePath(urlBase + "/v1/integration");
            smartApiGatewayClient.setBasePath(urlBase + "/v1/smartapigateway");
        }
    }

    public AuthApiClient getAuthApiClient() {
        return authApiClient;
    }

    public PricingApiClient getPricingApiClient() {
        return pricingApiClient;
    }

    public ApiLogApiClient getApiLogApiClient() {
        return apiLogApiClient;
    }

    public AwsMarketplaceClient getAwsMarketplaceClient() {
        return awsMarketplaceClient;
    }

    public BillingApiClient getBillingApiClient() {
        return billingApiClient;
    }

    public CommunicationApiClient getCommunicationApiClient() {
        return communicationApiClient;
    }

    public IntegrationApiClient getIntegrationApiClient() {
        return integrationApiClient;
    }

    public SmartApiGatewayClient getSmartApiGatewayClient() {
        return smartApiGatewayClient;
    }
}
