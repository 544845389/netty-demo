package com.example.demo.core.protobuf.client;

import com.example.demo.core.socket.client.MyClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author 侯存路
 * @date 2018/7/11
 * @company codingApi
 * @description
 */
public class MyPBClient {



    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new MyPBClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1" , 8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            eventExecutors.shutdownGracefully();
        }

    }


}
