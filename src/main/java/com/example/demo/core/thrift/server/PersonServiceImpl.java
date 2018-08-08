package com.example.demo.core.thrift.server;

import com.example.demo.core.thrift.model.generated.DataException;
import com.example.demo.core.thrift.model.generated.Person;
import com.example.demo.core.thrift.model.generated.PersonService;
import org.apache.thrift.TException;

/**
 * @author 侯存路
 * @date 2018/8/2
 * @company codingApi
 * @description
 */
public class PersonServiceImpl implements PersonService.Iface{


    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println(" 客户端  >> " +username);

        Person person = new Person();
        person.setUsername("username");
        person.setAge(20);
        person.setMarried(false);

        return person;
    }


    @Override
    public void savePerson(String username) throws DataException, TException {
        System.out.println("客户端参数 》》"+username);
    }

}
