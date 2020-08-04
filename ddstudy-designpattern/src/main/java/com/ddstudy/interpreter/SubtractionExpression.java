package com.ddstudy.interpreter;

/**
 * @Classname SubtractionExpression
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public class SubtractionExpression extends OperatorExpression {
    public SubtractionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() - this.right.interpret();
    }
}
