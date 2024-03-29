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
import saasus.sdk.auth.models.CreateTenantUserParam;
import saasus.sdk.auth.models.CreateTenantUserRolesParam;
import saasus.sdk.auth.models.Error;
import saasus.sdk.auth.models.UpdateTenantUserParam;
import saasus.sdk.auth.models.User;
import saasus.sdk.auth.models.Users;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TenantUserApi
 */
@Disabled
public class TenantUserApiTest {

    private final TenantUserApi api = new TenantUserApi();

    /**
     * テナントにユーザーを作成(Create Tenant User)
     *
     * テナントにユーザーを作成します。 attributesを空のオブジェクトにした場合、追加属性は空で作成されます。  Create a tenant user. If attributes is empty, the additional attributes will be created empty. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createTenantUserTest() throws ApiException {
        String tenantId = null;
        CreateTenantUserParam createTenantUserParam = null;
        User response = api.createTenantUser(tenantId, createTenantUserParam);
        // TODO: test validations
    }

    /**
     * テナントのユーザー情報に役割(ロール)を作成(Create Tenant User Role)
     *
     * テナントのユーザーに役割(ロール)を作成します。  Create roles on tenant users. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createTenantUserRolesTest() throws ApiException {
        String tenantId = null;
        String userId = null;
        Integer envId = null;
        CreateTenantUserRolesParam createTenantUserRolesParam = null;
        api.createTenantUserRoles(tenantId, userId, envId, createTenantUserRolesParam);
        // TODO: test validations
    }

    /**
     * テナントのユーザー情報を削除(Delete Tenant User)
     *
     * テナントからユーザーを削除します。  Delete a user from your tenant. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteTenantUserTest() throws ApiException {
        String tenantId = null;
        String userId = null;
        api.deleteTenantUser(tenantId, userId);
        // TODO: test validations
    }

    /**
     * テナントのユーザーから役割(ロール)を削除(Remove Role From Tenant User)
     *
     * テナントのユーザーから役割(ロール)を削除します。  Remove a role from a tenant user. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteTenantUserRoleTest() throws ApiException {
        String tenantId = null;
        String userId = null;
        Integer envId = null;
        String roleName = null;
        api.deleteTenantUserRole(tenantId, userId, envId, roleName);
        // TODO: test validations
    }

    /**
     * ユーザー情報を取得(Get User Info)
     *
     * ユーザーIDからテナントに所属しているユーザー情報を取得します。 複数テナントに所属している場合は別のオブジェクトとして返却されます。  Get information on user belonging to the tenant from the user ID. If the user belongs to multiple tenants, it will be returned as another object. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAllTenantUserTest() throws ApiException {
        String userId = null;
        Users response = api.getAllTenantUser(userId);
        // TODO: test validations
    }

    /**
     * ユーザー一覧を取得(Get Users)
     *
     * テナントに所属しているユーザー全件を取得します。 複数テナントに所属する同一ユーザーは別のオブジェクトとして返却されます。 idは一意ではありません。  Get all users belonging to the tenant. The same user belonging to multiple tenants will be returned as a different object. Id is not unique. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAllTenantUsersTest() throws ApiException {
        Users response = api.getAllTenantUsers();
        // TODO: test validations
    }

    /**
     * テナントのユーザー情報を取得(Get Tenant User)
     *
     * テナントのユーザーをIDから一件取得します。  Get one tenant user by specific ID. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTenantUserTest() throws ApiException {
        String tenantId = null;
        String userId = null;
        User response = api.getTenantUser(tenantId, userId);
        // TODO: test validations
    }

    /**
     * テナントのユーザー一覧を取得(Get Tenant Users)
     *
     * テナントに所属するユーザーを全件取得します。 idは一意です。  Get all the users belonging to the tenant. Id is unique. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getTenantUsersTest() throws ApiException {
        String tenantId = null;
        Users response = api.getTenantUsers(tenantId);
        // TODO: test validations
    }

    /**
     * テナントのユーザー属性情報を更新(Update Tenant User Attribute)
     *
     * テナントのユーザー属性情報を更新します。  Update tenant user attributes. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateTenantUserTest() throws ApiException {
        String tenantId = null;
        String userId = null;
        UpdateTenantUserParam updateTenantUserParam = null;
        api.updateTenantUser(tenantId, userId, updateTenantUserParam);
        // TODO: test validations
    }

}
