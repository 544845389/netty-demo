package com.example.demo.core.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;

/**
 * @author 侯存路
 * @date 2018/8/8
 * @company codingApi
 * @description
 */
public class Test1Demo {


    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream =  new FileInputStream("E:\\aa.txt");
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining() > 0){
            byte b = byteBuffer.get();
            System.out.print((char)b);
        }

        fileInputStream.close();
        fileChannel.close();
    }


}
