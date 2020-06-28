package com.ddstudy.proxy;

/**
 * @Classname PeopleProxy
 * @Description TODO
 * @Date 2020/6/28
 * @Author Grain Rain
 */
public class PeopleProxy implements HelloService{

    private final People people;

    public PeopleProxy(People people) {
        this.people = people;
    }

    @Override
    public void sayHello() {
        before();
        people.sayHello();
        after();
    }

    private void before(){
        System.out.println("Before say hello");
    }

    private void after(){
        System.out.println("After say hello");
    }
}
