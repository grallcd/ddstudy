package com.ddstudy.interpreter;

/**
 * @Classname AddExpression
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public abstract class OperatorExpression implements Expression {

    protected Expression left;

    protected Expression right;

    public OperatorExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
