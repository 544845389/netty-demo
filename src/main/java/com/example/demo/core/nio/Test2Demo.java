package com.example.demo.core.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 侯存路
 * @date 2018/8/8
 * @company codingApi
 * @description
 */
public class Test2Demo {


    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\aa.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byte [] msg = "bbbbb".getBytes();

        for(int i = 0 ; i < msg.length ; i++){
            byteBuffer.put(msg[i]);
        }

        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        fileOutputStream.close();
    }


}
