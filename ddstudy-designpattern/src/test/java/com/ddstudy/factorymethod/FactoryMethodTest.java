package com.ddstudy.factorymethod;

import org.junit.jupiter.api.Test;

/**
 * @Classname FactoryMethodTest
 * @Description TODO
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class FactoryMethodTest {

    @Test
    void testFactoryMethod() {

        FactoryA factoryA = new FactoryA();
        FactoryB factoryB = new FactoryB();

        Clothes clothesA = factoryA.createClothes();
        Clothes clothesB = factoryB.createClothes();

        clothesA.type();
        clothesB.type();

    }
}
