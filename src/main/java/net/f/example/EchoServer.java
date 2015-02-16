package net.f.example;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
	private int port;

	public EchoServer(int port) {
		this.port = port;
	}

	public void start() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap sb = new ServerBootstrap();

			sb.group(group).channel(NioServerSocketChannel.class)
					.localAddress(this.port)
					.childHandler(new ChannelInitializer<Channel>() {

						@Override
						protected void initChannel(Channel ch) throws Exception {
							ch.pipeline().addLast(new EchoServerHandler());
						}
					});

			ChannelFuture f = sb.bind().sync();
			System.out.println(EchoServer.class.getName()
					+ "started and listen on " + f.channel().localAddress());
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			group.shutdownGracefully().sync();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		EchoServer server = new EchoServer(12378);
		server.start();
	}
}
