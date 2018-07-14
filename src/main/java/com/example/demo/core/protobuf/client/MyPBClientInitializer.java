package com.example.demo.core.protobuf.client;

import com.example.demo.core.protobuf.DateInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author 侯存路
 * @date 2018/7/11
 * @company codingApi
 * @description
 */
public class MyPBClientInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(new ProtobufVarint32FrameDecoder());
        channelPipeline.addLast(new ProtobufDecoder(DateInfo.Student.getDefaultInstance()));
        channelPipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        channelPipeline.addLast(new ProtobufEncoder());

        channelPipeline.addLast(new MyPBClientHandler());
    }


}
