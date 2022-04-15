package com.ddstudy.app.a22;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * 目标：如何获取参数名（手动 javac 编译 Bean2.java 后，将 Bean2.class 复制到 target 对应目录下）
 * 1. Spring Boot 在编译时会加 -parameters (反编译可看到多了 MethodParameters 参数名信息，可通过反射获取该信息)
 * 2. 大部分 IDE 编译都会加 -g (反编译后，参数名信息会保存到 LocalVariableTable 中，无法通过反射获取，可通过 ASM 获取)
 *
 * @author grallcd
 * @since 2022/4/15
 */
public class A22 {

    public static void main(String[] args) throws NoSuchMethodException {

        // 1. 反射获取参数名
        Method method = Bean2.class.getMethod("foo", String.class, int.class);
        Parameter[] parameters = method.getParameters();
        /*for (Parameter parameter : parameters) {
            // 如果是 javac -parameter，则可获取到参数名
            // 如果是 javac -g，获取不到参数名，输出的是 arg0、arg1
            System.out.println(parameter.getName());
        }*/

        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = discoverer.getParameterNames(method);
        String result = Arrays.toString(parameterNames);
        System.out.println(result);


    }
}
