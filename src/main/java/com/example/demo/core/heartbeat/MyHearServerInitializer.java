package com.example.demo.core.heartbeat;

import com.example.demo.core.chat.MyChatServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author 侯存路
 * @date 2018/7/11
 * @company codingApi
 * @description
 */
public class MyHearServerInitializer extends ChannelInitializer<SocketChannel>{


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline =  ch.pipeline();

        channelPipeline.addLast(new IdleStateHandler(5 , 7 , 10 , TimeUnit.SECONDS));
        channelPipeline.addLast(new MyHearServerHandler());

    }



}
