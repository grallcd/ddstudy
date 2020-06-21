package com.ddstudy.factorymethod;

/**
 * @Classname TShirt
 * @Description 具体衣服：T恤
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class TShirt implements Clothes {
    @Override
    public void type() {
        System.out.println("This is a T-Shirt");
    }
}
