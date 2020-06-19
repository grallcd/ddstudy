package com.ddstudy.singleton;

/**
 * @Classname Singleton5
 * @Description 枚举实现单例, 可防止反射
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public enum Singleton5 {

    INSTANCE;

    public void operation() {
        System.out.println("Singleton5.operation");
    }

}
