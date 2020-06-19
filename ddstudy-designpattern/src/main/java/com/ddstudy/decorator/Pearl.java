package com.ddstudy.decorator;

/**
 * @Classname Pearl
 * @Description 装饰对象：珍珠
 * @Date 2020/6/18
 * @Author Grain Rain
 */
public class Pearl extends Ingredients {


    public Pearl(Drink drink) {
        super(drink);
    }

    @Override
    public String composition() {
        return drink.composition() + " + Pearl";
    }
}
