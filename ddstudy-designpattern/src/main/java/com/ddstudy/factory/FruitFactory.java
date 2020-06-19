package com.ddstudy.factory;

/**
 * @Classname FruitFactory
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class FruitFactory {

    public static Fruit creatApple(){
        return new Apple();
    }

    public static Fruit creatBanana(){
        return new Banana();
    }
}
