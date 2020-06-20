package com.ddstudy.abstractfactory;

/**
 * @Classname CasualStyle
 * @Description TODO
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class CasualStyle implements Style {
    @Override
    public void type() {
        System.out.println("Casual");
    }
}
