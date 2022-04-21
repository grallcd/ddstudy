package com.ddstudy.app.a33;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

/**
 * @author grallcd
 * @since 2022/4/21
 */
public class A33 {

    public static void main(String[] args) {

        /*
            a. BeanNameUrlHandlerMapping, 以 / 开头的 bean 的名字会被当作映射路径
            b. 这些 bean 本身当作 handler, 要求实现 Controller 接口
            c. SimpleControllerHandlerAdapter, 调用 handler
         */
        AnnotationConfigServletWebServerApplicationContext context = new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
    }
}
