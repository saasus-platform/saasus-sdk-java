package saasus.sdk.e2e.auth;

import okhttp3.Request;
import saasus.sdk.auth.ApiCallback;
import saasus.sdk.auth.ApiException;
import saasus.sdk.auth.ApiResponse;
import saasus.sdk.auth.api.AuthInfoApi;
import saasus.sdk.auth.api.BasicInfoApi;
import saasus.sdk.auth.api.CredentialApi;
import saasus.sdk.auth.api.EnvApi;
import saasus.sdk.auth.api.InvitationApi;
import saasus.sdk.auth.api.RoleApi;
import saasus.sdk.auth.api.SaasUserApi;
import saasus.sdk.auth.api.SingleTenantApi;
import saasus.sdk.auth.api.TenantApi;
import saasus.sdk.auth.api.TenantAttributeApi;
import saasus.sdk.auth.api.TenantUserApi;
import saasus.sdk.auth.api.UserAttributeApi;
import saasus.sdk.auth.api.UserInfoApi;
import saasus.sdk.auth.models.Attribute;
import saasus.sdk.auth.models.AuthInfo;
import saasus.sdk.auth.models.AuthorizationTempCode;
import saasus.sdk.auth.models.BasicInfo;
import saasus.sdk.auth.models.CloudFormationLaunchStackLink;
import saasus.sdk.auth.models.ConfirmDeviceResult;
import saasus.sdk.auth.models.CreatedSaasUser;
import saasus.sdk.auth.models.Credentials;
import saasus.sdk.auth.models.CustomizePageSettings;
import saasus.sdk.auth.models.CustomizePages;
import saasus.sdk.auth.models.Env;
import saasus.sdk.auth.models.Envs;
import saasus.sdk.auth.models.IdentityProviders;
import saasus.sdk.auth.models.Invitation;
import saasus.sdk.auth.models.InvitationValidity;
import saasus.sdk.auth.models.Invitations;
import saasus.sdk.auth.models.MfaPreference;
import saasus.sdk.auth.models.NotificationMessages;
import saasus.sdk.auth.models.RespondToSignInChallengeResult;
import saasus.sdk.auth.models.Role;
import saasus.sdk.auth.models.Roles;
import saasus.sdk.auth.models.SaasUser;
import saasus.sdk.auth.models.SaasUserResetPasswordResult;
import saasus.sdk.auth.models.SaasUsers;
import saasus.sdk.auth.models.SignInResult;
import saasus.sdk.auth.models.SignInSettings;
import saasus.sdk.auth.models.SingleTenantSettings;
import saasus.sdk.auth.models.SoftwareTokenSecretCode;
import saasus.sdk.auth.models.StripeCustomer;
import saasus.sdk.auth.models.Tenant;
import saasus.sdk.auth.models.TenantAttributes;
import saasus.sdk.auth.models.TenantDetail;
import saasus.sdk.auth.models.TenantIdentityProviders;
import saasus.sdk.auth.models.Tenants;
import saasus.sdk.auth.models.User;
import saasus.sdk.auth.models.UserAttributes;
import saasus.sdk.auth.models.UserInfo;
import saasus.sdk.auth.models.Users;
import saasus.sdk.e2e.support.ThrowingCallSupplier;
import saasus.sdk.modules.AuthApiClient;
import saasus.sdk.modules.Utils;
import saasus.sdk.testlib.AsyncSink;
import saasus.sdk.testlib.HttpInfo;
import saasus.sdk.testlib.HttpInfoCall;
import saasus.sdk.testlib.MethodInvokers;
import saasus.sdk.testlib.MethodRegistry;
import saasus.sdk.testlib.NormalCall;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Registers every auth API method (across the 13 functional API classes) against a
 * {@link MethodRegistry} using all four call styles (NORMAL / WITH_HTTP_INFO / ASYNC / CALL).
 *
 * <p>The {@code ReturnInternalServerError} debug endpoint is intentionally excluded (matching the
 * Go reference). Following the Go reference, the Stripe-integration steps
 * ({@code createTenantAndPricing}, {@code deleteStripeTenantAndPricing}, {@code getStripeCustomer})
 * are skipped at runtime unless {@code STRIPE_SECRET_KEY} is set, while {@code resetPlan} and
 * {@code updateIdentityProvider} run unconditionally — so this suite expects a dedicated test SaaS.
 * {@link AuthApiClient} only signs the synchronous {@code execute(Call, Type)} path, so ASYNC
 * requests are signed manually (as in {@code billing.BillingInvokers}).
 */
final class AuthInvokers {

    private final AuthApiClient client;

    private final AuthInfoApi authInfo;
    private final BasicInfoApi basicInfo;
    private final CredentialApi credential;
    private final EnvApi env;
    private final InvitationApi invitation;
    private final RoleApi role;
    private final SaasUserApi saasUser;
    private final SingleTenantApi singleTenant;
    private final TenantApi tenant;
    private final TenantAttributeApi tenantAttribute;
    private final TenantUserApi tenantUser;
    private final UserAttributeApi userAttribute;
    private final UserInfoApi userInfo;

    AuthInvokers(AuthApiClient client) {
        this.client = client;
        this.authInfo = new AuthInfoApi(client);
        this.basicInfo = new BasicInfoApi(client);
        this.credential = new CredentialApi(client);
        this.env = new EnvApi(client);
        this.invitation = new InvitationApi(client);
        this.role = new RoleApi(client);
        this.saasUser = new SaasUserApi(client);
        this.singleTenant = new SingleTenantApi(client);
        this.tenant = new TenantApi(client);
        this.tenantAttribute = new TenantAttributeApi(client);
        this.tenantUser = new TenantUserApi(client);
        this.userAttribute = new UserAttributeApi(client);
        this.userInfo = new UserInfoApi(client);
    }

    MethodRegistry buildRegistry() {
        MethodRegistry r = new MethodRegistry();
        registerBasicInfo(r);
        registerAuthInfo(r);
        registerSaasUser(r);
        registerUserInfo(r);
        registerRole(r);
        registerUserAttribute(r);
        registerTenantAttribute(r);
        registerEnv(r);
        registerTenant(r);
        registerTenantUser(r);
        registerInvitation(r);
        registerCredential(r);
        registerSingleTenant(r);
        return r;
    }

    // ---- BasicInfoApi -----------------------------------------------------------

    private void registerBasicInfo(MethodRegistry r) {
        r.register("getBasicInfo", make(
                v -> basicInfo.getBasicInfo(),
                v -> httpInfo(basicInfo.getBasicInfoWithHttpInfo()),
                v -> basicInfo.getBasicInfoCall(null), BasicInfo.class));
        r.register("updateBasicInfo", makeVoid(
                v -> { basicInfo.updateBasicInfo(AuthParams.updateBasicInfoParam(v)); return null; },
                v -> httpInfo(basicInfo.updateBasicInfoWithHttpInfo(AuthParams.updateBasicInfoParam(v))),
                v -> basicInfo.updateBasicInfoCall(AuthParams.updateBasicInfoParam(v), null)));
        r.register("findNotificationMessages", make(
                v -> basicInfo.findNotificationMessages(),
                v -> httpInfo(basicInfo.findNotificationMessagesWithHttpInfo()),
                v -> basicInfo.findNotificationMessagesCall(null), NotificationMessages.class));
        r.register("updateNotificationMessages", makeVoid(
                v -> { basicInfo.updateNotificationMessages(AuthParams.updateNotificationMessagesParam(v)); return null; },
                v -> httpInfo(basicInfo.updateNotificationMessagesWithHttpInfo(AuthParams.updateNotificationMessagesParam(v))),
                v -> basicInfo.updateNotificationMessagesCall(AuthParams.updateNotificationMessagesParam(v), null)));
        r.register("getCustomizePages", make(
                v -> basicInfo.getCustomizePages(),
                v -> httpInfo(basicInfo.getCustomizePagesWithHttpInfo()),
                v -> basicInfo.getCustomizePagesCall(null), CustomizePages.class));
        r.register("updateCustomizePages", makeVoid(
                v -> { basicInfo.updateCustomizePages(AuthParams.updateCustomizePagesParam(v)); return null; },
                v -> httpInfo(basicInfo.updateCustomizePagesWithHttpInfo(AuthParams.updateCustomizePagesParam(v))),
                v -> basicInfo.updateCustomizePagesCall(AuthParams.updateCustomizePagesParam(v), null)));
        r.register("getCustomizePageSettings", make(
                v -> basicInfo.getCustomizePageSettings(),
                v -> httpInfo(basicInfo.getCustomizePageSettingsWithHttpInfo()),
                v -> basicInfo.getCustomizePageSettingsCall(null), CustomizePageSettings.class));
        r.register("updateCustomizePageSettings", makeVoid(
                v -> { basicInfo.updateCustomizePageSettings(AuthParams.updateCustomizePageSettingsParam(v)); return null; },
                v -> httpInfo(basicInfo.updateCustomizePageSettingsWithHttpInfo(AuthParams.updateCustomizePageSettingsParam(v))),
                v -> basicInfo.updateCustomizePageSettingsCall(AuthParams.updateCustomizePageSettingsParam(v), null)));
    }

    // ---- AuthInfoApi ------------------------------------------------------------

    private void registerAuthInfo(MethodRegistry r) {
        r.register("getAuthInfo", make(
                v -> authInfo.getAuthInfo(),
                v -> httpInfo(authInfo.getAuthInfoWithHttpInfo()),
                v -> authInfo.getAuthInfoCall(null), AuthInfo.class));
        r.register("updateAuthInfo", makeVoid(
                v -> { authInfo.updateAuthInfo(AuthParams.authInfo(v)); return null; },
                v -> httpInfo(authInfo.updateAuthInfoWithHttpInfo(AuthParams.authInfo(v))),
                v -> authInfo.updateAuthInfoCall(AuthParams.authInfo(v), null)));
        r.register("getIdentityProviders", make(
                v -> authInfo.getIdentityProviders(),
                v -> httpInfo(authInfo.getIdentityProvidersWithHttpInfo()),
                v -> authInfo.getIdentityProvidersCall(null), IdentityProviders.class));
        r.register("updateIdentityProvider", makeVoid(
                v -> { authInfo.updateIdentityProvider(AuthParams.updateIdentityProviderParam(v)); return null; },
                v -> httpInfo(authInfo.updateIdentityProviderWithHttpInfo(AuthParams.updateIdentityProviderParam(v))),
                v -> authInfo.updateIdentityProviderCall(AuthParams.updateIdentityProviderParam(v), null)));
        r.register("getSignInSettings", make(
                v -> authInfo.getSignInSettings(),
                v -> httpInfo(authInfo.getSignInSettingsWithHttpInfo()),
                v -> authInfo.getSignInSettingsCall(null), SignInSettings.class));
        r.register("updateSignInSettings", makeVoid(
                v -> { authInfo.updateSignInSettings(AuthParams.updateSignInSettingsParam(v)); return null; },
                v -> httpInfo(authInfo.updateSignInSettingsWithHttpInfo(AuthParams.updateSignInSettingsParam(v))),
                v -> authInfo.updateSignInSettingsCall(AuthParams.updateSignInSettingsParam(v), null)));
    }

    // ---- SaasUserApi ------------------------------------------------------------

    private void registerSaasUser(MethodRegistry r) {
        r.register("getSaasUsers", make(
                v -> saasUser.getSaasUsers(),
                v -> httpInfo(saasUser.getSaasUsersWithHttpInfo()),
                v -> saasUser.getSaasUsersCall(null), SaasUsers.class));
        r.register("createSaasUser", make(
                v -> saasUser.createSaasUser(AuthParams.createSaasUserParam(v)),
                v -> httpInfo(saasUser.createSaasUserWithHttpInfo(AuthParams.createSaasUserParam(v))),
                v -> saasUser.createSaasUserCall(AuthParams.createSaasUserParam(v), null), CreatedSaasUser.class));
        r.register("getSaasUser", make(
                v -> saasUser.getSaasUser(AuthParams.userId(v)),
                v -> httpInfo(saasUser.getSaasUserWithHttpInfo(AuthParams.userId(v))),
                v -> saasUser.getSaasUserCall(AuthParams.userId(v), null), SaasUser.class));
        r.register("deleteSaasUser", make(
                v -> saasUser.deleteSaasUser(AuthParams.userId(v)),
                v -> httpInfo(saasUser.deleteSaasUserWithHttpInfo(AuthParams.userId(v))),
                v -> saasUser.deleteSaasUserCall(AuthParams.userId(v), null), UserInfo.class));
        r.register("updateSaasUserPassword", makeVoid(
                v -> { saasUser.updateSaasUserPassword(AuthParams.userId(v), AuthParams.updateSaasUserPasswordParam(v)); return null; },
                v -> httpInfo(saasUser.updateSaasUserPasswordWithHttpInfo(AuthParams.userId(v), AuthParams.updateSaasUserPasswordParam(v))),
                v -> saasUser.updateSaasUserPasswordCall(AuthParams.userId(v), AuthParams.updateSaasUserPasswordParam(v), null)));
        r.register("updateSaasUserEmail", makeVoid(
                v -> { saasUser.updateSaasUserEmail(AuthParams.userId(v), AuthParams.updateSaasUserEmailParam(v)); return null; },
                v -> httpInfo(saasUser.updateSaasUserEmailWithHttpInfo(AuthParams.userId(v), AuthParams.updateSaasUserEmailParam(v))),
                v -> saasUser.updateSaasUserEmailCall(AuthParams.userId(v), AuthParams.updateSaasUserEmailParam(v), null)));
        r.register("updateSaasUserSignInId", makeVoid(
                v -> { saasUser.updateSaasUserSignInId(AuthParams.userId(v), AuthParams.updateSaasUserSignInIdParam(v)); return null; },
                v -> httpInfo(saasUser.updateSaasUserSignInIdWithHttpInfo(AuthParams.userId(v), AuthParams.updateSaasUserSignInIdParam(v))),
                v -> saasUser.updateSaasUserSignInIdCall(AuthParams.userId(v), AuthParams.updateSaasUserSignInIdParam(v), null)));
        r.register("updateSaasUserAttributes", makeVoid(
                v -> { saasUser.updateSaasUserAttributes(AuthParams.userId(v), AuthParams.updateSaasUserAttributesParam(v)); return null; },
                v -> httpInfo(saasUser.updateSaasUserAttributesWithHttpInfo(AuthParams.userId(v), AuthParams.updateSaasUserAttributesParam(v))),
                v -> saasUser.updateSaasUserAttributesCall(AuthParams.userId(v), AuthParams.updateSaasUserAttributesParam(v), null)));
        r.register("resetSaasUserPassword", make(
                v -> saasUser.resetSaasUserPassword(AuthParams.userId(v)),
                v -> httpInfo(saasUser.resetSaasUserPasswordWithHttpInfo(AuthParams.userId(v))),
                v -> saasUser.resetSaasUserPasswordCall(AuthParams.userId(v), null), SaasUserResetPasswordResult.class));
        r.register("signUp", make(
                v -> saasUser.signUp(AuthParams.signUpParam(v)),
                v -> httpInfo(saasUser.signUpWithHttpInfo(AuthParams.signUpParam(v))),
                v -> saasUser.signUpCall(AuthParams.signUpParam(v), null), SaasUser.class));
        r.register("resendSignUpConfirmationEmail", makeVoid(
                v -> { saasUser.resendSignUpConfirmationEmail(AuthParams.resendSignUpConfirmationEmailParam(v)); return null; },
                v -> httpInfo(saasUser.resendSignUpConfirmationEmailWithHttpInfo(AuthParams.resendSignUpConfirmationEmailParam(v))),
                v -> saasUser.resendSignUpConfirmationEmailCall(AuthParams.resendSignUpConfirmationEmailParam(v), null)));
        r.register("signIn", make(
                v -> saasUser.signIn(AuthParams.signInParam(v)),
                v -> httpInfo(saasUser.signInWithHttpInfo(AuthParams.signInParam(v))),
                v -> saasUser.signInCall(AuthParams.signInParam(v), null), SignInResult.class));
        r.register("respondToSignInChallenge", make(
                v -> saasUser.respondToSignInChallenge(AuthParams.respondToSignInChallengeParam(v)),
                v -> httpInfo(saasUser.respondToSignInChallengeWithHttpInfo(AuthParams.respondToSignInChallengeParam(v))),
                v -> saasUser.respondToSignInChallengeCall(AuthParams.respondToSignInChallengeParam(v), null),
                RespondToSignInChallengeResult.class));
        r.register("requestEmailUpdate", makeVoid(
                v -> { saasUser.requestEmailUpdate(AuthParams.userId(v), AuthParams.requestEmailUpdateParam(v)); return null; },
                v -> httpInfo(saasUser.requestEmailUpdateWithHttpInfo(AuthParams.userId(v), AuthParams.requestEmailUpdateParam(v))),
                v -> saasUser.requestEmailUpdateCall(AuthParams.userId(v), AuthParams.requestEmailUpdateParam(v), null)));
        r.register("confirmEmailUpdate", makeVoid(
                v -> { saasUser.confirmEmailUpdate(AuthParams.userId(v), AuthParams.confirmEmailUpdateParam(v)); return null; },
                v -> httpInfo(saasUser.confirmEmailUpdateWithHttpInfo(AuthParams.userId(v), AuthParams.confirmEmailUpdateParam(v))),
                v -> saasUser.confirmEmailUpdateCall(AuthParams.userId(v), AuthParams.confirmEmailUpdateParam(v), null)));
        r.register("requestExternalUserLink", makeVoid(
                v -> { saasUser.requestExternalUserLink(AuthParams.requestExternalUserLinkParam(v)); return null; },
                v -> httpInfo(saasUser.requestExternalUserLinkWithHttpInfo(AuthParams.requestExternalUserLinkParam(v))),
                v -> saasUser.requestExternalUserLinkCall(AuthParams.requestExternalUserLinkParam(v), null)));
        r.register("confirmExternalUserLink", makeVoid(
                v -> { saasUser.confirmExternalUserLink(AuthParams.confirmExternalUserLinkParam(v)); return null; },
                v -> httpInfo(saasUser.confirmExternalUserLinkWithHttpInfo(AuthParams.confirmExternalUserLinkParam(v))),
                v -> saasUser.confirmExternalUserLinkCall(AuthParams.confirmExternalUserLinkParam(v), null)));
        r.register("unlinkProvider", makeVoid(
                v -> { saasUser.unlinkProvider(AuthParams.providerName(v), AuthParams.userId(v)); return null; },
                v -> httpInfo(saasUser.unlinkProviderWithHttpInfo(AuthParams.providerName(v), AuthParams.userId(v))),
                v -> saasUser.unlinkProviderCall(AuthParams.providerName(v), AuthParams.userId(v), null)));
        r.register("getUserMfaPreference", make(
                v -> saasUser.getUserMfaPreference(AuthParams.userId(v)),
                v -> httpInfo(saasUser.getUserMfaPreferenceWithHttpInfo(AuthParams.userId(v))),
                v -> saasUser.getUserMfaPreferenceCall(AuthParams.userId(v), null), MfaPreference.class));
        r.register("updateUserMfaPreference", makeVoid(
                v -> { saasUser.updateUserMfaPreference(AuthParams.userId(v), AuthParams.mfaPreference(v)); return null; },
                v -> httpInfo(saasUser.updateUserMfaPreferenceWithHttpInfo(AuthParams.userId(v), AuthParams.mfaPreference(v))),
                v -> saasUser.updateUserMfaPreferenceCall(AuthParams.userId(v), AuthParams.mfaPreference(v), null)));
        r.register("createSecretCode", make(
                v -> saasUser.createSecretCode(AuthParams.userId(v), AuthParams.createSecretCodeParam(v)),
                v -> httpInfo(saasUser.createSecretCodeWithHttpInfo(AuthParams.userId(v), AuthParams.createSecretCodeParam(v))),
                v -> saasUser.createSecretCodeCall(AuthParams.userId(v), AuthParams.createSecretCodeParam(v), null),
                SoftwareTokenSecretCode.class));
        r.register("updateSoftwareToken", makeVoid(
                v -> { saasUser.updateSoftwareToken(AuthParams.userId(v), AuthParams.updateSoftwareTokenParam(v)); return null; },
                v -> httpInfo(saasUser.updateSoftwareTokenWithHttpInfo(AuthParams.userId(v), AuthParams.updateSoftwareTokenParam(v))),
                v -> saasUser.updateSoftwareTokenCall(AuthParams.userId(v), AuthParams.updateSoftwareTokenParam(v), null)));
        r.register("confirmDevice", make(
                v -> saasUser.confirmDevice(AuthParams.confirmDeviceParam(v)),
                v -> httpInfo(saasUser.confirmDeviceWithHttpInfo(AuthParams.confirmDeviceParam(v))),
                v -> saasUser.confirmDeviceCall(AuthParams.confirmDeviceParam(v), null), ConfirmDeviceResult.class));
        r.register("updateDeviceStatus", makeVoid(
                v -> { saasUser.updateDeviceStatus(AuthParams.updateDeviceStatusParam(v)); return null; },
                v -> httpInfo(saasUser.updateDeviceStatusWithHttpInfo(AuthParams.updateDeviceStatusParam(v))),
                v -> saasUser.updateDeviceStatusCall(AuthParams.updateDeviceStatusParam(v), null)));
        r.register("linkAwsMarketplace", makeVoid(
                v -> { saasUser.linkAwsMarketplace(AuthParams.linkAwsMarketplaceParam(v)); return null; },
                v -> httpInfo(saasUser.linkAwsMarketplaceWithHttpInfo(AuthParams.linkAwsMarketplaceParam(v))),
                v -> saasUser.linkAwsMarketplaceCall(AuthParams.linkAwsMarketplaceParam(v), null)));
        r.register("signUpWithAwsMarketplace", make(
                v -> saasUser.signUpWithAwsMarketplace(AuthParams.signUpWithAwsMarketplaceParam(v)),
                v -> httpInfo(saasUser.signUpWithAwsMarketplaceWithHttpInfo(AuthParams.signUpWithAwsMarketplaceParam(v))),
                v -> saasUser.signUpWithAwsMarketplaceCall(AuthParams.signUpWithAwsMarketplaceParam(v), null), SaasUser.class));
        r.register("confirmSignUpWithAwsMarketplace", make(
                v -> saasUser.confirmSignUpWithAwsMarketplace(AuthParams.confirmSignUpWithAwsMarketplaceParam(v)),
                v -> httpInfo(saasUser.confirmSignUpWithAwsMarketplaceWithHttpInfo(AuthParams.confirmSignUpWithAwsMarketplaceParam(v))),
                v -> saasUser.confirmSignUpWithAwsMarketplaceCall(AuthParams.confirmSignUpWithAwsMarketplaceParam(v), null), Tenant.class));
    }

    // ---- UserInfoApi ------------------------------------------------------------

    private void registerUserInfo(MethodRegistry r) {
        r.register("getUserInfo", make(
                v -> userInfo.getUserInfo(AuthParams.token(v)),
                v -> httpInfo(userInfo.getUserInfoWithHttpInfo(AuthParams.token(v))),
                v -> userInfo.getUserInfoCall(AuthParams.token(v), null), UserInfo.class));
        r.register("getUserInfoByEmail", make(
                v -> userInfo.getUserInfoByEmail(AuthParams.email(v)),
                v -> httpInfo(userInfo.getUserInfoByEmailWithHttpInfo(AuthParams.email(v))),
                v -> userInfo.getUserInfoByEmailCall(AuthParams.email(v), null), UserInfo.class));
        r.register("getUserInfoBySignInId", make(
                v -> userInfo.getUserInfoBySignInId(AuthParams.signInId(v)),
                v -> httpInfo(userInfo.getUserInfoBySignInIdWithHttpInfo(AuthParams.signInId(v))),
                v -> userInfo.getUserInfoBySignInIdCall(AuthParams.signInId(v), null), UserInfo.class));
    }

    // ---- RoleApi ----------------------------------------------------------------

    private void registerRole(MethodRegistry r) {
        r.register("getRoles", make(
                v -> role.getRoles(),
                v -> httpInfo(role.getRolesWithHttpInfo()),
                v -> role.getRolesCall(null), Roles.class));
        r.register("createRole", make(
                v -> role.createRole(AuthParams.role(v)),
                v -> httpInfo(role.createRoleWithHttpInfo(AuthParams.role(v))),
                v -> role.createRoleCall(AuthParams.role(v), null), Role.class));
        r.register("updateRole", makeVoid(
                v -> { role.updateRole(AuthParams.roleName(v), AuthParams.updateRoleParam(v)); return null; },
                v -> httpInfo(role.updateRoleWithHttpInfo(AuthParams.roleName(v), AuthParams.updateRoleParam(v))),
                v -> role.updateRoleCall(AuthParams.roleName(v), AuthParams.updateRoleParam(v), null)));
        r.register("deleteRole", makeVoid(
                v -> { role.deleteRole(AuthParams.roleName(v)); return null; },
                v -> httpInfo(role.deleteRoleWithHttpInfo(AuthParams.roleName(v))),
                v -> role.deleteRoleCall(AuthParams.roleName(v), null)));
    }

    // ---- UserAttributeApi -------------------------------------------------------

    private void registerUserAttribute(MethodRegistry r) {
        r.register("getUserAttributes", make(
                v -> userAttribute.getUserAttributes(),
                v -> httpInfo(userAttribute.getUserAttributesWithHttpInfo()),
                v -> userAttribute.getUserAttributesCall(null), UserAttributes.class));
        r.register("createUserAttribute", make(
                v -> userAttribute.createUserAttribute(AuthParams.userAttribute(v)),
                v -> httpInfo(userAttribute.createUserAttributeWithHttpInfo(AuthParams.userAttribute(v))),
                v -> userAttribute.createUserAttributeCall(AuthParams.userAttribute(v), null), Attribute.class));
        r.register("createSaasUserAttribute", make(
                v -> userAttribute.createSaasUserAttribute(AuthParams.saasUserAttribute(v)),
                v -> httpInfo(userAttribute.createSaasUserAttributeWithHttpInfo(AuthParams.saasUserAttribute(v))),
                v -> userAttribute.createSaasUserAttributeCall(AuthParams.saasUserAttribute(v), null), Attribute.class));
        r.register("deleteUserAttribute", makeVoid(
                v -> { userAttribute.deleteUserAttribute(AuthParams.userAttributeName(v)); return null; },
                v -> httpInfo(userAttribute.deleteUserAttributeWithHttpInfo(AuthParams.userAttributeName(v))),
                v -> userAttribute.deleteUserAttributeCall(AuthParams.userAttributeName(v), null)));
    }

    // ---- TenantAttributeApi -----------------------------------------------------

    private void registerTenantAttribute(MethodRegistry r) {
        r.register("getTenantAttributes", make(
                v -> tenantAttribute.getTenantAttributes(),
                v -> httpInfo(tenantAttribute.getTenantAttributesWithHttpInfo()),
                v -> tenantAttribute.getTenantAttributesCall(null), TenantAttributes.class));
        r.register("createTenantAttribute", make(
                v -> tenantAttribute.createTenantAttribute(AuthParams.tenantAttribute(v)),
                v -> httpInfo(tenantAttribute.createTenantAttributeWithHttpInfo(AuthParams.tenantAttribute(v))),
                v -> tenantAttribute.createTenantAttributeCall(AuthParams.tenantAttribute(v), null), Attribute.class));
        r.register("deleteTenantAttribute", makeVoid(
                v -> { tenantAttribute.deleteTenantAttribute(AuthParams.tenantAttributeName(v)); return null; },
                v -> httpInfo(tenantAttribute.deleteTenantAttributeWithHttpInfo(AuthParams.tenantAttributeName(v))),
                v -> tenantAttribute.deleteTenantAttributeCall(AuthParams.tenantAttributeName(v), null)));
    }

    // ---- EnvApi -----------------------------------------------------------------

    private void registerEnv(MethodRegistry r) {
        r.register("getEnvs", make(
                v -> env.getEnvs(),
                v -> httpInfo(env.getEnvsWithHttpInfo()),
                v -> env.getEnvsCall(null), Envs.class));
        r.register("createEnv", make(
                v -> env.createEnv(AuthParams.env(v)),
                v -> httpInfo(env.createEnvWithHttpInfo(AuthParams.env(v))),
                v -> env.createEnvCall(AuthParams.env(v), null), Env.class));
        r.register("getEnv", make(
                v -> env.getEnv(AuthParams.operableEnvId(v)),
                v -> httpInfo(env.getEnvWithHttpInfo(AuthParams.operableEnvId(v))),
                v -> env.getEnvCall(AuthParams.operableEnvId(v), null), Env.class));
        r.register("updateEnv", makeVoid(
                v -> { env.updateEnv(AuthParams.operableEnvId(v), AuthParams.updateEnvParam(v)); return null; },
                v -> httpInfo(env.updateEnvWithHttpInfo(AuthParams.operableEnvId(v), AuthParams.updateEnvParam(v))),
                v -> env.updateEnvCall(AuthParams.operableEnvId(v), AuthParams.updateEnvParam(v), null)));
        r.register("deleteEnv", makeVoid(
                v -> { env.deleteEnv(AuthParams.operableEnvId(v)); return null; },
                v -> httpInfo(env.deleteEnvWithHttpInfo(AuthParams.operableEnvId(v))),
                v -> env.deleteEnvCall(AuthParams.operableEnvId(v), null)));
    }

    // ---- TenantApi --------------------------------------------------------------

    private void registerTenant(MethodRegistry r) {
        r.register("getTenants", make(
                v -> tenant.getTenants(),
                v -> httpInfo(tenant.getTenantsWithHttpInfo()),
                v -> tenant.getTenantsCall(null), Tenants.class));
        r.register("createTenant", make(
                v -> tenant.createTenant(AuthParams.tenantProps(v)),
                v -> httpInfo(tenant.createTenantWithHttpInfo(AuthParams.tenantProps(v))),
                v -> tenant.createTenantCall(AuthParams.tenantProps(v), null), Tenant.class));
        r.register("getTenant", make(
                v -> tenant.getTenant(AuthParams.tenantId(v)),
                v -> httpInfo(tenant.getTenantWithHttpInfo(AuthParams.tenantId(v))),
                v -> tenant.getTenantCall(AuthParams.tenantId(v), null), TenantDetail.class));
        r.register("updateTenant", makeVoid(
                v -> { tenant.updateTenant(AuthParams.mutableTenantId(v), AuthParams.tenantProps(v)); return null; },
                v -> httpInfo(tenant.updateTenantWithHttpInfo(AuthParams.mutableTenantId(v), AuthParams.tenantProps(v))),
                v -> tenant.updateTenantCall(AuthParams.mutableTenantId(v), AuthParams.tenantProps(v), null)));
        r.register("deleteTenant", makeVoid(
                v -> { tenant.deleteTenant(AuthParams.deletableTenantId(v)); return null; },
                v -> httpInfo(tenant.deleteTenantWithHttpInfo(AuthParams.deletableTenantId(v))),
                v -> tenant.deleteTenantCall(AuthParams.deletableTenantId(v), null)));
        r.register("updateTenantBillingInfo", makeVoid(
                v -> { tenant.updateTenantBillingInfo(AuthParams.mutableTenantId(v), AuthParams.billingInfo(v)); return null; },
                v -> httpInfo(tenant.updateTenantBillingInfoWithHttpInfo(AuthParams.mutableTenantId(v), AuthParams.billingInfo(v))),
                v -> tenant.updateTenantBillingInfoCall(AuthParams.mutableTenantId(v), AuthParams.billingInfo(v), null)));
        r.register("getStripeCustomer", make(
                v -> tenant.getStripeCustomer(AuthParams.tenantId(v)),
                v -> httpInfo(tenant.getStripeCustomerWithHttpInfo(AuthParams.tenantId(v))),
                v -> tenant.getStripeCustomerCall(AuthParams.tenantId(v), null), StripeCustomer.class));
        r.register("updateTenantPlan", makeVoid(
                v -> { tenant.updateTenantPlan(AuthParams.mutableTenantId(v), AuthParams.planReservation(v)); return null; },
                v -> httpInfo(tenant.updateTenantPlanWithHttpInfo(AuthParams.mutableTenantId(v), AuthParams.planReservation(v))),
                v -> tenant.updateTenantPlanCall(AuthParams.mutableTenantId(v), AuthParams.planReservation(v), null)));
        r.register("resetPlan", makeVoid(
                v -> { tenant.resetPlan(); return null; },
                v -> httpInfo(tenant.resetPlanWithHttpInfo()),
                v -> tenant.resetPlanCall(null)));
        r.register("createTenantAndPricing", makeVoid(
                v -> { tenant.createTenantAndPricing(); return null; },
                v -> httpInfo(tenant.createTenantAndPricingWithHttpInfo()),
                v -> tenant.createTenantAndPricingCall(null)));
        r.register("deleteStripeTenantAndPricing", makeVoid(
                v -> { tenant.deleteStripeTenantAndPricing(); return null; },
                v -> httpInfo(tenant.deleteStripeTenantAndPricingWithHttpInfo()),
                v -> tenant.deleteStripeTenantAndPricingCall(null)));
        r.register("getTenantIdentityProviders", make(
                v -> tenant.getTenantIdentityProviders(AuthParams.tenantId(v)),
                v -> httpInfo(tenant.getTenantIdentityProvidersWithHttpInfo(AuthParams.tenantId(v))),
                v -> tenant.getTenantIdentityProvidersCall(AuthParams.tenantId(v), null), TenantIdentityProviders.class));
        r.register("updateTenantIdentityProvider", makeVoid(
                v -> { tenant.updateTenantIdentityProvider(AuthParams.mutableTenantId(v), AuthParams.updateTenantIdentityProviderParam(v)); return null; },
                v -> httpInfo(tenant.updateTenantIdentityProviderWithHttpInfo(AuthParams.mutableTenantId(v), AuthParams.updateTenantIdentityProviderParam(v))),
                v -> tenant.updateTenantIdentityProviderCall(AuthParams.mutableTenantId(v), AuthParams.updateTenantIdentityProviderParam(v), null)));
    }

    // ---- TenantUserApi ----------------------------------------------------------

    private void registerTenantUser(MethodRegistry r) {
        r.register("getAllTenantUsers", make(
                v -> tenantUser.getAllTenantUsers(),
                v -> httpInfo(tenantUser.getAllTenantUsersWithHttpInfo()),
                v -> tenantUser.getAllTenantUsersCall(null), Users.class));
        r.register("getAllTenantUser", make(
                v -> tenantUser.getAllTenantUser(AuthParams.userId(v)),
                v -> httpInfo(tenantUser.getAllTenantUserWithHttpInfo(AuthParams.userId(v))),
                v -> tenantUser.getAllTenantUserCall(AuthParams.userId(v), null), Users.class));
        r.register("getTenantUsers", make(
                v -> tenantUser.getTenantUsers(AuthParams.tenantId(v)),
                v -> httpInfo(tenantUser.getTenantUsersWithHttpInfo(AuthParams.tenantId(v))),
                v -> tenantUser.getTenantUsersCall(AuthParams.tenantId(v), null), Users.class));
        r.register("createTenantUser", make(
                v -> tenantUser.createTenantUser(AuthParams.tenantId(v), AuthParams.createTenantUserParam(v)),
                v -> httpInfo(tenantUser.createTenantUserWithHttpInfo(AuthParams.tenantId(v), AuthParams.createTenantUserParam(v))),
                v -> tenantUser.createTenantUserCall(AuthParams.tenantId(v), AuthParams.createTenantUserParam(v), null), User.class));
        r.register("getTenantUser", make(
                v -> tenantUser.getTenantUser(AuthParams.tenantId(v), AuthParams.userId(v)),
                v -> httpInfo(tenantUser.getTenantUserWithHttpInfo(AuthParams.tenantId(v), AuthParams.userId(v))),
                v -> tenantUser.getTenantUserCall(AuthParams.tenantId(v), AuthParams.userId(v), null), User.class));
        r.register("updateTenantUser", makeVoid(
                v -> { tenantUser.updateTenantUser(AuthParams.tenantId(v), AuthParams.userId(v), AuthParams.updateTenantUserParam(v)); return null; },
                v -> httpInfo(tenantUser.updateTenantUserWithHttpInfo(AuthParams.tenantId(v), AuthParams.userId(v), AuthParams.updateTenantUserParam(v))),
                v -> tenantUser.updateTenantUserCall(AuthParams.tenantId(v), AuthParams.userId(v), AuthParams.updateTenantUserParam(v), null)));
        r.register("deleteTenantUser", makeVoid(
                v -> { tenantUser.deleteTenantUser(AuthParams.tenantId(v), AuthParams.userId(v)); return null; },
                v -> httpInfo(tenantUser.deleteTenantUserWithHttpInfo(AuthParams.tenantId(v), AuthParams.userId(v))),
                v -> tenantUser.deleteTenantUserCall(AuthParams.tenantId(v), AuthParams.userId(v), null)));
        r.register("createTenantUserRoles", makeVoid(
                v -> { tenantUser.createTenantUserRoles(AuthParams.tenantId(v), AuthParams.userId(v), AuthParams.envId(v), AuthParams.createTenantUserRolesParam(v)); return null; },
                v -> httpInfo(tenantUser.createTenantUserRolesWithHttpInfo(AuthParams.tenantId(v), AuthParams.userId(v), AuthParams.envId(v), AuthParams.createTenantUserRolesParam(v))),
                v -> tenantUser.createTenantUserRolesCall(AuthParams.tenantId(v), AuthParams.userId(v), AuthParams.envId(v), AuthParams.createTenantUserRolesParam(v), null)));
        r.register("deleteTenantUserRole", makeVoid(
                v -> { tenantUser.deleteTenantUserRole(AuthParams.tenantId(v), AuthParams.userId(v), AuthParams.envId(v), AuthParams.roleName(v)); return null; },
                v -> httpInfo(tenantUser.deleteTenantUserRoleWithHttpInfo(AuthParams.tenantId(v), AuthParams.userId(v), AuthParams.envId(v), AuthParams.roleName(v))),
                v -> tenantUser.deleteTenantUserRoleCall(AuthParams.tenantId(v), AuthParams.userId(v), AuthParams.envId(v), AuthParams.roleName(v), null)));
    }

    // ---- InvitationApi ----------------------------------------------------------

    private void registerInvitation(MethodRegistry r) {
        r.register("getTenantInvitations", make(
                v -> invitation.getTenantInvitations(AuthParams.tenantId(v)),
                v -> httpInfo(invitation.getTenantInvitationsWithHttpInfo(AuthParams.tenantId(v))),
                v -> invitation.getTenantInvitationsCall(AuthParams.tenantId(v), null), Invitations.class));
        r.register("createTenantInvitation", make(
                v -> invitation.createTenantInvitation(AuthParams.tenantId(v), AuthParams.createTenantInvitationParam(v)),
                v -> httpInfo(invitation.createTenantInvitationWithHttpInfo(AuthParams.tenantId(v), AuthParams.createTenantInvitationParam(v))),
                v -> invitation.createTenantInvitationCall(AuthParams.tenantId(v), AuthParams.createTenantInvitationParam(v), null), Invitation.class));
        r.register("getTenantInvitation", make(
                v -> invitation.getTenantInvitation(AuthParams.tenantId(v), AuthParams.invitationId(v)),
                v -> httpInfo(invitation.getTenantInvitationWithHttpInfo(AuthParams.tenantId(v), AuthParams.invitationId(v))),
                v -> invitation.getTenantInvitationCall(AuthParams.tenantId(v), AuthParams.invitationId(v), null), Invitation.class));
        r.register("getInvitationValidity", make(
                v -> invitation.getInvitationValidity(AuthParams.invitationId(v)),
                v -> httpInfo(invitation.getInvitationValidityWithHttpInfo(AuthParams.invitationId(v))),
                v -> invitation.getInvitationValidityCall(AuthParams.invitationId(v), null), InvitationValidity.class));
        r.register("validateInvitation", makeVoid(
                v -> { invitation.validateInvitation(AuthParams.invitationId(v), AuthParams.validateInvitationParam(v)); return null; },
                v -> httpInfo(invitation.validateInvitationWithHttpInfo(AuthParams.invitationId(v), AuthParams.validateInvitationParam(v))),
                v -> invitation.validateInvitationCall(AuthParams.invitationId(v), AuthParams.validateInvitationParam(v), null)));
        r.register("deleteTenantInvitation", makeVoid(
                v -> { invitation.deleteTenantInvitation(AuthParams.tenantId(v), AuthParams.invitationId(v)); return null; },
                v -> httpInfo(invitation.deleteTenantInvitationWithHttpInfo(AuthParams.tenantId(v), AuthParams.invitationId(v))),
                v -> invitation.deleteTenantInvitationCall(AuthParams.tenantId(v), AuthParams.invitationId(v), null)));
    }

    // ---- CredentialApi ----------------------------------------------------------

    private void registerCredential(MethodRegistry r) {
        r.register("createAuthCredentials", make(
                v -> credential.createAuthCredentials(AuthParams.credentials(v)),
                v -> httpInfo(credential.createAuthCredentialsWithHttpInfo(AuthParams.credentials(v))),
                v -> credential.createAuthCredentialsCall(AuthParams.credentials(v), null), AuthorizationTempCode.class));
        r.register("getAuthCredentials", make(
                v -> credential.getAuthCredentials(AuthParams.code(v), AuthParams.authFlow(v), AuthParams.refreshToken(v)),
                v -> httpInfo(credential.getAuthCredentialsWithHttpInfo(AuthParams.code(v), AuthParams.authFlow(v), AuthParams.refreshToken(v))),
                v -> credential.getAuthCredentialsCall(AuthParams.code(v), AuthParams.authFlow(v), AuthParams.refreshToken(v), null), Credentials.class));
    }

    // ---- SingleTenantApi --------------------------------------------------------

    private void registerSingleTenant(MethodRegistry r) {
        r.register("getSingleTenantSettings", make(
                v -> singleTenant.getSingleTenantSettings(),
                v -> httpInfo(singleTenant.getSingleTenantSettingsWithHttpInfo()),
                v -> singleTenant.getSingleTenantSettingsCall(null), SingleTenantSettings.class));
        r.register("updateSingleTenantSettings", makeVoid(
                v -> { singleTenant.updateSingleTenantSettings(AuthParams.updateSingleTenantSettingsParam(v)); return null; },
                v -> httpInfo(singleTenant.updateSingleTenantSettingsWithHttpInfo(AuthParams.updateSingleTenantSettingsParam(v))),
                v -> singleTenant.updateSingleTenantSettingsCall(AuthParams.updateSingleTenantSettingsParam(v), null)));
        r.register("getCloudFormationLaunchStackLinkForSingleTenant", make(
                v -> singleTenant.getCloudFormationLaunchStackLinkForSingleTenant(),
                v -> httpInfo(singleTenant.getCloudFormationLaunchStackLinkForSingleTenantWithHttpInfo()),
                v -> singleTenant.getCloudFormationLaunchStackLinkForSingleTenantCall(null), CloudFormationLaunchStackLink.class));
    }

    // ---- style assembly ---------------------------------------------------------

    private MethodInvokers make(NormalCall normal, HttpInfoCall httpInfo,
                                ThrowingCallSupplier callFactory, Type returnType) {
        return MethodInvokers.builder()
                .normal(normal)
                .withHttpInfo(httpInfo)
                .async((vars, sink) -> asyncSigned(vars, callFactory, returnType, sink))
                .call((vars, sink) -> callSigned(vars, callFactory, returnType, sink))
                .build();
    }

    private MethodInvokers makeVoid(NormalCall normal, HttpInfoCall httpInfo, ThrowingCallSupplier callFactory) {
        return make(normal, httpInfo, callFactory, null);
    }

    private static HttpInfo httpInfo(ApiResponse<?> response) {
        return new HttpInfo(response.getData(), response.getStatusCode(), response.getHeaders());
    }

    private void asyncSigned(Map<String, Object> vars, ThrowingCallSupplier callFactory,
                             Type returnType, AsyncSink sink) throws Exception {
        okhttp3.Call unsigned = callFactory.get(vars);
        String signature = Utils.withSaasusSigV1(unsigned);
        Request signedRequest = unsigned.request().newBuilder().header("Authorization", signature).build();
        okhttp3.Call signed = client.getHttpClient().newCall(signedRequest);
        client.executeAsync(signed, returnType, new ApiCallback<Object>() {
            @Override
            public void onSuccess(Object result, int statusCode, Map<String, List<String>> headers) {
                sink.onSuccess(result, statusCode, headers);
            }

            @Override
            public void onFailure(ApiException e, int statusCode, Map<String, List<String>> headers) {
                sink.onFailure(e, statusCode, headers);
            }

            @Override
            public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
            }

            @Override
            public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
            }
        });
    }

    private void callSigned(Map<String, Object> vars, ThrowingCallSupplier callFactory,
                            Type returnType, AsyncSink sink) {
        try {
            okhttp3.Call unsigned = callFactory.get(vars);
            ApiResponse<?> response = (returnType == null)
                    ? client.execute(unsigned)
                    : client.execute(unsigned, returnType);
            sink.onSuccess(response.getData(), response.getStatusCode(), response.getHeaders());
        } catch (ApiException e) {
            sink.onFailure(e, e.getCode(), e.getResponseHeaders());
        } catch (Exception e) {
            sink.onFailure(e, 0, null);
        }
    }
}
