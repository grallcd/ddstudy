package com.ddstudy.abstractfactory;

/**
 * @Classname Skirt
 * @Description 具体裤子：裙子
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class Skirt implements Trousers {
    @Override
    public void type() {
        System.out.println("This is a skirt");
    }
}
