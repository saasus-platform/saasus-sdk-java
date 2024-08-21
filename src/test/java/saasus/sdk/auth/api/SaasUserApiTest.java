/*
 * SaaSus Auth API Schema
 * Schema
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package saasus.sdk.auth.api;

import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.models.ConfirmEmailUpdateParam;
import saasus.sdk.auth.models.ConfirmExternalUserLinkParam;
import saasus.sdk.auth.models.ConfirmSignUpWithAwsMarketplaceParam;
import saasus.sdk.auth.models.CreateSaasUserParam;
import saasus.sdk.auth.models.CreateSecretCodeParam;
import saasus.sdk.auth.models.Error;
import saasus.sdk.auth.models.LinkAwsMarketplaceParam;
import saasus.sdk.auth.models.MfaPreference;
import saasus.sdk.auth.models.RequestEmailUpdateParam;
import saasus.sdk.auth.models.RequestExternalUserLinkParam;
import saasus.sdk.auth.models.ResendSignUpConfirmationEmailParam;
import saasus.sdk.auth.models.SaasUser;
import saasus.sdk.auth.models.SaasUsers;
import saasus.sdk.auth.models.SignUpParam;
import saasus.sdk.auth.models.SignUpWithAwsMarketplaceParam;
import saasus.sdk.auth.models.SoftwareTokenSecretCode;
import saasus.sdk.auth.models.Tenant;
import saasus.sdk.auth.models.UpdateSaasUserAttributesParam;
import saasus.sdk.auth.models.UpdateSaasUserEmailParam;
import saasus.sdk.auth.models.UpdateSaasUserPasswordParam;
import saasus.sdk.auth.models.UpdateSoftwareTokenParam;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SaasUserApi
 */
@Disabled
public class SaasUserApiTest {

    private final SaasUserApi api = new SaasUserApi();

    /**
     * Confirm User Email Update
     *
     * Verify the code to confirm the user&#39;s email address update. Requires the user&#39;s access token. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void confirmEmailUpdateTest() throws ApiException {
        String userId = null;
        ConfirmEmailUpdateParam confirmEmailUpdateParam = null;
        api.confirmEmailUpdate(userId, confirmEmailUpdateParam);
        // TODO: test validations
    }

    /**
     * Confirm External User Account Link
     *
     * Verify the code for external account user link confirmation. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void confirmExternalUserLinkTest() throws ApiException {
        ConfirmExternalUserLinkParam confirmExternalUserLinkParam = null;
        api.confirmExternalUserLink(confirmExternalUserLinkParam);
        // TODO: test validations
    }

    /**
     * Confirm Sign Up with AWS Marketplace
     *
     * Confirm a new use registeration linked to AWS Marketplace. Create a new tenant linked to AWS Marketplace. If the Registration Token is not valid, an error is returned. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void confirmSignUpWithAwsMarketplaceTest() throws ApiException {
        ConfirmSignUpWithAwsMarketplaceParam confirmSignUpWithAwsMarketplaceParam = null;
        Tenant response = api.confirmSignUpWithAwsMarketplace(confirmSignUpWithAwsMarketplaceParam);
        // TODO: test validations
    }

    /**
     * Create SaaS User
     *
     * Create SaaS User. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createSaasUserTest() throws ApiException {
        CreateSaasUserParam createSaasUserParam = null;
        SaasUser response = api.createSaasUser(createSaasUserParam);
        // TODO: test validations
    }

    /**
     * Create secret code for authentication application registration
     *
     * Create a secret code for authentication application registration. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createSecretCodeTest() throws ApiException {
        String userId = null;
        CreateSecretCodeParam createSecretCodeParam = null;
        SoftwareTokenSecretCode response = api.createSecretCode(userId, createSecretCodeParam);
        // TODO: test validations
    }

    /**
     * Delete User
     *
     * Delete all users with matching user ID from the tenant and SaaS. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteSaasUserTest() throws ApiException {
        String userId = null;
        api.deleteSaasUser(userId);
        // TODO: test validations
    }

    /**
     * Get User
     *
     * Get user information based on user ID. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getSaasUserTest() throws ApiException {
        String userId = null;
        SaasUser response = api.getSaasUser(userId);
        // TODO: test validations
    }

    /**
     * Get Users
     *
     * Get all SaaS users. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getSaasUsersTest() throws ApiException {
        SaasUsers response = api.getSaasUsers();
        // TODO: test validations
    }

    /**
     * Get User&#39;s MFA Settings
     *
     * Get the user&#39;s MFA settings. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getUserMfaPreferenceTest() throws ApiException {
        String userId = null;
        MfaPreference response = api.getUserMfaPreference(userId);
        // TODO: test validations
    }

    /**
     * Link an existing tenant with AWS Marketplace
     *
     * Link an existing tenant with AWS Marketplace. If the Registration Token is not valid, an error is returned. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void linkAwsMarketplaceTest() throws ApiException {
        LinkAwsMarketplaceParam linkAwsMarketplaceParam = null;
        api.linkAwsMarketplace(linkAwsMarketplaceParam);
        // TODO: test validations
    }

    /**
     * Request User Email Update
     *
     * Request to update the user&#39;s email address. Sends a verification code to the requested email address. Requires the user&#39;s access token. The verification code is valid for 24 hours. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void requestEmailUpdateTest() throws ApiException {
        String userId = null;
        RequestEmailUpdateParam requestEmailUpdateParam = null;
        api.requestEmailUpdate(userId, requestEmailUpdateParam);
        // TODO: test validations
    }

    /**
     * Request External User Account Link
     *
     * Request to link an external account user. Get the email address of the user to be linked from the access token and send a verification code to that email address. The verification code is valid for 24 hours. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void requestExternalUserLinkTest() throws ApiException {
        RequestExternalUserLinkParam requestExternalUserLinkParam = null;
        api.requestExternalUserLink(requestExternalUserLinkParam);
        // TODO: test validations
    }

    /**
     * Resend Sign Up Confirmation Email
     *
     * Resend temporary password for the new registered user. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void resendSignUpConfirmationEmailTest() throws ApiException {
        ResendSignUpConfirmationEmailParam resendSignUpConfirmationEmailParam = null;
        api.resendSignUpConfirmationEmail(resendSignUpConfirmationEmailParam);
        // TODO: test validations
    }

    /**
     * Sign Up
     *
     * Register a new user. A temporary password will be sent to the registered email. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void signUpTest() throws ApiException {
        SignUpParam signUpParam = null;
        SaasUser response = api.signUp(signUpParam);
        // TODO: test validations
    }

    /**
     * Sign Up with AWS Marketplace
     *
     * Register a new user linked to AWS Marketplace. A temporary password will be sent to the registered email. If the Registration Token is not valid, an error is returned. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void signUpWithAwsMarketplaceTest() throws ApiException {
        SignUpWithAwsMarketplaceParam signUpWithAwsMarketplaceParam = null;
        SaasUser response = api.signUpWithAwsMarketplace(signUpWithAwsMarketplaceParam);
        // TODO: test validations
    }

    /**
     * Unlink external identity providers
     *
     * Unlink external identity providers. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void unlinkProviderTest() throws ApiException {
        String providerName = null;
        String userId = null;
        api.unlinkProvider(providerName, userId);
        // TODO: test validations
    }

    /**
     * Update SaaS User Attributes
     *
     * Update the additional attributes of the SaaS user. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateSaasUserAttributesTest() throws ApiException {
        String userId = null;
        UpdateSaasUserAttributesParam updateSaasUserAttributesParam = null;
        api.updateSaasUserAttributes(userId, updateSaasUserAttributesParam);
        // TODO: test validations
    }

    /**
     * Change Email
     *
     * Change user&#39;s email. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateSaasUserEmailTest() throws ApiException {
        String userId = null;
        UpdateSaasUserEmailParam updateSaasUserEmailParam = null;
        api.updateSaasUserEmail(userId, updateSaasUserEmailParam);
        // TODO: test validations
    }

    /**
     * Change Password
     *
     * Change user&#39;s login password. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateSaasUserPasswordTest() throws ApiException {
        String userId = null;
        UpdateSaasUserPasswordParam updateSaasUserPasswordParam = null;
        api.updateSaasUserPassword(userId, updateSaasUserPasswordParam);
        // TODO: test validations
    }

    /**
     * Register Authentication Application
     *
     * Register an authentication application. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateSoftwareTokenTest() throws ApiException {
        String userId = null;
        UpdateSoftwareTokenParam updateSoftwareTokenParam = null;
        api.updateSoftwareToken(userId, updateSoftwareTokenParam);
        // TODO: test validations
    }

    /**
     * Update User&#39;s MFA Settings
     *
     * Update user&#39;s MFA settings. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateUserMfaPreferenceTest() throws ApiException {
        String userId = null;
        MfaPreference body = null;
        api.updateUserMfaPreference(userId, body);
        // TODO: test validations
    }

}
