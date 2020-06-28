package com.ddstudy.proxy;

/**
 * @Classname People
 * @Description TODO
 * @Date 2020/6/28
 * @Author Grain Rain
 */
public class People implements HelloService{
    @Override
    public void sayHello() {
        System.out.println("Hello World ~~~");
    }
}
