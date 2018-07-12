package com.example.demo.core.test;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * @author 侯存路
 * @date 2018/7/10
 * @company codingApi
 * @description
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {



    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline  channelPipeline = ch.pipeline();

        channelPipeline.addLast("httpServerCodec" , new HttpServerCodec());
        channelPipeline.addLast("testHttpServerHandler" , new TestHttpServerHandler());
    }




}
