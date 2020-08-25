package com.ddstudy.abstractfactory;

/**
 * @Classname TShirt
 * @Description 具体衣服：T恤
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class TShirt implements Clothes {
    @Override
    public void style() {
        System.out.println("This is a T-Shirt");
    }
}
