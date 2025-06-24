package saasus.sdk.util.apiserver;

import java.util.Objects;

/**
 * SaaSus APIから取得したテナント・環境・ユーザー情報を統一的に管理するIDオブジェクト
 */
public final class SaaSusIdentity {
    private final String userId;
    private final String tenantId;
    private final String envId;
    
    public SaaSusIdentity(String userId, String tenantId, String envId) {
        // セキュリティ: 入力値検証
        this.userId = userId;
        this.tenantId = validateAndNormalize(tenantId, "tenantId");
        this.envId = validateAndNormalize(envId, "envId");
    }
    
    private String validateAndNormalize(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        return value.trim();
    }
    
    public String getUserId() { return userId; }
    public String getTenantId() { return tenantId; }
    public String getEnvId() { return envId; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaaSusIdentity that = (SaaSusIdentity) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(tenantId, that.tenantId) &&
               Objects.equals(envId, that.envId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(userId, tenantId, envId);
    }
    
    @Override
    public String toString() {
        return "SaaSusIdentity{" +
               "userId='" + userId + '\'' +
               ", tenantId='" + tenantId + '\'' +
               ", envId='" + envId + '\'' +
               '}';
    }
}