package com.ddstudy.app.a23.sub;

import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author grallcd
 * @since 2022/4/15
 */
public class TestGenericType {

    public static void main(String[] args) {

        // 1. jdk API
        Type type = StudentDAO.class.getGenericSuperclass();
        System.out.println(type);

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] types = parameterizedType.getActualTypeArguments();
            System.out.println(types[0]);
        }

        // 2. Spring API
        Class<?> c = GenericTypeResolver.resolveTypeArgument(StudentDAO.class, BaseDAO.class);
        System.out.println(c);
    }
}
