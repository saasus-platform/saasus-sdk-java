package saasus.sdk.testlib.snapshot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import saasus.sdk.testlib.CallStyle;
import saasus.sdk.testlib.LogLevel;
import saasus.sdk.testlib.Logger;
import saasus.sdk.testlib.SnapshotConfig;
import saasus.sdk.testlib.StepResult;
import saasus.sdk.testlib.Story;
import saasus.sdk.testlib.StoryResult;
import saasus.sdk.testlib.TestStatus;

class SnapshotEngineTest {

    private StoryResult storyResultWithResponse(String storyName, Object response) {
        StepResult step = new StepResult("step1", "getX", CallStyle.NORMAL, TestStatus.PASSED,
                5, 200, null, response, null, null);
        List<StepResult> steps = new ArrayList<StepResult>();
        steps.add(step);
        return new StoryResult(storyName, TestStatus.PASSED, 10, steps, null, null);
    }

    private StoryResult storyResultWithStatus(String storyName, int statusCode) {
        StepResult step = new StepResult("step1", "getX", CallStyle.NORMAL, TestStatus.PASSED,
                5, statusCode, null, new LinkedHashMap<String, Object>(), null, null);
        List<StepResult> steps = new ArrayList<StepResult>();
        steps.add(step);
        return new StoryResult(storyName, TestStatus.PASSED, 10, steps, null, null);
    }

    private SnapshotEngine engine(File dir) {
        SnapshotConfig config = new SnapshotConfig();
        config.enableCapture = true;
        config.outputDirectory = dir.getAbsolutePath();
        return new SnapshotEngine(config, new Logger(LogLevel.ERROR));
    }

    @Test
    @SuppressWarnings("unchecked")
    void captureMasksSecretsAndPreservesDynamicValues(@TempDir File dir) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("api_key", "supersecretlongapikeyvalue");
        response.put("id", "dyn-123");
        response.put("name", "stable");

        StorySnapshot snapshot = engine(dir)
                .capture(storyResultWithResponse("story", response), "desc");

        StepSnapshot step = snapshot.steps.get(0);
        assertNotNull(step.returnValue);
        Map<String, Object> jsonData = step.returnValue.jsonData;
        assertEquals("[MASKED len=" + "supersecretlongapikeyvalue".length() + "]", jsonData.get("api_key"));
        assertEquals("dyn-123", jsonData.get("id")); // dynamic values preserved
        assertEquals("stable", jsonData.get("name"));
    }

    @Test
    void captureProducesGoStructure(@TempDir File dir) {
        StorySnapshot snapshot = engine(dir).capture(storyResultWithStatus("story", 200), "desc");
        assertEquals("story", snapshot.storyName);
        assertEquals("passed", snapshot.status);
        assertEquals(10_000_000L, snapshot.duration); // 10ms -> nanoseconds
        assertEquals(1, snapshot.summary.totalSteps);
        assertEquals(1, snapshot.summary.successfulSteps);
        assertEquals("FULL", snapshot.metadata.captureLevel);
        assertNotNull(snapshot.steps.get(0).timestamp);
        assertEquals(5_000_000L, snapshot.steps.get(0).duration);
        assertEquals("passed", snapshot.steps.get(0).status);
    }

    @Test
    void onStoryFinishedSavesSnapshotAndValidation(@TempDir File dir) {
        SnapshotEngine engine = engine(dir);
        Story story = Story.builder("snapshot-story").description("d").build();

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("name", "foo");
        engine.onStoryFinished(story, storyResultWithResponse("snapshot-story", response));

        String tag = engine.fileManager().gitTag();
        assertTrue(engine.fileManager().snapshotPath(tag, "snapshot-story").isFile());
        assertTrue(engine.fileManager().validationPath(tag, "snapshot-story").isFile());
    }

    @Test
    void captureLevelIsRecordedInMetadataButNeverDropsReturnValue(@TempDir File dir) {
        SnapshotConfig config = new SnapshotConfig();
        config.enableCapture = true;
        config.captureLevel = "MINIMAL";
        config.outputDirectory = dir.getAbsolutePath();
        SnapshotEngine engine = new SnapshotEngine(config, new Logger(LogLevel.ERROR));

        StorySnapshot snapshot = engine.capture(storyResultWithStatus("s", 200), "d");
        // Go records the capture level in metadata but always keeps the return value; the level
        // never gates the captured payload.
        assertEquals("MINIMAL", snapshot.metadata.captureLevel);
        StepSnapshot step = snapshot.steps.get(0);
        assertNotNull(step.returnValue);
        assertEquals("getX", step.method);
        assertEquals(200, step.statusCode);
    }

    @Test
    void breakingChangeAcrossTagsWithFailOnBreakingRequestsFailure(@TempDir File dir) throws Exception {
        SnapshotConfig config = new SnapshotConfig();
        config.enableComparison = true;
        config.enableCapture = true;
        config.failOnBreaking = true;
        config.outputDirectory = dir.getAbsolutePath();
        SnapshotEngine engine = new SnapshotEngine(config, new Logger(LogLevel.ERROR));

        // Baseline captured under an earlier tag with status 200.
        engine.fileManager().gitTag("old");
        engine.fileManager().saveSnapshot(engine.capture(storyResultWithStatus("s", 200), "d"));

        // Current run under a new tag returns 500 -> breaking status-code change.
        engine.fileManager().gitTag("new");
        Story story = Story.builder("s").description("d").build();
        assertTrue(engine.onStoryFinished(story, storyResultWithStatus("s", 500)));
    }

    @Test
    void compatibleChangeAcrossTagsDoesNotRequestFailure(@TempDir File dir) throws Exception {
        SnapshotConfig config = new SnapshotConfig();
        config.enableComparison = true;
        config.enableCapture = true;
        config.failOnBreaking = true;
        config.outputDirectory = dir.getAbsolutePath();
        SnapshotEngine engine = new SnapshotEngine(config, new Logger(LogLevel.ERROR));

        engine.fileManager().gitTag("old");
        engine.fileManager().saveSnapshot(engine.capture(storyResultWithStatus("s", 200), "d"));

        engine.fileManager().gitTag("new");
        Story story = Story.builder("s").description("d").build();
        assertFalse(engine.onStoryFinished(story, storyResultWithStatus("s", 200)));
    }

    @Test
    void missingBaselineWithFallbackDisabledRequestsFailure(@TempDir File dir) {
        SnapshotConfig config = new SnapshotConfig();
        config.enableComparison = true;
        config.captureFallback = false;
        config.enableCapture = false;
        config.outputDirectory = dir.getAbsolutePath();
        SnapshotEngine engine = new SnapshotEngine(config, new Logger(LogLevel.ERROR));

        Story story = Story.builder("s").description("d").build();
        assertTrue(engine.onStoryFinished(story, storyResultWithStatus("s", 200)));
    }

    @Test
    void captureMasksSecretsInErrorMessage(@TempDir File dir) {
        StepResult step = new StepResult("step1", "getX", CallStyle.NORMAL, TestStatus.FAILED,
                5, 500, null, null,
                new RuntimeException("response body: {\"api_key\":\"supersecretlongapikeyvalue\"}"), null);
        List<StepResult> steps = new ArrayList<StepResult>();
        steps.add(step);
        StoryResult result = new StoryResult("s", TestStatus.FAILED, 10, steps, null, null);

        StorySnapshot snapshot = engine(dir).capture(result, "d");
        SdkMethodError error = snapshot.steps.get(0).error;
        assertNotNull(error);
        assertFalse(error.message.contains("supersecretlongapikeyvalue"));
    }
}
