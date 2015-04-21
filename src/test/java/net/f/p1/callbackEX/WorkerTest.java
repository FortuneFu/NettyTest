package net.f.p1.callbackEX;

import org.junit.Test;

/**
 * Created by fortune on 4/15/15.
 */
public class WorkerTest {

    @Test
    public void testDoWork() throws Exception {
        Worker worker = new Worker();
        worker.doWork();
    }
}
