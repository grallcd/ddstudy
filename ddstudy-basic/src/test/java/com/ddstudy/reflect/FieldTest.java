package com.ddstudy.reflect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @Classname ReflectTest
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class FieldTest {

    private static Class clazz;

    @BeforeAll
    public static void initClass() {
        clazz = Coder.class;
    }

    @Test
    public void testGetField() throws NoSuchFieldException {





        //获取字段名称
        Field field = clazz.getField("description");
        Field declaredField = clazz.getDeclaredField("age");
        Assertions.assertEquals("description", field.getName());
        Assertions.assertEquals("age", declaredField.getName());

        //获取字段类型，返回Class
        Class<?> type = field.getType();
        Assertions.assertEquals(type, String.class);

        //获取字段类型，返回Type
        Type type1 = field.getGenericType();
        Assertions.assertEquals(type1, String.class);

        //获取字段的修饰符，返回各修饰符相加得到的值，对应值为Modifier类的静态属性
        //因description为public，因此返回1
        int modifiers = field.getModifiers();
        Assertions.assertEquals(modifiers, 1);

        //获取对应的单个注解
        Value value = field.getAnnotation(Value.class);
        Assertions.assertEquals("hello", value.value());

        //获取所有注解
        Annotation[] annotations = field.getAnnotations();

    }

}
