package saasus.sdk.testlib.snapshot;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Captured snapshot of a whole story execution, mirroring the Go {@code StorySnapshot}.
 *
 * <p>Field declaration order matches the Go struct so the serialized JSON key order lines up.
 * {@link #timestamp} is an RFC 3339 string and {@link #duration} is expressed in nanoseconds,
 * matching the Go {@code time.Time}/{@code time.Duration} encodings.
 */
public class StorySnapshot {

    public String storyName;
    public String description;
    public String timestamp;
    public long duration;
    public String status;
    public Map<String, Object> variables = new LinkedHashMap<String, Object>();
    public List<StepSnapshot> steps = new ArrayList<StepSnapshot>();
    public StoryExecutionSummary summary = new StoryExecutionSummary();
    public SnapshotMetadata metadata = new SnapshotMetadata();

    public StorySnapshot() {
    }
}
