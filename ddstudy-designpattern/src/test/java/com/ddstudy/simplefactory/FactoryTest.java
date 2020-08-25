package com.ddstudy.simplefactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Classname FactoryTest
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class FactoryTest {

    @Test
    void testFactory() {

        Fruit apple = FruitFactory.getFruit(FruitTypeEnum.APPLE);
        Fruit banana = FruitFactory.getFruit(FruitTypeEnum.BANANA);
        Fruit lemon = FruitFactory.getFruit(FruitTypeEnum.LEMON);

        apple.description();
        banana.description();
        lemon.description();
    }

    @Test
    void testFruitType(){

        FruitTypeEnum apple = FruitTypeEnum.APPLE;
        String name = apple.name();
        Assertions.assertEquals("APPLE",name);

        Fruit fruit = apple.get();
        Assertions.assertSame(Apple.class,fruit.getClass());

    }
}
