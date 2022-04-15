package com.ddstudy.app.a23;

import lombok.ToString;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

import java.util.Date;

/**
 * @author grallcd
 * @since 2022/4/15
 */
public class TestDataBinder {

    public static void main(String[] args) {

        Bean bean = new Bean();

        // 执行数据绑定
        DataBinder dataBinder = new DataBinder(bean);
        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.add("a", 10);
        mpv.add("b", "hello");
        mpv.add("c", new Date());

        dataBinder.initDirectFieldAccess();
        dataBinder.bind(mpv);

        System.out.println(bean);

    }

    // @Data
    @ToString
    static class Bean {
        private int a;

        private String b;

        private Date c;

    }
}
