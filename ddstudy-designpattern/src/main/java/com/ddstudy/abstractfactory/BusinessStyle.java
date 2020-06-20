package com.ddstudy.abstractfactory;

/**
 * @Classname BusinessStyle
 * @Description TODO
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class BusinessStyle implements Style {
    @Override
    public void type() {
        System.out.println("Business");
    }
}
