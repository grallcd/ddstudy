package com.ddstudy.abstractfactory;

/**
 * @Classname StyleBFactory
 * @Description 具体工厂B：生产B类风格的衣服裤子
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class StyleBFactory implements AbstractFactory {
    @Override
    public Clothes createClothes() {
        return new Coat();
    }

    @Override
    public Trousers createTrousers() {
        return new Skirt();
    }
}
