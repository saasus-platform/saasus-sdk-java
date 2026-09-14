package saasus.sdk.testlib;

import java.util.ArrayList;
import java.util.List;

/**
 * The set of call-style invokers registered for a single base method. Any subset of the
 * four styles may be provided; unregistered styles are reported as unsupported.
 */
public class MethodInvokers {

    private final NormalCall normal;
    private final HttpInfoCall httpInfo;
    private final SinkCall async;
    private final SinkCall call;

    private MethodInvokers(Builder b) {
        this.normal = b.normal;
        this.httpInfo = b.httpInfo;
        this.async = b.async;
        this.call = b.call;
    }

    public static Builder builder() {
        return new Builder();
    }

    public NormalCall normal() {
        return normal;
    }

    public HttpInfoCall httpInfo() {
        return httpInfo;
    }

    public SinkCall async() {
        return async;
    }

    public SinkCall call() {
        return call;
    }

    public boolean supports(CallStyle style) {
        switch (style) {
            case NORMAL:
                return normal != null;
            case WITH_HTTP_INFO:
                return httpInfo != null;
            case ASYNC:
                return async != null;
            case CALL:
                return call != null;
            default:
                return false;
        }
    }

    /** The call styles this method supports. */
    public List<CallStyle> supportedStyles() {
        List<CallStyle> styles = new ArrayList<CallStyle>();
        for (CallStyle s : CallStyle.values()) {
            if (supports(s)) {
                styles.add(s);
            }
        }
        return styles;
    }

    public static class Builder {
        private NormalCall normal;
        private HttpInfoCall httpInfo;
        private SinkCall async;
        private SinkCall call;

        public Builder normal(NormalCall normal) {
            this.normal = normal;
            return this;
        }

        public Builder withHttpInfo(HttpInfoCall httpInfo) {
            this.httpInfo = httpInfo;
            return this;
        }

        public Builder async(SinkCall async) {
            this.async = async;
            return this;
        }

        public Builder call(SinkCall call) {
            this.call = call;
            return this;
        }

        public MethodInvokers build() {
            if (normal == null && httpInfo == null && async == null && call == null) {
                throw new IllegalStateException("MethodInvokers must define at least one call style");
            }
            return new MethodInvokers(this);
        }
    }
}
