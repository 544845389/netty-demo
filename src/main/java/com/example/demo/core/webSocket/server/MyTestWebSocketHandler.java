package com.example.demo.core.webSocket.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @author 侯存路
 * @date 2018/7/12
 * @company codingApi
 * @description
 */
public class MyTestWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("收到消息"+msg.text());

        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器说的"));
    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有人上线" + ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有人下线" + ctx.channel().id().asLongText());
    }
}
