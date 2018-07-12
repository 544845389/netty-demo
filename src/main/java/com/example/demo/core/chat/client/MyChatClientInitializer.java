package com.example.demo.core.chat.client;

import com.example.demo.core.chat.MyChatServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author 侯存路
 * @date 2018/7/12
 * @company codingApi
 * @description
 */
public class MyChatClientInitializer extends ChannelInitializer<SocketChannel>{



    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline =  ch.pipeline();

        channelPipeline.addLast(new DelimiterBasedFrameDecoder(4096 , Delimiters.lineDelimiter()));
        channelPipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        channelPipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));

        channelPipeline.addLast(new MyChatClientHandler());
    }


}
