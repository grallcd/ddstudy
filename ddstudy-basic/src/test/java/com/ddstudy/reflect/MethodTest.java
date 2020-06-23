package com.ddstudy.reflect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @Classname MethodTest
 * @Description TODO
 * @Date 2020/6/23
 * @Author Grain Rain
 */
public class MethodTest {

    private static Class<Coder> clazz;


    @BeforeAll
    public static void initClass() {
        clazz = Coder.class;
    }

    @Test
    void testMethod() throws NoSuchMethodException {

        //获取public 指定方法
        Method sayMethod = clazz.getMethod("say");

        //获取指定方法
        Method message = clazz.getDeclaredMethod("message", String.class);

        //获取方法放回类型,返回Class 对象
        Class<?> returnType = message.getReturnType();
        System.out.println(returnType);

        //获取方法的返回类型，返回Type对象
        Type genericReturnType = message.getGenericReturnType();
        System.out.println(genericReturnType.getTypeName());

        //获取方法的修饰值
        //private修饰，为2
        int modifiers = message.getModifiers();
        Assertions.assertEquals(2,modifiers);


        //获取方法参数数量
        int parameterCount = message.getParameterCount();
        Assertions.assertEquals(1,parameterCount);

        
    }

}
