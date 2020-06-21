package com.ddstudy.abstractfactory;

/**
 * @Classname ClothesFactory
 * @Description 具体工厂A:生产A类风格的衣服裤子
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class StyleAFactory implements AbstractFactory {
    @Override
    public Clothes createClothes() {
        return new TShirt();
    }

    @Override
    public Trousers createTrousers() {
        return new Jeans();
    }
}
