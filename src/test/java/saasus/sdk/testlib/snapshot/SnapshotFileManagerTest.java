package saasus.sdk.testlib.snapshot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class SnapshotFileManagerTest {

    private StorySnapshot snapshot(String storyName, String status) {
        StorySnapshot s = new StorySnapshot();
        s.storyName = storyName;
        s.status = status;
        StepSnapshot step = new StepSnapshot();
        step.stepName = "step1";
        step.method = "getX";
        step.statusCode = 200;
        step.success = true;
        step.status = "passed";
        s.steps.add(step);
        return s;
    }

    @Test
    void saveAndLoadSnapshotUsesTagBasedLayout(@TempDir File dir) throws IOException {
        SnapshotFileManager manager = new SnapshotFileManager(dir).gitTag("t1");
        File file = manager.saveSnapshot(snapshot("My Story", "passed"));

        assertTrue(file.isFile());
        assertEquals("story_snapshot_t1_my_story.json", file.getName());
        assertTrue(file.getParentFile().getPath().replace('\\', '/').endsWith("story_snapshots/tags"));

        StorySnapshot loaded = manager.loadSnapshot(file);
        assertEquals("My Story", loaded.storyName);
        assertEquals(1, loaded.steps.size());
        assertEquals("getX", loaded.steps.get(0).method);
        assertEquals(200, loaded.steps.get(0).statusCode);
    }

    @Test
    void sanitizeStoryNameMatchesGoRules() {
        assertEquals("get_stripe_info", SnapshotFileManager.sanitizeStoryName("Get Stripe Info"));
        assertEquals("a_b_c", SnapshotFileManager.sanitizeStoryName("a-b.c"));
        assertEquals("x_y", SnapshotFileManager.sanitizeStoryName("  x   y  "));
    }

    @Test
    void hierarchicalGitTagIsSanitizedIntoFlatFileName(@TempDir File dir) throws IOException {
        SnapshotFileManager manager = new SnapshotFileManager(dir).gitTag("release/v1.0");
        File file = manager.saveSnapshot(snapshot("s", "passed"));

        assertTrue(file.isFile());
        assertEquals("story_snapshot_release_v1.0_s.json", file.getName());
        assertTrue(file.getParentFile().getPath().replace('\\', '/').endsWith("story_snapshots/tags"));
        // The current run's own snapshot must not be picked up as a previous baseline.
        assertEquals(null, manager.loadPreviousSnapshot("release/v1.0", "s"));
    }

    @Test
    void loadPreviousSnapshotReturnsEarlierTag(@TempDir File dir) throws IOException {
        SnapshotFileManager manager = new SnapshotFileManager(dir);
        manager.gitTag("v1");
        manager.saveSnapshot(snapshot("s", "passed"));
        manager.gitTag("v2");
        manager.saveSnapshot(snapshot("s", "passed"));

        StorySnapshot previous = manager.loadPreviousSnapshot("v2", "s");
        assertNotNull(previous);
        assertEquals("s", previous.storyName);
    }

    @Test
    void loadPreviousSnapshotIsNullWhenOnlyCurrentTagExists(@TempDir File dir) throws IOException {
        SnapshotFileManager manager = new SnapshotFileManager(dir).gitTag("only");
        manager.saveSnapshot(snapshot("s", "passed"));
        assertEquals(null, manager.loadPreviousSnapshot("only", "s"));
    }

    @Test
    void saveValidationRetainsLatestTwoAndAddsComparison(@TempDir File dir) throws Exception {
        SnapshotFileManager manager = new SnapshotFileManager(dir);

        StoryValidation v1 = validation("s");
        manager.gitTag("v1");
        manager.saveValidation(v1);

        Thread.sleep(5);
        StoryValidation v2 = validation("s");
        manager.gitTag("v2");
        File second = manager.saveValidation(v2);
        // The second validation records a diff against the first.
        assertNotNull(v2.comparison);
        assertEquals("story_validation_s_v1.json", v2.comparison.previousFile);

        Thread.sleep(5);
        StoryValidation v3 = validation("s");
        manager.gitTag("v3");
        manager.saveValidation(v3);

        // Only the two most recent validation files are kept.
        File validationsDir = manager.validationsDir();
        int count = 0;
        for (File f : validationsDir.listFiles()) {
            if (f.getName().startsWith("story_validation_s_")) {
                count++;
            }
        }
        assertEquals(2, count);
        assertTrue(second.isFile());
    }

    @Test
    void saveValidationSameTagRerunDoesNotSelfReference(@TempDir File dir) throws Exception {
        SnapshotFileManager manager = new SnapshotFileManager(dir);
        manager.gitTag("v1");
        manager.saveValidation(validation("s"));

        // Re-running capture at the same git tag overwrites the same destination file; it must not
        // treat that file as the "previous" validation (a self-referential comparison).
        StoryValidation rerun = validation("s");
        manager.gitTag("v1");
        manager.saveValidation(rerun);
        assertEquals(null, rerun.comparison);
    }

    private StoryValidation validation(String storyName) {
        StoryValidation v = new StoryValidation();
        v.storyName = storyName;
        v.validationTime = java.time.OffsetDateTime.now().toString();
        v.completionStatus = StoryValidation.STATUS_COMPLETE;
        return v;
    }
}
