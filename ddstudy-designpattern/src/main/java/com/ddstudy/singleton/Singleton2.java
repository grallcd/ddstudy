package com.ddstudy.singleton;

/**
 * @Classname Single
 * @Description 线程安全的懒汉式单例
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
