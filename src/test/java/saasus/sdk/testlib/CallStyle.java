package saasus.sdk.testlib;

/**
 * The four SDK call styles a step can exercise.
 *
 * <ul>
 *   <li>{@link #NORMAL} &ndash; {@code fooBar()} returning the deserialized model.</li>
 *   <li>{@link #WITH_HTTP_INFO} &ndash; {@code fooBarWithHttpInfo()} returning an
 *       {@code ApiResponse} (data + status code + headers).</li>
 *   <li>{@link #ASYNC} &ndash; {@code fooBarAsync(ApiCallback)} completing through a callback.</li>
 *   <li>{@link #CALL} &ndash; {@code fooBarCall(ApiCallback)} executed through the configured
 *       (signed) {@code ApiClient}.</li>
 * </ul>
 */
public enum CallStyle {
    NORMAL,
    WITH_HTTP_INFO,
    ASYNC,
    CALL;

    /** Suffix conventionally appended to the base method name for this style. */
    public String suffix() {
        switch (this) {
            case WITH_HTTP_INFO:
                return "WithHttpInfo";
            case ASYNC:
                return "Async";
            case CALL:
                return "Call";
            case NORMAL:
            default:
                return "";
        }
    }

    /** Coverage key for a base method exercised through this call style, e.g. {@code getStripeInfo:ASYNC}. */
    public String coverageKey(String baseMethod) {
        return baseMethod + ":" + name();
    }
}
