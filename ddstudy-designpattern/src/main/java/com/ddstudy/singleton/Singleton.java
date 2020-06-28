package com.ddstudy.singleton;

/**
 * @Classname Singleton
 * @Description 饿汉式单例
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
