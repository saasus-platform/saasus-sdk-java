package saasus.sdk.testlib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A single test step: one SDK method invoked through one {@link CallStyle}, with an
 * optional expected status, validation and state update.
 */
public class Step {

    private final String name;
    private final String method;
    private final CallStyle callStyle;
    private final int expectedStatus;
    private final List<Integer> allowedStatuses;
    private final boolean skip;
    private final String skipReason;
    private final Map<String, Object> inputs;
    private final Validation validation;
    private final StateUpdate stateUpdate;

    private Step(Builder b) {
        this.name = b.name;
        this.method = b.method;
        this.callStyle = b.callStyle;
        this.expectedStatus = b.expectedStatus;
        this.allowedStatuses = Collections.unmodifiableList(new ArrayList<Integer>(b.allowedStatuses));
        this.skip = b.skip;
        this.skipReason = b.skipReason;
        this.inputs = Collections.unmodifiableMap(new LinkedHashMap<String, Object>(b.inputs));
        this.validation = b.validation;
        this.stateUpdate = b.stateUpdate;
    }

    public static Builder builder(String name, String method) {
        return new Builder(name, method);
    }

    public String name() {
        return name;
    }

    public String method() {
        return method;
    }

    public CallStyle callStyle() {
        return callStyle;
    }

    public int expectedStatus() {
        return expectedStatus;
    }

    public List<Integer> allowedStatuses() {
        return allowedStatuses;
    }

    public boolean skip() {
        return skip;
    }

    public String skipReason() {
        return skipReason;
    }

    public Map<String, Object> inputs() {
        return inputs;
    }

    public Validation validation() {
        return validation;
    }

    public StateUpdate stateUpdate() {
        return stateUpdate;
    }

    public static class Builder {
        private final String name;
        private final String method;
        private CallStyle callStyle = CallStyle.NORMAL;
        private int expectedStatus = 0;
        private final List<Integer> allowedStatuses = new ArrayList<Integer>();
        private boolean skip = false;
        private String skipReason = "";
        private final Map<String, Object> inputs = new LinkedHashMap<String, Object>();
        private Validation validation;
        private StateUpdate stateUpdate;

        public Builder(String name, String method) {
            if (name == null || method == null) {
                throw new IllegalArgumentException("step name and method must not be null");
            }
            this.name = name;
            this.method = method;
        }

        public Builder callStyle(CallStyle style) {
            this.callStyle = style == null ? CallStyle.NORMAL : style;
            return this;
        }

        public Builder expectedStatus(int status) {
            this.expectedStatus = status;
            return this;
        }

        public Builder allowedStatuses(Integer... statuses) {
            if (statuses != null) {
                for (Integer s : statuses) {
                    if (s != null) {
                        this.allowedStatuses.add(s);
                    }
                }
            }
            return this;
        }

        public Builder skip(String reason) {
            this.skip = true;
            this.skipReason = reason == null ? "" : reason;
            return this;
        }

        public Builder input(String key, Object value) {
            this.inputs.put(key, value);
            return this;
        }

        public Builder validation(Validation validation) {
            this.validation = validation;
            return this;
        }

        public Builder stateUpdate(StateUpdate stateUpdate) {
            this.stateUpdate = stateUpdate;
            return this;
        }

        public Step build() {
            return new Step(this);
        }
    }
}
