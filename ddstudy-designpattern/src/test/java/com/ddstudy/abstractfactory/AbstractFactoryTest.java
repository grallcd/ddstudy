package com.ddstudy.abstractfactory;

import org.junit.jupiter.api.Test;

/**
 * @Classname AbstractFactoryTest
 * @Description TODO
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class AbstractFactoryTest {

    @Test
    void testAbstractFactory() {

        StyleAFactory aFactory = new StyleAFactory();
        StyleBFactory bFactory = new StyleBFactory();

        Clothes clothesA = aFactory.createClothes();
        Trousers trousersA = aFactory.createTrousers();

        Clothes clothesB = bFactory.createClothes();
        Trousers trousersB = bFactory.createTrousers();

        clothesA.style();
        trousersA.type();

        clothesB.style();
        trousersB.type();
    }
}
