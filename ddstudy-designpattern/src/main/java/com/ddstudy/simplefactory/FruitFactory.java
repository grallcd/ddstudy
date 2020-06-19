package com.ddstudy.simplefactory;

/**
 * @Classname FruitFactory
 * @Description 静态工厂模式
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class FruitFactory {

    public static Fruit getFruit(Type type) {

        switch (type) {

            case APPLE:
                return new Apple();

            case LEMON:
                return new Lemon();

            case BANANA:
                return new Banana();
            default:
                return null;
        }

    }

    enum Type {
        APPLE, BANANA, LEMON
    }

}
