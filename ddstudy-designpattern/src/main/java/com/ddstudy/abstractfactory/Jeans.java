package com.ddstudy.abstractfactory;

/**
 * @Classname Jeans
 * @Description 具体裤子：牛仔裤
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class Jeans implements Trousers {
    @Override
    public void type() {
        System.out.println("This is a jeans");
    }
}
