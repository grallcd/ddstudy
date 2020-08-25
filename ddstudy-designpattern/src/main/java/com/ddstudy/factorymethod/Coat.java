package com.ddstudy.factorymethod;

/**
 * @Classname Skirt
 * @Description 具体衣服：coat
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class Coat implements Clothes {
    @Override
    public void type() {
        System.out.println("This is a coat");
    }
}
