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
        this.userId = validateAndNormalizeUserId(userId);
        this.tenantId = validateAndNormalize(tenantId, "tenantId");
        this.envId = validateAndNormalize(envId, "envId");
    }
    
    /**
     * userIdの検証と正規化を行う
     * nullの場合は空文字列を返し、そうでなければトリム処理を行う
     * @param userId 検証対象のuserId
     * @return 正規化されたuserId
     */
    private String validateAndNormalizeUserId(String userId) {
        if (userId == null) {
            return ""; // 既存の動作を維持：nullの場合は空文字列
        }
        return userId.trim(); // 前後の空白文字を除去
    }
    
    /**
     * tenantIdとenvIdの検証と正規化を行う
     * @param value 検証対象の値
     * @param fieldName フィールド名（エラーメッセージ用）
     * @return 正規化された値
     * @throws IllegalArgumentException 値がnullまたは空文字列の場合
     */
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