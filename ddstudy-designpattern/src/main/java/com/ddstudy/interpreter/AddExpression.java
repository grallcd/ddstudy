package com.ddstudy.interpreter;

/**
 * @Classname AddExpression
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public class AddExpression extends OperatorExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() + this.right.interpret();
    }
}
