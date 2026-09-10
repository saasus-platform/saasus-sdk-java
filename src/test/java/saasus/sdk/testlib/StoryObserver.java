package saasus.sdk.testlib;

/**
 * Hook invoked by {@link E2EEngine} after each story finishes. Implemented by the snapshot
 * engine so that snapshot capture/comparison stays decoupled from the core engine.
 */
public interface StoryObserver {

    /**
     * @return {@code true} if the story should be marked as failed as a result of this
     *         observer (for example a breaking snapshot change with {@code failOnBreaking});
     *         {@code false} otherwise.
     */
    boolean onStoryFinished(Story story, StoryResult result);
}
