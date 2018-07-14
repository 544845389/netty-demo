package com.example.demo.core.protobuf.client;

import com.example.demo.core.protobuf.DateInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 侯存路
 * @date 2018/7/11
 * @company codingApi
 * @description
 */
public class MyPBClientHandler extends SimpleChannelInboundHandler<DateInfo.Student> {




    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DateInfo.Student msg) throws Exception {
        System.out.println("连接成功!");
    }



    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DateInfo.Student student  =  DateInfo.Student.newBuilder()
                .setName("客户端")
                .setAddress("地址")
                .setAge(10).build();
        ctx.channel().writeAndFlush(student);
    }



}
