package com.example.demo.core.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;
import java.net.URL;

/**
 * @author 侯存路
 * @date 2018/7/10
 * @company codingApi
 * @description
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject>{



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        if(msg instanceof HttpRequest){
            HttpRequest request = (HttpRequest)msg;
            System.out.println("请求方法名:"+request.method());

            URI u = new URI(request.uri());
            System.out.println("内容》》》"+u.getPath());


            ByteBuf content = Unpooled.copiedBuffer("hello world" , CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse( HttpVersion.HTTP_1_1 , HttpResponseStatus.OK , content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE , "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH , content.readableBytes());

            ctx.writeAndFlush(response);

        }else{
            System.out.println("不是http");
        }


    }

}
