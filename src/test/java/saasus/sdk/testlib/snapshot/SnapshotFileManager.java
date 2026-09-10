package saasus.sdk.testlib.snapshot;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Persists {@link StorySnapshot} and {@link StoryValidation} objects using the Go layout:
 *
 * <ul>
 *   <li>snapshots: {@code <baseDir>/story_snapshots/tags/story_snapshot_{gitTag}_{story}.json};</li>
 *   <li>validations: {@code <baseDir>/story_validations/story_validation_{story}_{gitTag}.json}
 *       (only the two most recent per story are kept, and each records a diff against the
 *       previous one).</li>
 * </ul>
 *
 * <p>JSON is written with {@link SnapshotJson#SNAKE} (snake_case, sorted-key bodies, two-space
 * indentation) to line up with the Go output.
 */
public class SnapshotFileManager {

    private final File baseDir;
    private String cachedGitTag;

    public SnapshotFileManager(String baseDir) {
        this(new File(baseDir == null ? "tests/e2e/snapshot" : baseDir));
    }

    public SnapshotFileManager(File baseDir) {
        this.baseDir = baseDir;
    }

    public File baseDir() {
        return baseDir;
    }

    // ---- git tag --------------------------------------------------------------

    /**
     * Resolves the current git tag the same way as the Go file manager:
     * {@code git describe --tags --exact-match HEAD}, then {@code git describe --tags --always},
     * then a timestamped fallback. The result is cached for the lifetime of this manager.
     */
    public String gitTag() {
        if (cachedGitTag == null) {
            cachedGitTag = resolveGitTag();
        }
        return cachedGitTag;
    }

    /** Overrides the resolved git tag (used by tests for deterministic file names). */
    public SnapshotFileManager gitTag(String tag) {
        this.cachedGitTag = tag;
        return this;
    }

    private String resolveGitTag() {
        String exact = runGit("describe", "--tags", "--exact-match", "HEAD");
        if (exact != null && !exact.isEmpty()) {
            return exact;
        }
        String describe = runGit("describe", "--tags", "--always");
        if (describe != null && !describe.isEmpty()) {
            return describe;
        }
        return "snapshot_" + (System.currentTimeMillis() / 1000L);
    }

    private String runGit(String... args) {
        List<String> command = new ArrayList<String>();
        command.add("git");
        Collections.addAll(command, args);
        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.redirectErrorStream(false);
            Process process = pb.start();
            String out = new String(readAll(process), StandardCharsets.UTF_8).trim();
            boolean done = process.waitFor(10, TimeUnit.SECONDS);
            if (!done) {
                process.destroyForcibly();
                return null;
            }
            if (process.exitValue() != 0) {
                return null;
            }
            return out;
        } catch (IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            return null;
        }
    }

    private static byte[] readAll(Process process) throws IOException {
        try (java.io.InputStream in = process.getInputStream();
             java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            return out.toByteArray();
        }
    }

    // ---- snapshots ------------------------------------------------------------

    public File snapshotsDir() {
        return new File(new File(baseDir, "story_snapshots"), "tags");
    }

    public File snapshotPath(String tag, String storyName) {
        return new File(snapshotsDir(),
                "story_snapshot_" + sanitizeTag(tag) + "_" + sanitizeStoryName(storyName) + ".json");
    }

    public File saveSnapshot(StorySnapshot snapshot) throws IOException {
        File dir = snapshotsDir();
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("failed to create snapshots directory: " + dir);
        }
        File file = snapshotPath(gitTag(), snapshot.storyName);
        Files.write(file.toPath(), SnapshotJson.SNAKE.toJson(snapshot).getBytes(StandardCharsets.UTF_8));
        return file;
    }

    public StorySnapshot loadSnapshot(File file) throws IOException {
        String json = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        return SnapshotJson.SNAKE.fromJson(json, StorySnapshot.class);
    }

    public boolean snapshotExists(String tag, String storyName) {
        return snapshotPath(tag, storyName).isFile();
    }

    /** Lists available snapshot file names, sorted. */
    public List<String> listSnapshots() {
        return listWithPrefix(snapshotsDir(), "story_snapshot_");
    }

    /**
     * Returns the snapshot for the most recent tag other than {@code currentTag}, or
     * {@code null} if there is no earlier baseline for the story.
     */
    public StorySnapshot loadPreviousSnapshot(String currentTag, String storyName) throws IOException {
        String suffix = "_" + sanitizeStoryName(storyName) + ".json";
        String current = sanitizeTag(currentTag);
        List<String> tags = new ArrayList<String>();
        for (String name : listSnapshots()) {
            if (name.endsWith(suffix)) {
                String tag = name.substring("story_snapshot_".length(), name.length() - suffix.length());
                if (!tag.equals(current)) {
                    tags.add(tag);
                }
            }
        }
        if (tags.isEmpty()) {
            return null;
        }
        Collections.sort(tags);
        String previousTag = tags.get(tags.size() - 1);
        return loadSnapshot(snapshotPath(previousTag, storyName));
    }

    // ---- validations ----------------------------------------------------------

    public File validationsDir() {
        return new File(baseDir, "story_validations");
    }

    public File validationPath(String tag, String storyName) {
        return new File(validationsDir(),
                "story_validation_" + sanitizeStoryName(storyName) + "_" + sanitizeTag(tag) + ".json");
    }

    /**
     * Saves a validation result, filling in its {@link StoryValidation#comparison} with the diff
     * against the previous validation of the same story, then retaining only the two most recent
     * validation files for that story.
     */
    public File saveValidation(StoryValidation validation) throws IOException {
        File dir = validationsDir();
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("failed to create validations directory: " + dir);
        }

        File file = validationPath(gitTag(), validation.storyName);
        File previousFile = latestValidationFileExcluding(validation.storyName, file);
        if (previousFile != null) {
            StoryValidation previous = loadValidation(previousFile);
            validation.comparison = buildComparison(previous, validation, previousFile.getName());
        }

        Files.write(file.toPath(), SnapshotJson.SNAKE.toJson(validation).getBytes(StandardCharsets.UTF_8));

        retainLatestValidations(validation.storyName, 2);
        return file;
    }

    public StoryValidation loadValidation(File file) throws IOException {
        String json = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        return SnapshotJson.SNAKE.fromJson(json, StoryValidation.class);
    }

    private ValidationComparison buildComparison(StoryValidation previous, StoryValidation current,
                                                 String previousFileName) {
        ValidationComparison comparison = new ValidationComparison();
        comparison.previousFile = previousFileName;
        comparison.previousValidationTime = previous.validationTime;
        comparison.errorCountDelta = current.summary.totalErrors - previous.summary.totalErrors;
        comparison.warningCountDelta = current.summary.totalWarnings - previous.summary.totalWarnings;
        comparison.infoCountDelta = current.summary.totalInfo - previous.summary.totalInfo;
        return comparison;
    }

    /**
     * Newest validation file for a story, excluding {@code exclude} (the destination file of the
     * current run). Excluding the destination prevents a same-tag re-run from picking its own
     * about-to-be-overwritten output as the "previous" validation (a self-referential comparison).
     */
    private File latestValidationFileExcluding(String storyName, File exclude) {
        String excludeName = exclude == null ? null : exclude.getName();
        for (File f : sortedValidationFiles(storyName)) {
            if (excludeName != null && excludeName.equals(f.getName())) {
                continue;
            }
            return f;
        }
        return null;
    }

    private void retainLatestValidations(String storyName, int keep) {
        List<File> files = sortedValidationFiles(storyName);
        for (int i = keep; i < files.size(); i++) {
            // Best-effort cleanup; a failure to prune an old file must not fail the run.
            files.get(i).delete();
        }
    }

    /** Validation files for a story, newest first (by last-modified time). */
    private List<File> sortedValidationFiles(String storyName) {
        File dir = validationsDir();
        String prefix = "story_validation_" + sanitizeStoryName(storyName) + "_";
        List<File> files = new ArrayList<File>();
        File[] entries = dir.listFiles();
        if (entries != null) {
            for (File f : entries) {
                if (f.isFile() && f.getName().startsWith(prefix) && f.getName().endsWith(".json")) {
                    files.add(f);
                }
            }
        }
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File a, File b) {
                return Long.compare(b.lastModified(), a.lastModified());
            }
        });
        return files;
    }

    // ---- helpers --------------------------------------------------------------

    private static List<String> listWithPrefix(File dir, String prefix) {
        List<String> names = new ArrayList<String>();
        File[] entries = dir.listFiles();
        if (entries != null) {
            for (File f : entries) {
                if (f.isFile() && f.getName().startsWith(prefix) && f.getName().endsWith(".json")) {
                    names.add(f.getName());
                }
            }
        }
        Collections.sort(names);
        return names;
    }

    /**
     * Sanitizes a git tag for use as a single filename component. Path separators ({@code /} and
     * {@code \}) are replaced with {@code _} so hierarchical tag names (e.g. {@code release/v1.0})
     * do not point the snapshot/validation file below an uncreated directory.
     */
    static String sanitizeTag(String tag) {
        if (tag == null || tag.isEmpty()) {
            return "snapshot";
        }
        return tag.replaceAll("[/\\\\]", "_");
    }

    /**
     * Sanitizes a story name for use in file names, matching Go's {@code sanitizeStoryName}:
     * spaces, {@code -}, {@code .}, {@code /}, {@code \\} become {@code _}; lower-cased;
     * consecutive underscores collapsed; leading/trailing underscores trimmed.
     */
    static String sanitizeStoryName(String storyName) {
        if (storyName == null || storyName.isEmpty()) {
            return "";
        }
        String s = storyName.replaceAll("[ \\-./\\\\]", "_").toLowerCase(Locale.ROOT);
        s = s.replaceAll("_+", "_");
        s = s.replaceAll("^_+|_+$", "");
        return s;
    }
}
