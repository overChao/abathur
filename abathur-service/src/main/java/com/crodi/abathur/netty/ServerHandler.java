package com.crodi.abathur.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * author: crodi
 * create: 22-07-05
 * description: netty demo验证  ServerHandler
 * <p>
 * 自定义的handler 继承了handlerAdapter  才会被Netty框架管理 类似 适配器模式
 */

@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 从 channel 中 读取 消息
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("收到客户端：{} 发送的消息: {}", ctx.channel().remoteAddress(), byteBuf.toString(CharsetUtil.UTF_8));

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 从 channel 中 读取消息完成， 并返回 读取结果
        ctx.writeAndFlush(Unpooled.copiedBuffer("服务端接受到消息，并返回一个问好?", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("server handler 发生异常， message = {}", cause.getMessage());
        ctx.close();
    }


}
