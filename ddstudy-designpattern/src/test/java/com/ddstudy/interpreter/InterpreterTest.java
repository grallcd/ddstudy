package com.ddstudy.interpreter;

import org.junit.jupiter.api.Test;

/**
 * @Classname InterpreterTest
 * @Description TODO
 * @Date 2020/7/28
 * @Author Grain Rain
 */
public class InterpreterTest {

    @Test
    void testInterpreter(){

        String expression = "1 + 2 - 3 * 2";
        Calculator calculator = new Calculator(expression);

        int result = calculator.calculate();

        System.out.println(result);


    }
}
