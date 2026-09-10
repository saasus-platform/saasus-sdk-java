package saasus.sdk.e2e.support;

import saasus.sdk.testlib.Config;
import saasus.sdk.testlib.E2EEngine;
import saasus.sdk.testlib.SnapshotConfig;
import saasus.sdk.testlib.snapshot.SnapshotEngine;
import saasus.sdk.testlib.snapshot.SnapshotMasker;

/**
 * Attaches snapshot capture/comparison to an {@link E2EEngine} when snapshot support is enabled
 * via the {@code E2E_SNAPSHOT_*} environment variables (which populate {@link Config#snapshot}).
 *
 * <p>Snapshot behaviour is integrated into the single E2E run per module (rather than a separate
 * test) so resources are mutated only once. Snapshots follow the saasus-sdk-go layout, written
 * under {@code <outputDirectory>/<module>/story_snapshots/tags/} (with validations under
 * {@code story_validations/}) and named per git tag. Real values (ids, timestamps, ...) are
 * preserved; only secret-like values are masked ({@code [MASKED len=N]}) by the snapshot engine.
 */
public final class Snapshots {

    private Snapshots() {
    }

    public static void attach(E2EEngine engine, Config config, String module) {
        SnapshotConfig sc = config.snapshot;
        if (sc == null || !sc.anyEnabled()) {
            return;
        }
        if (sc.outputDirectory == null || sc.outputDirectory.isEmpty()) {
            sc.outputDirectory = "tests/e2e/snapshot";
        }
        sc.outputDirectory = sc.outputDirectory + "/" + module;

        // Sensitive values are masked by key ([MASKED len=N]); dynamic values (ids, timestamps)
        // are preserved verbatim and kept distinct across runs via the per-git-tag file layout,
        // matching the saasus-sdk-go snapshot format.
        SnapshotMasker masker = new SnapshotMasker();

        engine.addObserver(new SnapshotEngine(sc, engine.logger(), masker));
    }
}
