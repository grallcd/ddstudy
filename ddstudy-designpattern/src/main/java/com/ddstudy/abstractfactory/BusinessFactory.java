package com.ddstudy.abstractfactory;

/**
 * @Classname BusinessFactory
 * @Description TODO
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class BusinessFactory implements AbstractFactory {
    @Override
    public BusinessSuit businessFactory() {
        return null;
    }

    @Override
    public CasualSuit casualFactory() {
        return null;
    }
}
