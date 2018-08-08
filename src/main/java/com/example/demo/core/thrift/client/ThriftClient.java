package com.example.demo.core.thrift.client;

import com.example.demo.core.thrift.model.generated.DataException;
import com.example.demo.core.thrift.model.generated.Person;
import com.example.demo.core.thrift.model.generated.PersonService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author 侯存路
 * @date 2018/8/2
 * @company codingApi
 * @description
 */
public class ThriftClient {



    public static void main(String[] args) {
        TTransport tTransport = new TFramedTransport(new TSocket("127.0.0.1" , 8899) , 600);
        TProtocol protocol = new TCompactProtocol(tTransport);

        PersonService.Client client = new PersonService.Client(protocol);

        try {

            tTransport.open();

            Person person = client.getPersonByUsername("张三");

            System.out.println(person.getUsername());
            System.out.println(person.getAge());

            System.out.println(" --------- ");

            client.savePerson("李四");

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }


}
