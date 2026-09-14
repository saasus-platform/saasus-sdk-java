package saasus.sdk.testlib;

/**
 * Converts a module-specific {@code ApiException} into a module-agnostic {@link ApiError}.
 *
 * <p>Each SDK module has its own {@code ApiException} class (they share no common
 * supertype beyond {@link Throwable}), so a caller registers one extractor per module,
 * for example:
 *
 * <pre>{@code
 * ApiErrorExtractor billing = ex -> {
 *     if (ex instanceof saasus.sdk.billing.ApiException) {
 *         saasus.sdk.billing.ApiException e = (saasus.sdk.billing.ApiException) ex;
 *         return new ApiError(e.getCode(), e.getResponseHeaders(), e.getResponseBody());
 *     }
 *     return null; // not recognised
 * };
 * }</pre>
 */
@FunctionalInterface
public interface ApiErrorExtractor {

    /**
     * @return an {@link ApiError} describing {@code throwable}, or {@code null} when the
     *         throwable is not a recognised API exception.
     */
    ApiError extract(Throwable throwable);
}
