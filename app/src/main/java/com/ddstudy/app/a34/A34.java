package com.ddstudy.app.a34;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

/**
 * @author grallcd
 * @since 2022/4/21
 */
public class A34 {

    public static void main(String[] args) {

        /*
            函数式控制器：
            1. RouterFunctionMapping，通过 RequestPredicate 映射
            2. handler 要实现 HandlerFunction 接口
            3. HandlerFunctionAdapter,调用 handler
         */
        AnnotationConfigServletWebServerApplicationContext context = new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
    }
}
