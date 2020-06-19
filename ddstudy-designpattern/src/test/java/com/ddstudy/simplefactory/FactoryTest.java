package com.ddstudy.simplefactory;

import org.junit.jupiter.api.Test;

/**
 * @Classname FactoryTest
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class FactoryTest {

    @Test
    public void testFactory() {

        Fruit apple = FruitFactory.getFruit(FruitFactory.Type.APPLE);
        Fruit banana = FruitFactory.getFruit(FruitFactory.Type.BANANA);
        Fruit lemon = FruitFactory.getFruit(FruitFactory.Type.LEMON);

        apple.description();

        banana.description();

        lemon.description();


    }
}
