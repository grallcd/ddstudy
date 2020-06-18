package com.ddstudy.decorator;

/**
 * @Classname Pearl
 * @Description TODO
 * @Date 2020/6/18
 * @Author Grain Rain
 */
public class Pearl extends Ingredients{

    Drinks drinks;

    public Pearl(Drinks drinks) {
        this.drinks = drinks;
    }

    @Override
    public String composition() {
        return drinks.composition()+"Pearl";
    }
}
