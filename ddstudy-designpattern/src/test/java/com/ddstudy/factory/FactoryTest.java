package com.ddstudy.factory;

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

        Fruit apple = FruitFactory.creatApple();

        Fruit banana = FruitFactory.creatBanana();

        apple.description();

        banana.description();

    }
}
