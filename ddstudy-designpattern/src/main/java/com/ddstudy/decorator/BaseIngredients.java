package com.ddstudy.decorator;

/**
 * @Classname Ingredients
 * @Description 抽象的装饰对象：配料
 * @Date 2020/6/18
 * @Author Grain Rain
 */
public abstract class BaseIngredients implements Drink {

    Drink drink;

    public BaseIngredients(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String composition() {
        return drink.composition();
    }
}
