package com.ddstudy.app.a23;

import org.springframework.beans.SimpleTypeConverter;

import java.util.Date;

/**
 * @author grallcd
 * @since 2022/4/15
 */
public class TestSimpleConverter {

    public static void main(String[] args) {
        SimpleTypeConverter converter = new SimpleTypeConverter();
        Integer num = converter.convertIfNecessary("10", int.class);
        System.out.println(num);

        Date date = converter.convertIfNecessary("2022/04/15", Date.class);
        System.out.println(date);
    }
}
