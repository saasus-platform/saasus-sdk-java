package saasus.sdk.e2e.apilog;

import saasus.sdk.apilog.models.ApiLog;
import saasus.sdk.apilog.models.ApiLogs;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

/**
 * Parameter builders and response extraction for apilog E2E stories.
 *
 * <p>Mirrors the Go reference helpers: the plain {@code getLogs} steps send no query parameters,
 * while the "With QueryParameters" step (flagged via the {@code query_mode=with} step input)
 * reuses {@code created_date} / {@code created_at} / {@code cursor} captured from the first
 * response. Range-search ({@code start_at}/{@code end_at}) is intentionally excluded because the
 * Java SDK does not expose those parameters.
 */
final class ApiLogParams {

    static final String QUERY_MODE_KEY = "query_mode";
    static final String QUERY_MODE_WITH = "with";

    private ApiLogParams() {
    }

    private static boolean withParams(Map<String, Object> vars) {
        return QUERY_MODE_WITH.equals(vars.get(QUERY_MODE_KEY));
    }

    /** {@code created_date} query param (only in with-params mode). */
    static LocalDate createdDate(Map<String, Object> vars) {
        if (!withParams(vars)) {
            return null;
        }
        Object value = vars.get("created_date");
        return value == null ? null : LocalDate.parse(value.toString());
    }

    /** {@code created_at} query param (only in with-params mode). */
    static OffsetDateTime createdAt(Map<String, Object> vars) {
        if (!withParams(vars)) {
            return null;
        }
        Object value = vars.get("created_at_odt");
        return (value instanceof OffsetDateTime) ? (OffsetDateTime) value : null;
    }

    /** {@code cursor} query param (only in with-params mode). */
    static String cursor(Map<String, Object> vars) {
        if (!withParams(vars)) {
            return null;
        }
        Object value = vars.get("cursor");
        return value == null ? null : value.toString();
    }

    /** {@code limit} query param, if a step provided one. */
    static Long limit(Map<String, Object> vars) {
        Object value = vars.get("limit");
        if (value instanceof Long) {
            return (Long) value;
        }
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        return null;
    }

    /** Resolves the {@code api_log_id} captured from a prior {@code getLogs} response. */
    static String apiLogId(Map<String, Object> vars) {
        Object value = vars.get("api_log_id");
        if (value == null || value.toString().isEmpty()) {
            throw new IllegalStateException(
                    "no api_log_id captured from getLogs; cannot call getLog (tenant may have no API logs)");
        }
        return value.toString();
    }

    /** Extracts pagination/first-entry metadata from a {@code getLogs} response into story variables. */
    static void extractFromLogs(Object response, Map<String, Object> vars) {
        if (!(response instanceof ApiLogs)) {
            return;
        }
        ApiLogs logs = (ApiLogs) response;
        if (logs.getCursor() != null) {
            vars.put("cursor", logs.getCursor());
        }
        List<ApiLog> entries = logs.getApiLogs();
        if (entries != null && !entries.isEmpty()) {
            ApiLog first = entries.get(0);
            vars.put("api_log_id", first.getApiLogId());
            vars.put("created_date", first.getCreatedDate());
            Integer ts = first.getCreatedAt();
            if (ts != null) {
                vars.put("created_at_ts", ts);
                vars.put("created_at_odt",
                        OffsetDateTime.ofInstant(Instant.ofEpochSecond(ts.longValue()), ZoneOffset.UTC));
            }
        }
    }
}
