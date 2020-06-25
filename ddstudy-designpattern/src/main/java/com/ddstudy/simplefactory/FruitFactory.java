package com.ddstudy.simplefactory;

/**
 * @Classname FruitFactory
 * @Description 静态工厂模式
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class FruitFactory {

    public static Fruit getFruit(FruitType type) {
        return type.get();
    }

}
