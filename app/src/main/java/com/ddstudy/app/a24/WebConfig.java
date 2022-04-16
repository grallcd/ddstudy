package com.ddstudy.app.a24;

import com.ddstudy.app.a23.MyDateTimeFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author grallcd
 * @since 2022/4/16
 */
@Configuration
public class WebConfig {

    @ControllerAdvice
    static class MyControllerAdvice {
        @InitBinder
        public void binder3(WebDataBinder webDataBinder) {
            webDataBinder.addCustomFormatter(new MyDateTimeFormatter("binder3 转换器"));
        }
    }

    @Controller
    static class Controller1 {

        @InitBinder
        public void binder1(WebDataBinder webDataBinder) {
            webDataBinder.addCustomFormatter(new MyDateTimeFormatter("binder1 转换器"));
        }

        public void foo() {

        }

    }

    @Controller
    static class Controller2 {

        @InitBinder
        public void binder21(WebDataBinder webDataBinder) {
            webDataBinder.addCustomFormatter(new MyDateTimeFormatter("binder21 转换器"));
        }

        @InitBinder
        public void binder22(WebDataBinder webDataBinder) {
            webDataBinder.addCustomFormatter(new MyDateTimeFormatter("binder22 转换器"));
        }

        public void bar() {

        }

    }
}
