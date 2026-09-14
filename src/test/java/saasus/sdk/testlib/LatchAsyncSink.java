package saasus.sdk.testlib;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * {@link AsyncSink} implementation that captures the first completion event and lets a
 * caller block until it arrives (or a timeout elapses).
 */
public class LatchAsyncSink implements AsyncSink {

    private final CountDownLatch latch = new CountDownLatch(1);
    private volatile boolean success;
    private volatile Object result;
    private volatile Throwable error;
    private volatile int statusCode;
    private volatile Map<String, List<String>> headers;
    private final AtomicBoolean completed = new AtomicBoolean(false);

    @Override
    public void onSuccess(Object result, int statusCode, Map<String, List<String>> headers) {
        // Atomically claim the first completion; racing callbacks are ignored.
        if (!completed.compareAndSet(false, true)) {
            return;
        }
        this.success = true;
        this.result = result;
        this.statusCode = statusCode;
        this.headers = headers;
        latch.countDown();
    }

    @Override
    public void onFailure(Throwable error, int statusCode, Map<String, List<String>> headers) {
        if (!completed.compareAndSet(false, true)) {
            return;
        }
        this.success = false;
        this.error = error;
        this.statusCode = statusCode;
        this.headers = headers;
        latch.countDown();
    }

    /**
     * Waits up to {@code timeoutMillis} for completion.
     *
     * @return {@code true} if completed within the timeout, {@code false} otherwise.
     */
    public boolean await(long timeoutMillis) throws InterruptedException {
        return latch.await(timeoutMillis, TimeUnit.MILLISECONDS);
    }

    public boolean isSuccess() {
        return success;
    }

    public Object result() {
        return result;
    }

    public Throwable error() {
        return error;
    }

    public int statusCode() {
        return statusCode;
    }

    public Map<String, List<String>> headers() {
        return headers;
    }
}
