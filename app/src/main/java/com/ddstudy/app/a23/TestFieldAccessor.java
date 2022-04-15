package com.ddstudy.app.a23;

import lombok.ToString;
import org.springframework.beans.DirectFieldAccessor;

import java.util.Date;

/**
 * @author grallcd
 * @since 2022/4/15
 */
public class TestFieldAccessor {

    public static void main(String[] args) {

        // 利用反射，直接给字段赋值
        Bean bean = new Bean();
        DirectFieldAccessor fieldAccessor = new DirectFieldAccessor(bean);

        fieldAccessor.setPropertyValue("a",10);
        fieldAccessor.setPropertyValue("b","hello");
        fieldAccessor.setPropertyValue("c",new Date());

        System.out.println(bean);


    }

    @ToString
    static class Bean{
        private int a;

        private String b;

        private Date c;

    }
}
