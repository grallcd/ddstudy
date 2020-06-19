package com.ddstudy.decorator;

/**
 * @Classname Sugar
 * @Description 装饰对象：糖
 * @Date 2020/6/18
 * @Author Grain Rain
 */

public class Sugar extends Ingredients {


    public Sugar(Drink drink) {
        super(drink);
    }


    @Override
    public String composition() {
        return drink.composition()+" + Sugar";
    }
}
