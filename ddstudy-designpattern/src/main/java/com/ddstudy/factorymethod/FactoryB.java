package com.ddstudy.factorymethod;

/**
 * @Classname FactoryB
 * @Description TODO
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class FactoryB extends AbstractFactory {
    @Override
    Clothes createClothes() {
        return new Coat();
    }

}
