package com.example.demo.core.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 侯存路
 * @date 2018/7/12
 * @company codingApi
 * @description
 */
public class MyChatClient {



    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new MyChatClientInitializer());
            Channel c  = bootstrap.connect("127.0.0.1" , 8899).channel();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            for (;;){

                c.writeAndFlush(bufferedReader.readLine()+"\r\n");
            }

        }finally {
            eventExecutors.shutdownGracefully();
        }

    }


}
