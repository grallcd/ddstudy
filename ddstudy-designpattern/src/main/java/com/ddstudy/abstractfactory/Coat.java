package com.ddstudy.abstractfactory;

/**
 * @Classname Coat
 * @Description 具体衣服：风衣
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class Coat implements Clothes {
    @Override
    public void style() {
        System.out.println("This is a coat");
    }
}
