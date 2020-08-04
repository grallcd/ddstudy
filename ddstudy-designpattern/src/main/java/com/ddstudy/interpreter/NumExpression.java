package com.ddstudy.interpreter;

/**
 * @Classname NumExpression
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public class NumExpression implements Expression {

    private int value;

    public NumExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }

}
