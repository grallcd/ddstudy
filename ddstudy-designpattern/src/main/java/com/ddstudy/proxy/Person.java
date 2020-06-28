package com.ddstudy.proxy;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2020/6/28
 * @Author Grain Rain
 */
public class Person implements ByeService{
    @Override
    public void sayGoodBye() {
        System.out.println("Good Bye World ~~~");
    }
}
