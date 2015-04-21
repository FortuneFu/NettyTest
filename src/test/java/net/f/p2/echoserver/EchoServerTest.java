package net.f.p2.echoserver;

import org.junit.Test;

/**
 * Created by fortune on 4/21/15.
 */
public class EchoServerTest {

    @Test
    public void testStart() throws Exception {
        new EchoServer(65530).start();
    }
}
