package com.ddstudy.decorator;

/**
 * @Classname Milk
 * @Description 具体的牛奶对象
 * @Date 2020/6/18
 * @Author Grain Rain
 */
public class Milk implements Drink{

    @Override
    public String composition() {
        return "Milk";
    }
}
