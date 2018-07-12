package com.example.demo.core.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author 侯存路
 * @date 2018/7/11
 * @company codingApi
 * @description
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {


    private static ChannelGroup  channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel  =  ctx.channel();
        channels.forEach(c -> {
            if (c.remoteAddress().equals(channel.remoteAddress())){
                c.writeAndFlush("自己说的:"+msg+"\n");
            }else{
                c.writeAndFlush("别人说的:"+msg+"\n");
            }
        });
    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel =  ctx.channel();

        channels.writeAndFlush("有人上线"+channel.remoteAddress()+"加入\n");

        channels.add(channel);

    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel =   ctx.channel();
        channels.writeAndFlush("有人下线 "+channel.remoteAddress()+"离开\n");
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel =  ctx.channel();
        System.out.println(channel.remoteAddress() +"上线");
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel =  ctx.channel();
        System.out.println(channel.remoteAddress() +"下线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
