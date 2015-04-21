package net.f.p2.echoserver;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Created by fortune on 4/21/15.
 */
public class EchoClient {
    private final int port;

    public EchoClient(int port) {
        this.port = port;
    }

    public  void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
    }
}
