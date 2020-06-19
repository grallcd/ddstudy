package com.ddstudy.decorator;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class Demo {

    public static void main(String[] args) {


        Drink sugarPearlMilk = new Sugar(new Pearl(new Milk()));

        Drink sugarMilk = new Sugar(new Milk());

        System.out.println(sugarPearlMilk.composition());

        System.out.println(sugarMilk.composition());


    }
}
