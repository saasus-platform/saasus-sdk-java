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
import saasus.sdk.auth.models.Error;
import saasus.sdk.auth.models.Role;
import saasus.sdk.auth.models.Roles;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RoleApi
 */
@Disabled
public class RoleApiTest {

    private final RoleApi api = new RoleApi();

    /**
     * Create Role
     *
     * Create a role. By granting users the roles created here, it becomes easier to implement role-based authorization on the SaaS side. In addition, even the same user can have different roles for each tenant/environment to which they belong. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createRoleTest() throws ApiException {
        Role body = null;
        Role response = api.createRole(body);
        // TODO: test validations
    }

    /**
     * Delete Role
     *
     * Delete role. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteRoleTest() throws ApiException {
        String roleName = null;
        api.deleteRole(roleName);
        // TODO: test validations
    }

    /**
     * Get Roles
     *
     * Get registered roles list. Granting users the roles defined here makes it easy to implement role-based authorization on the SaaS side. In addition, even the same user can have different roles for each tenant/environment to which they belong. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getRolesTest() throws ApiException {
        Roles response = api.getRoles();
        // TODO: test validations
    }

}
