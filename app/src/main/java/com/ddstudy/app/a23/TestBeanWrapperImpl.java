package com.ddstudy.app.a23;

import lombok.Data;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Date;

/**
 * @author grallcd
 * @since 2022/4/15
 */
public class TestBeanWrapperImpl {

    public static void main(String[] args) {

        // 利用反射，通过 set 方法为 bean 的属性赋值
        Bean bean = new Bean();
        BeanWrapperImpl wrapper = new BeanWrapperImpl(bean);
        wrapper.setPropertyValue("a",10);
        wrapper.setPropertyValue("b","hello");
        wrapper.setPropertyValue("c",new Date());

        System.out.println(bean);
    }

    @Data
    static class Bean{
        private int a;

        private String b;

        private Date c;

    }
}
