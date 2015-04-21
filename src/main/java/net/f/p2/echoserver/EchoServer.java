package net.f.p2.echoserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by fortune on 4/21/15.
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group).channel(NioServerSocketChannel.class).localAddress(port).childHandler(
                    new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            ChannelFuture future = bootstrap.bind().sync();
            System.out.println(EchoServer.class.getName() + " start and listen on "  + future.channel().localAddress());
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }

    }
}
