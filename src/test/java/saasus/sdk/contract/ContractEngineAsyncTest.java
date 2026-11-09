package saasus.sdk.contract;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit coverage for {@link ContractEngine#awaitAsync}, the one piece of the
 * {@code Async} form whose outcome a passing round trip does not reveal: a
 * non-void operation must deliver a non-null payload through {@code onSuccess},
 * a void operation may deliver {@code null}, and an {@code onFailure} surfaces
 * the error. Driven with a fake callback and fake async methods so the check
 * runs without a live mock.
 */
public class ContractEngineAsyncTest {

    /** Stands in for a generated {@code ApiCallback}; resolution is by method name. */
    public interface FakeCallback {
        void onSuccess(Object result);

        void onFailure(Throwable error);
    }

    /** Fake async operations; each immediately drives the callback. */
    public static final class FakeApi {
        public void nonNull(FakeCallback cb) {
            cb.onSuccess("payload");
        }

        public void nullResult(FakeCallback cb) {
            cb.onSuccess(null);
        }

        public void failing(FakeCallback cb) {
            cb.onFailure(new IllegalStateException("boom"));
        }
    }

    private static void await(String method, boolean expectNonNull) throws Throwable {
        Method m = FakeApi.class.getMethod(method, FakeCallback.class);
        ContractEngine.awaitAsync(m, new FakeApi(), new Object[0], FakeCallback.class, expectNonNull);
    }

    @Test
    void nonVoidWithNonNullResultPasses() throws Throwable {
        await("nonNull", true);
    }

    @Test
    void nonVoidWithNullResultFails() {
        Assertions.assertThrows(AssertionError.class, () -> await("nullResult", true));
    }

    @Test
    void voidAllowsNullResult() throws Throwable {
        await("nullResult", false);
    }

    @Test
    void onFailureSurfacesError() {
        Assertions.assertThrows(IllegalStateException.class, () -> await("failing", true));
    }
}
