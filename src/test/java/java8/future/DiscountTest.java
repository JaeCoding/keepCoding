package java8.future;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author pengwenjie3
 * @date 2019/10/14
 * @since 1.8
 */
public class DiscountTest {

    @Test
    public void test() {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            assertTrue(Thread.currentThread().isDaemon());
            Utils.delay();
        });
        assertFalse(cf.isDone());
        Utils.delay();
        Utils.delay();
        assertTrue(cf.isDone());
    }
}