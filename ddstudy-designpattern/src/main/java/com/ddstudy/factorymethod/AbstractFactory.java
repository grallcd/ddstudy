package com.ddstudy.factorymethod;


/**
 * @Classname AbstractFactory
 * @Description 工厂方法模式：相当于抽象工厂模式的特例
 * 内部只有一类产品
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public abstract class AbstractFactory {

    abstract Clothes createClothes();

}
