package saasus.sdk.testlib.snapshot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SnapshotComparatorTest {

    private final SnapshotComparator comparator = new SnapshotComparator();

    private Map<String, Object> map(Object... kv) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        for (int i = 0; i + 1 < kv.length; i += 2) {
            m.put((String) kv[i], kv[i + 1]);
        }
        return m;
    }

    private StepSnapshot step(String stepName, String method, int status, Map<String, Object> jsonData) {
        StepSnapshot st = new StepSnapshot();
        st.stepName = stepName;
        st.method = method;
        st.statusCode = status;
        st.success = status >= 200 && status < 400;
        st.status = st.success ? "passed" : "failed";
        SdkReturnValue rv = new SdkReturnValue();
        rv.type = "java.util.LinkedHashMap";
        rv.statusCode = status;
        rv.jsonData = jsonData;
        st.returnValue = rv;
        return st;
    }

    private StorySnapshot story(StepSnapshot... steps) {
        StorySnapshot s = new StorySnapshot();
        s.storyName = "story";
        s.status = "passed";
        for (StepSnapshot st : steps) {
            s.steps.add(st);
        }
        return s;
    }

    @Test
    void identicalSnapshotsAreCompatible() {
        StorySnapshot a = story(step("s", "getX", 200, map("name", "foo")));
        StorySnapshot b = story(step("s", "getX", 200, map("name", "foo")));
        ComparisonResult result = comparator.compare(a, b);
        assertTrue(result.compatible);
        assertEquals(CompatibilityLevel.COMPATIBLE, result.level);
    }

    @Test
    void jsonDataChangeIsWarning() {
        StorySnapshot current = story(step("s", "getX", 200, map("name", "foo", "extra", "new")));
        StorySnapshot baseline = story(step("s", "getX", 200, map("name", "foo")));
        ComparisonResult result = comparator.compare(current, baseline);
        assertEquals(CompatibilityLevel.WARNING, result.level);
        assertFalse(result.compatible);
    }

    @Test
    void stepStatusCodeChangeIsBreaking() {
        StorySnapshot current = story(step("s", "getX", 500, map("name", "foo")));
        StorySnapshot baseline = story(step("s", "getX", 200, map("name", "foo")));
        ComparisonResult result = comparator.compare(current, baseline);
        assertEquals(CompatibilityLevel.BREAKING, result.level);
    }

    @Test
    void methodChangeIsBreaking() {
        StorySnapshot current = story(step("s", "getY", 200, map("name", "foo")));
        StorySnapshot baseline = story(step("s", "getX", 200, map("name", "foo")));
        assertTrue(comparator.compare(current, baseline).hasBreaking());
    }

    @Test
    void returnValueTypeChangeIsBreaking() {
        StepSnapshot cur = step("s", "getX", 200, map("name", "foo"));
        cur.returnValue.type = "java.lang.String";
        StepSnapshot base = step("s", "getX", 200, map("name", "foo"));
        assertTrue(comparator.compare(story(cur), story(base)).hasBreaking());
    }

    @Test
    void storyStatusRegressionIsBreaking() {
        StorySnapshot baseline = story(step("s", "getX", 200, map("name", "foo")));
        StorySnapshot current = story(step("s", "getX", 200, map("name", "foo")));
        current.status = "failed";
        assertTrue(comparator.compare(current, baseline).hasBreaking());
    }

    @Test
    void stepSuccessRegressionIsBreaking() {
        StepSnapshot base = step("s", "getX", 200, map("name", "foo"));
        StepSnapshot cur = step("s", "getX", 200, map("name", "foo"));
        cur.success = false;
        assertTrue(comparator.compare(story(cur), story(base)).hasBreaking());
    }

    @Test
    void stepCountChangeIsWarning() {
        StorySnapshot current = story(step("s", "getX", 200, map("name", "foo")));
        StorySnapshot baseline = story(
                step("s", "getX", 200, map("name", "foo")),
                step("s2", "getExtra", 200, map()));
        assertEquals(CompatibilityLevel.WARNING, comparator.compare(current, baseline).level);
    }

    @Test
    void insertedStepDoesNotCauseSpuriousBreakingChange() {
        StorySnapshot baseline = story(
                step("a", "getA", 200, map("name", "foo")),
                step("b", "getB", 200, map("name", "bar")));
        StorySnapshot current = story(
                step("a", "getA", 200, map("name", "foo")),
                step("x", "getX", 200, map("name", "baz")),
                step("b", "getB", 200, map("name", "bar")));
        ComparisonResult result = comparator.compare(current, baseline);
        assertFalse(result.hasBreaking());
        assertEquals(CompatibilityLevel.WARNING, result.level);
    }

    @Test
    void reorderedStepsAreNotBreaking() {
        StorySnapshot baseline = story(
                step("a", "getA", 200, map("name", "foo")),
                step("b", "getB", 200, map("name", "bar")));
        StorySnapshot current = story(
                step("b", "getB", 200, map("name", "bar")),
                step("a", "getA", 200, map("name", "foo")));
        assertFalse(comparator.compare(current, baseline).hasBreaking());
    }

    @Test
    void replacedStepWithSameCountIsBreaking() {
        StorySnapshot baseline = story(step("a", "getA", 200, map("name", "foo")));
        StorySnapshot current = story(step("b", "getB", 500, map("other", 1.0)));
        assertTrue(comparator.compare(current, baseline).hasBreaking());
    }

    @Test
    void dynamicHeaderChangeIsIgnored() {
        StepSnapshot base = step("s", "getX", 200, map("name", "foo"));
        base.returnValue.headers.put("X-Saasus-Trace-Id", "old-trace");
        StepSnapshot cur = step("s", "getX", 200, map("name", "foo"));
        cur.returnValue.headers.put("X-Saasus-Trace-Id", "new-trace");
        assertTrue(comparator.compare(story(cur), story(base)).compatible);
    }

    @Test
    void lowercaseDynamicHeaderChangeIsIgnored() {
        // OkHttp over HTTP/2 reports header names in lower case.
        StepSnapshot base = step("s", "getX", 200, map("name", "foo"));
        base.returnValue.headers.put("x-saasus-trace-id", "old-trace");
        StepSnapshot cur = step("s", "getX", 200, map("name", "foo"));
        cur.returnValue.headers.put("x-saasus-trace-id", "new-trace");
        assertTrue(comparator.compare(story(cur), story(base)).compatible);
    }
}
