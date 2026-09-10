package saasus.sdk.testlib.snapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Compares a current {@link StorySnapshot} against a baseline and classifies each difference as
 * {@link CompatibilityLevel#BREAKING} or {@link CompatibilityLevel#WARNING}.
 *
 * <p>Rules mirror the Go implementation:
 * <ul>
 *   <li>story name / status change, step method change, status-code change, return-value type
 *       change and step success change are <b>breaking</b>;</li>
 *   <li>step count change, added/removed steps, and changes to {@code json_data}/{@code body}/
 *       non-dynamic headers are <b>warnings</b>.</li>
 * </ul>
 * Dynamic headers ({@code Date}, {@code X-Saasus-Trace-Id}, ...) are ignored, and JSON payloads
 * are normalized before comparison so ordering differences do not register.
 */
public class SnapshotComparator {

    // Stored lower-cased so lookups are case-insensitive: OkHttp (HTTP/2) reports header names
    // in lower case (e.g. "date", "x-saasus-trace-id"), so a case-sensitive match would fail to
    // treat them as dynamic and flag a spurious headers_changed diff on every comparison.
    private static final Set<String> DYNAMIC_HEADERS = new HashSet<String>(Arrays.asList(
            "date", "x-saasus-trace-id", "x-request-id", "x-correlation-id", "server", "x-runtime"));

    public ComparisonResult compare(StorySnapshot current, StorySnapshot baseline) {
        List<CompatibilityIssue> issues = new ArrayList<CompatibilityIssue>();

        if (!equalStrings(current.storyName, baseline.storyName)) {
            issues.add(new CompatibilityIssue("story_name_mismatch", "story",
                    "Story name changed: " + baseline.storyName + " -> " + current.storyName,
                    CompatibilityLevel.BREAKING));
        }
        if (!equalStrings(current.status, baseline.status)) {
            issues.add(new CompatibilityIssue("story_status_mismatch", "story",
                    "Story status changed: " + baseline.status + " -> " + current.status,
                    CompatibilityLevel.BREAKING));
        }

        List<StepSnapshot> curSteps = current.steps == null
                ? java.util.Collections.<StepSnapshot>emptyList() : current.steps;
        List<StepSnapshot> baseSteps = baseline.steps == null
                ? java.util.Collections.<StepSnapshot>emptyList() : baseline.steps;

        if (curSteps.size() != baseSteps.size()) {
            issues.add(new CompatibilityIssue("step_count_mismatch", "steps",
                    "Step count changed: " + baseSteps.size() + " -> " + curSteps.size(),
                    CompatibilityLevel.WARNING));
        }

        boolean[] consumed = new boolean[baseSteps.size()];
        int addedCount = 0;
        for (StepSnapshot cur : curSteps) {
            StepSnapshot base = null;
            for (int j = 0; j < baseSteps.size(); j++) {
                if (!consumed[j] && equalStrings(cur.stepName, baseSteps.get(j).stepName)) {
                    base = baseSteps.get(j);
                    consumed[j] = true;
                    break;
                }
            }
            if (base == null) {
                addedCount++;
                issues.add(new CompatibilityIssue("step_added", "Step '" + cur.stepName + "'",
                        "Step added or renamed: '" + cur.stepName + "' (" + cur.method + ")",
                        CompatibilityLevel.WARNING));
                continue;
            }
            String stepPath = "Step '" + cur.stepName + "' (" + base.method + ")";
            if (!equalStrings(cur.method, base.method)) {
                issues.add(new CompatibilityIssue("method_name_mismatch", stepPath,
                        stepPath + ": method changed: " + base.method + " -> " + cur.method,
                        CompatibilityLevel.BREAKING));
            }
            if (cur.statusCode != base.statusCode) {
                issues.add(new CompatibilityIssue("status_code_mismatch", stepPath,
                        stepPath + ": status code changed: " + base.statusCode + " -> " + cur.statusCode,
                        CompatibilityLevel.BREAKING));
            }
            if (cur.success != base.success) {
                issues.add(new CompatibilityIssue("step_success_mismatch", stepPath,
                        stepPath + ": execution success changed: " + base.success + " -> " + cur.success,
                        CompatibilityLevel.BREAKING));
            }
            compareReturnValue(cur.returnValue, base.returnValue, stepPath, issues);
        }

        int removedCount = 0;
        for (int j = 0; j < baseSteps.size(); j++) {
            if (!consumed[j]) {
                removedCount++;
                StepSnapshot removed = baseSteps.get(j);
                issues.add(new CompatibilityIssue("step_removed", "Step '" + removed.stepName + "'",
                        "Step removed or renamed: '" + removed.stepName + "' (" + removed.method + ")",
                        CompatibilityLevel.WARNING));
            }
        }
        if (addedCount > 0 && removedCount > 0) {
            issues.add(new CompatibilityIssue("step_replaced", "steps",
                    "One or more steps were replaced (removed and added), changing verified behavior",
                    CompatibilityLevel.BREAKING));
        }

        CompatibilityLevel level = determineLevel(issues);
        return new ComparisonResult(level, issues, summarize(issues, level));
    }

    private void compareReturnValue(SdkReturnValue cur, SdkReturnValue base, String stepPath,
                                    List<CompatibilityIssue> issues) {
        if (cur == null && base == null) {
            return;
        }
        if (base == null) {
            issues.add(new CompatibilityIssue("return_value_added", stepPath + ".return_value",
                    stepPath + ": return value added", CompatibilityLevel.WARNING));
            return;
        }
        if (cur == null) {
            issues.add(new CompatibilityIssue("return_value_removed", stepPath + ".return_value",
                    stepPath + ": return value removed", CompatibilityLevel.BREAKING));
            return;
        }
        if (cur.statusCode != base.statusCode) {
            issues.add(new CompatibilityIssue("status_code_mismatch", stepPath + ".return_value",
                    stepPath + ": return value status code changed: " + base.statusCode + " -> " + cur.statusCode,
                    CompatibilityLevel.BREAKING));
        }
        if (!equalStrings(cur.type, base.type)) {
            issues.add(new CompatibilityIssue("type_mismatch", stepPath + ".return_value",
                    stepPath + ": return type changed: " + base.type + " -> " + cur.type,
                    CompatibilityLevel.BREAKING));
        }
        if (!equalNormalized(cur.jsonData, base.jsonData)) {
            issues.add(new CompatibilityIssue("json_data_changed", stepPath + ".return_value.json_data",
                    stepPath + ": JSON response data changed", CompatibilityLevel.WARNING));
        }
        if (!equalNormalizedBody(cur.body, base.body)) {
            issues.add(new CompatibilityIssue("body_changed", stepPath + ".return_value.body",
                    stepPath + ": response body changed", CompatibilityLevel.WARNING));
        }
        if (!equalHeaders(cur.headers, base.headers)) {
            issues.add(new CompatibilityIssue("headers_changed", stepPath + ".return_value.headers",
                    stepPath + ": response headers changed", CompatibilityLevel.WARNING));
        }
    }

    private static boolean equalNormalized(Object a, Object b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return SnapshotJson.PLAIN.toJson(SnapshotJson.deepSort(a))
                .equals(SnapshotJson.PLAIN.toJson(SnapshotJson.deepSort(b)));
    }

    private static boolean equalNormalizedBody(String a, String b) {
        return normalizeBody(a).equals(normalizeBody(b));
    }

    private static String normalizeBody(String body) {
        if (body == null || body.isEmpty()) {
            return "";
        }
        Object parsed = SnapshotJson.parse(body);
        if (parsed == null) {
            return body;
        }
        return SnapshotJson.PLAIN.toJson(SnapshotJson.deepSort(parsed));
    }

    private static boolean equalHeaders(Map<String, String> cur, Map<String, String> base) {
        return filterDynamic(cur).equals(filterDynamic(base));
    }

    private static Map<String, String> filterDynamic(Map<String, String> headers) {
        Map<String, String> out = new LinkedHashMap<String, String>();
        if (headers != null) {
            for (Map.Entry<String, String> e : headers.entrySet()) {
                String key = e.getKey();
                if (key == null || !DYNAMIC_HEADERS.contains(key.toLowerCase(java.util.Locale.ROOT))) {
                    out.put(e.getKey(), e.getValue());
                }
            }
        }
        return out;
    }

    private CompatibilityLevel determineLevel(List<CompatibilityIssue> issues) {
        boolean warning = false;
        for (CompatibilityIssue issue : issues) {
            if (issue.impact == CompatibilityLevel.BREAKING) {
                return CompatibilityLevel.BREAKING;
            }
            if (issue.impact == CompatibilityLevel.WARNING) {
                warning = true;
            }
        }
        return warning ? CompatibilityLevel.WARNING : CompatibilityLevel.COMPATIBLE;
    }

    private String summarize(List<CompatibilityIssue> issues, CompatibilityLevel level) {
        if (level == CompatibilityLevel.COMPATIBLE) {
            return "All checks passed. Snapshots are compatible.";
        }
        int breaking = 0;
        int warning = 0;
        for (CompatibilityIssue issue : issues) {
            if (issue.impact == CompatibilityLevel.BREAKING) {
                breaking++;
            } else if (issue.impact == CompatibilityLevel.WARNING) {
                warning++;
            }
        }
        return "Found " + breaking + " breaking issue(s) and " + warning + " warning(s).";
    }

    private static boolean equalStrings(String a, String b) {
        return a == null ? b == null : a.equals(b);
    }
}
