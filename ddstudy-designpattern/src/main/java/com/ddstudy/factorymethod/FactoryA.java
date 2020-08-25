package com.ddstudy.factorymethod;

/**
 * @Classname FactoryA
 * @Description TODO
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class FactoryA extends AbstractFactory {
    @Override
    Clothes createClothes() {
        return new TShirt();
    }
}
