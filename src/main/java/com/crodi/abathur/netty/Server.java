package com.crodi.abathur.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * author: crodi
 * create: 22-07-05
 * description: netty demo验证  server 端
 */
@Slf4j
public class Server {


    public static void main(String[] args) {
        // 创建两个线程组
        final EventLoopGroup boosGroup = new NioEventLoopGroup();
        final EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建服务端的启动对象，设置参数
            final ServerBootstrap serverBootstrap = new ServerBootstrap();
            //设置两个线程组 boosGroup, workerGroup
            serverBootstrap.group(boosGroup, workerGroup)
                    // 设置服务端通道实现类型
                    .channel(NioServerSocketChannel.class)
                    // 设置线程队列的连接数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 设置连接
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // 使用匿名内部类 初始化通道对象
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //pipeline 管道处理器实现
                            socketChannel.pipeline().addLast(new ServerHandler());
                        }
                    });

            log.info("服务端已就绪...");

            final ChannelFuture channelFuture = serverBootstrap.bind(6666).sync();

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("netty 服务段启动异常，message = {}", e.getMessage());
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }


}
