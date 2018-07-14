package com.example.demo.core.protobuf.server;

import com.example.demo.core.protobuf.DateInfo;
import com.google.protobuf.MessageLite;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 侯存路
 * @date 2018/7/11
 * @company codingApi
 * @description
 */
public class MyPBServerHandler extends SimpleChannelInboundHandler<DateInfo.Student>{





    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DateInfo.Student msg) throws Exception {
        System.out.println(msg.getName());
    }


}
