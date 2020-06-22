package com.ddstudy.reflect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Classname ClassTest
 * @Description Class对象测试类
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class ClassTest {

    private static Class<Coder> clazz;

    @BeforeAll
    public static void testInit() {
        clazz = Coder.class;
    }

    @Test
    public void testGetClass() throws ClassNotFoundException {

        //1.通过 类名.class 获取Class对象
        Class<?> clazz1 = Coder.class;

        //2.通过 实例.getClass() 获取Class对象
        Coder coder = new Coder();
        Class<? extends Coder> clazz2 = coder.getClass();

        //3.通过 Class.forName(全路径名) 获取Class对象
        Class<?> clazz3 = Class.forName("com.ddstudy.reflect.Coder");

        Assertions.assertSame(clazz1, clazz2, "这两个class对象不同");
        Assertions.assertSame(clazz2, clazz3, "这两个class对象不同");

    }

    /**
     * 利用反射获取字段
     */
    @Test
    public void testGetField() throws NoSuchFieldException {

        //getField()只能获取到继承public和自身public修饰的属性
        //getDeclaredField()可以获取到自身所有的属性
        Assertions.assertThrows(NoSuchFieldException.class, () -> clazz.getField("name"));
        Assertions.assertThrows(NoSuchFieldException.class, () -> clazz.getField("age"));
        Assertions.assertDoesNotThrow(() -> clazz.getField("description"));
        Assertions.assertThrows(NoSuchFieldException.class, () -> clazz.getField("salary"));

        //获取对应字段
        Field declaredField = clazz.getDeclaredField("name");

        //获取public修饰的对应字段
        Field field = clazz.getField("description");

        //获取所有字段
        Field[] declaredFields = clazz.getDeclaredFields();

        //获取public修饰的所有字段
        Field[] fields = clazz.getFields();

    }

    /**
     * 利用反射获取方法
     */
    @Test
    public void testGetMethod() throws NoSuchMethodException {

        //getMethod同Field
        Assertions.assertThrows(NoSuchMethodException.class, () -> clazz.getMethod("message", String.class));
        Assertions.assertDoesNotThrow(() -> clazz.getMethod("say"));

        //获取对应名字的public方法，
        Method method = clazz.getMethod("say");

        //获取对应名字的方法，可以private修饰
        Method declaredMethod = clazz.getDeclaredMethod("message", String.class);

        //获取所有public修饰的方法
        Method[] methods = clazz.getMethods();

        //获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();

    }

    /**
     * 利用反射获取注解
     */
    @Test
    public void testGetAnnotation() {

        //获取类对应的注解
        Value declaredAnnotation = clazz.getDeclaredAnnotation(Value.class);
        Value annotation = clazz.getAnnotation(Value.class);

        Annotation[] annotations = clazz.getAnnotations();
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();


    }

    @Test
    public void testGetConstructor() {

        //获取该类所有public构造器
        Constructor<?>[] constructors = clazz.getConstructors();

        //获取该类所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();




    }
}
