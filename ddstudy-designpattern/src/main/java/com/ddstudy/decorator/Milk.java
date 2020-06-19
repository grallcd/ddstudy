package com.ddstudy.decorator;

/**
 * @Classname Milk
 * @Description 具体的饮品对象：牛奶
 * 可以给牛奶加上一些配料，变成不同口味的饮品，即
 * 给原有的类添加一些行为或特征作为装饰
 * @Date 2020/6/18
 * @Author Grain Rain
 */
public class Milk implements Drink{

    @Override
    public String composition() {
        return "Milk";
    }
}
