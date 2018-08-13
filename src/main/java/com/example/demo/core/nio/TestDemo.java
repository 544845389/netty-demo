package com.example.demo.core.nio;

import java.io.*;
import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author 侯存路
 * @date 2018/8/8
 * @company codingApi
 * @description
 */
public class TestDemo {


    public static void main(String[] args) throws FileNotFoundException {
        IntBuffer buffer = IntBuffer.allocate(10);

        for(int i = 0 ; i< buffer.capacity() ; i++){
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        buffer.flip();

        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }

    }


}
