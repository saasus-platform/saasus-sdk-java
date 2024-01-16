/*
 * SaaSus Auth API Schema
 * スキーマ
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
import saasus.sdk.auth.models.AuthInfo;
import saasus.sdk.auth.models.Error;
import saasus.sdk.auth.models.IdentityProviders;
import saasus.sdk.auth.models.SignInSettings;
import saasus.sdk.auth.models.UpdateIdentityProviderParam;
import saasus.sdk.auth.models.UpdateSignInSettingsParam;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AuthInfoApi
 */
@Disabled
public class AuthInfoApiTest {

    private final AuthInfoApi api = new AuthInfoApi();

    /**
     * 認証情報を取得(Get Authentication Info)
     *
     * ログイン後に認証情報を渡す SaaS の URL を取得します。 ここで取得した URL へ認証情報を渡し、SaaSus SDK を利用してこの Callback の実装をすることが可能となります。  Get the post-login SaaS URL that contains authentication information. You can pass authentication information to the URL obtained here and implement this Callback using the SaaSus SDK. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAuthInfoTest() throws ApiException {
        AuthInfo response = api.getAuthInfo();
        // TODO: test validations
    }

    /**
     * cognitoに設定している外部プロバイダ経由のサインイン情報取得  Get sign-in information via external provider set in cognito 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getIdentityProvidersTest() throws ApiException {
        IdentityProviders response = api.getIdentityProviders();
        // TODO: test validations
    }

    /**
     * パスワード要件を取得(Get Password Requirements)
     *
     * ユーザーパスワードの要件設定を取得します。 アルファベット、数字、記号の組み合わせで、桁数を長くすれば解読されづらい安全なパスワードを設定することが可能となります。  Get user password requirements. Set a secure password that is difficult to decipher by increasing the number of digits by combining alphabets, numbers, and symbols. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getSignInSettingsTest() throws ApiException {
        SignInSettings response = api.getSignInSettings();
        // TODO: test validations
    }

    /**
     * 認証情報を更新(Update Authentication Info)
     *
     * ログイン後に認証情報を渡す SaaS の URL を登録します。 ここで登録した URL に認証情報を渡し、SaaSus SDK を利用してこの Callback の実装をすることが可能となります。  Register post-login SaaS URL for authentication information. It is possible to pass authentication information to the URL registered here and implement this Callback using the SaaSus SDK. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateAuthInfoTest() throws ApiException {
        AuthInfo body = null;
        api.updateAuthInfo(body);
        // TODO: test validations
    }

    /**
     * 外部IDプロバイダのサインイン情報更新
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateIdentityProviderTest() throws ApiException {
        UpdateIdentityProviderParam updateIdentityProviderParam = null;
        api.updateIdentityProvider(updateIdentityProviderParam);
        // TODO: test validations
    }

    /**
     * パスワード要件を更新(Update Password Requirements)
     *
     * ユーザーパスワードの要件設定を更新します。 アルファベット、数字、記号の組み合わせで、桁数を長くすれば解読されづらい安全なパスワードを設定することが可能となります。  Update user password requirements. Set a secure password that is difficult to decipher by increasing the number of digits by combining alphabets, numbers, and symbols. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateSignInSettingsTest() throws ApiException {
        UpdateSignInSettingsParam updateSignInSettingsParam = null;
        api.updateSignInSettings(updateSignInSettingsParam);
        // TODO: test validations
    }

}
