package com.example.demo.core.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author 侯存路
 * @date 2018/7/13
 * @company codingApi
 * @description
 */
public class ProtoBufTest {


    public static void main(String[] args) throws InvalidProtocolBufferException {
        DateInfo.Student student =  DateInfo.Student.newBuilder().setName("张三").setAge(20).setAddress("济南").build();
        byte []  bytes =  student.toByteArray();

        DateInfo.Student student1 = DateInfo.Student.parseFrom(bytes);
        System.out.println(student1.getAddress());
    }

}
