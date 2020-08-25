package com.ddstudy.interpreter;

import java.util.Stack;

/**
 * @Classname Calculator
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public class Calculator {

    private Stack<Expression> stack = new Stack<>();


    public Calculator(String expression) {
        this.analyse(expression);
    }

    private void analyse(String expression) {
        String[] elements = expression.split(" ");
        Expression left, right;

        for (int i = 0, len = elements.length; i < len; i++) {

            switch (elements[i]) {
                case "+":
                    left = this.stack.pop();
                    right = new NumExpression(Integer.parseInt(elements[++i]));
                    this.stack.push(new AddExpression(left, right));
                    break;
                case "-":
                    left = this.stack.pop();
                    right = new NumExpression(Integer.parseInt(elements[++i]));
                    this.stack.push(new SubtractionExpression(left, right));
                    break;
                default:
                    this.stack.push(new NumExpression(Integer.parseInt(elements[i])));
                    break;
            }
        }
    }

    public int calculate(){
        return this.stack.pop().interpret();
    }
}
