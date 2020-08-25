package com.ddstudy.decorator;


import org.junit.jupiter.api.Test;

/**
 * @Classname DecoratorTest
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class DecoratorTest {

    @Test
    public void testDecorator(){

        Drink sugarMilk = new Sugar(new Milk());
        System.out.println(sugarMilk.composition());

        Drink sugarPearlMilk = new Pearl(new Sugar(new Milk()));
        System.out.println(sugarPearlMilk.composition());

    }
}
