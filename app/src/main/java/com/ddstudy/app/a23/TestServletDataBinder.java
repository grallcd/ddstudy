package com.ddstudy.app.a23;

import lombok.Data;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;

import java.util.Date;

/**
 * @author grallcd
 * @since 2022/4/15
 */
public class TestServletDataBinder {

    public static void main(String[] args) {

        Bean bean = new Bean();

        // web 环境下执行数据绑定
        ServletRequestDataBinder dataBinder = new ServletRequestDataBinder(bean);
        MockHttpServletRequest request = new MockHttpServletRequest();

        request.setParameter("a", "10");
        request.setParameter("b", "hello");
        request.setParameter("c", "2022/04/15");

        dataBinder.bind(new ServletRequestParameterPropertyValues(request));
        System.out.println(bean);

    }

    @Data
    static class Bean {
        private int a;

        private String b;

        private Date c;

    }
}
