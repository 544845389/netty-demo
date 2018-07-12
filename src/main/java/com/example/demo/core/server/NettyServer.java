package com.example.demo.core.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * @author houcunlu
 * @date 2018/7/9
 * @company codingApi
 * @description
 */
public class NettyServer extends ChannelInboundHandlerAdapter {



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        // (1)
        ctx.write(msg);

        // (2)
        ctx.flush();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.

        System.out.println("异常>>>>>>>>>>>>"+cause.getMessage().toString());
        cause.printStackTrace();
        ctx.close();
    }



}
