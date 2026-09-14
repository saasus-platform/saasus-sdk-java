package saasus.sdk.testlib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A test story: optional setup, an ordered list of steps, optional cleanup, and shared
 * variables handed between steps. Cleanup runs even when steps fail.
 */
public class Story {

    private final String name;
    private final String description;
    private final String module;
    private final List<Step> steps;
    private final LifecycleAction setup;
    private final LifecycleAction cleanup;
    private final Map<String, Object> initialVariables;
    private final int timeoutSeconds; // 0 = use engine/config default

    private Story(Builder b) {
        this.name = b.name;
        this.description = b.description;
        this.module = b.module;
        this.steps = Collections.unmodifiableList(new ArrayList<Step>(b.steps));
        this.setup = b.setup;
        this.cleanup = b.cleanup;
        this.initialVariables = Collections.unmodifiableMap(new LinkedHashMap<String, Object>(b.initialVariables));
        this.timeoutSeconds = b.timeoutSeconds;
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public String module() {
        return module;
    }

    public List<Step> steps() {
        return steps;
    }

    public LifecycleAction setup() {
        return setup;
    }

    public LifecycleAction cleanup() {
        return cleanup;
    }

    public Map<String, Object> initialVariables() {
        return initialVariables;
    }

    public int timeoutSeconds() {
        return timeoutSeconds;
    }

    public static class Builder {
        private final String name;
        private String description = "";
        private String module = "";
        private final List<Step> steps = new ArrayList<Step>();
        private LifecycleAction setup;
        private LifecycleAction cleanup;
        private final Map<String, Object> initialVariables = new LinkedHashMap<String, Object>();
        private int timeoutSeconds = 0;

        public Builder(String name) {
            if (name == null) {
                throw new IllegalArgumentException("story name must not be null");
            }
            this.name = name;
        }

        public Builder description(String description) {
            this.description = description == null ? "" : description;
            return this;
        }

        public Builder module(String module) {
            this.module = module == null ? "" : module;
            return this;
        }

        public Builder step(Step step) {
            if (step != null) {
                this.steps.add(step);
            }
            return this;
        }

        public Builder steps(List<Step> steps) {
            if (steps != null) {
                this.steps.addAll(steps);
            }
            return this;
        }

        public Builder setup(LifecycleAction setup) {
            this.setup = setup;
            return this;
        }

        public Builder cleanup(LifecycleAction cleanup) {
            this.cleanup = cleanup;
            return this;
        }

        public Builder variable(String key, Object value) {
            this.initialVariables.put(key, value);
            return this;
        }

        public Builder timeoutSeconds(int seconds) {
            this.timeoutSeconds = Math.max(0, seconds);
            return this;
        }

        public Story build() {
            return new Story(this);
        }
    }
}
