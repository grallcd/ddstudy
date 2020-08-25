package com.ddstudy.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @Classname ProxyTest
 * @Description TODO
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class ProxyTest {

    @Test
    void testStaticProxy() {

        // 不使用代理调用方法
        People people = new People();
        people.sayHello();

        // 使用代理调用方法
        PeopleProxy proxy = new PeopleProxy(people);
        proxy.sayHello();
    }

    @Test
    void testDynamicProxy() {

        People people = new People();
        ProxyHandler handler = new ProxyHandler(people);

        HelloService helloService = (HelloService) Proxy.newProxyInstance(people.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);

        helloService.sayHello();

        Person person = new Person();
        ProxyHandler handler2 = new ProxyHandler(person);
        ByeService byeService = (ByeService) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), handler2);

        byeService.sayGoodBye();


    }
}
