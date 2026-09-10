package saasus.sdk.e2e.support;

import okhttp3.Call;

import java.util.Map;

/**
 * Builds an unsigned {@code okhttp3.Call} from an SDK {@code *Call} method, given the current
 * story variables (so parameterised endpoints can read prior-step state).
 *
 * <p>Used by the per-module invoker helpers to obtain the call that is then signed and executed
 * (synchronously for the {@code CALL} style, or via {@code executeAsync} for the {@code ASYNC}
 * style). {@code okhttp3.Call} is module-agnostic, so this interface is shared across modules;
 * the module-specific {@code ApiException} is surfaced as a checked {@link Exception}.
 */
@FunctionalInterface
public interface ThrowingCallSupplier {

    Call get(Map<String, Object> variables) throws Exception;
}
