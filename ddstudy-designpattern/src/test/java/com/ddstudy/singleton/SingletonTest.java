package com.ddstudy.singleton;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @Classname SingletonTest
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class SingletonTest {

    @Test
    public void testSingleton() {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        Assertions.assertSame(instance, instance1);
    }

    @Test
    public void testSingleton2() {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance1 = Singleton2.getInstance();

        Assertions.assertSame(instance, instance1);
    }

    @Test
    public void testSingleton3() {
        Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance1 = Singleton3.getInstance();

        Assertions.assertSame(instance, instance1);
    }

    @Test
    public void testSingleton4() {
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance1 = Singleton4.getInstance();

        Assertions.assertSame(instance, instance1);
    }

    @Test
    public void testSingleton5() {
        Singleton5 instance = Singleton5.INSTANCE;
        Singleton5 instance1 = Singleton5.INSTANCE;

        Assertions.assertSame(instance, instance1);
    }
}
