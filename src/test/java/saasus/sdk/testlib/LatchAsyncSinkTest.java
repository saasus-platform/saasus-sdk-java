package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class LatchAsyncSinkTest {

    @Test
    void firstCompletionWinsWhenSuccessPrecedesFailure() throws Exception {
        LatchAsyncSink sink = new LatchAsyncSink();
        sink.onSuccess("first", 200, null);
        sink.onFailure(new RuntimeException("second"), 500, null);

        assertTrue(sink.await(100));
        assertTrue(sink.isSuccess());
        assertEquals("first", sink.result());
        assertEquals(200, sink.statusCode());
    }

    @Test
    void concurrentCallbacksProduceExactlyOneOutcome() throws Exception {
        // Stress the atomic completion guard: many racing success/failure callbacks must
        // yield a single, consistent outcome (never a mix).
        for (int iteration = 0; iteration < 200; iteration++) {
            final LatchAsyncSink sink = new LatchAsyncSink();
            final CountDownLatch start = new CountDownLatch(1);
            ExecutorService pool = Executors.newFixedThreadPool(2);
            pool.submit(() -> {
                await(start);
                sink.onSuccess("ok", 200, null);
            });
            pool.submit(() -> {
                await(start);
                sink.onFailure(new RuntimeException("boom"), 500, null);
            });
            start.countDown();
            pool.shutdown();
            pool.awaitTermination(2, TimeUnit.SECONDS);

            assertTrue(sink.await(100));
            if (sink.isSuccess()) {
                // Success outcome must be fully consistent.
                assertEquals("ok", sink.result());
                assertEquals(200, sink.statusCode());
            } else {
                assertEquals(500, sink.statusCode());
            }
        }
    }

    private static void await(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
