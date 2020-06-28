package com.ddstudy.singleton;

/**
 * @Classname Singleton4
 * @Description 静态内部类实现单例
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class Singleton4 {

    private static class inner{
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance(){
        return inner.INSTANCE;
    }
}
