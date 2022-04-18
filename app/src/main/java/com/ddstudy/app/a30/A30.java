package com.ddstudy.app.a30;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author grallcd
 * @since 2022/4/18
 */
public class A30 {

    public static void main(String[] args) throws NoSuchMethodException {
        ExceptionHandlerExceptionResolver resolver = new ExceptionHandlerExceptionResolver();
        resolver.setMessageConverters(Stream.of(new MappingJackson2HttpMessageConverter()).collect(Collectors.toList()));
        resolver.afterPropertiesSet();

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        // 1.测试 json
        // HandlerMethod handlerMethod = new HandlerMethod(new Controller1(), Controller1.class.getMethod("foo"));
        // Exception e = new ArithmeticException("被零除");
        // resolver.resolveException(request, response, handlerMethod, e);
        // System.out.println(new String(response.getContentAsByteArray(), StandardCharsets.UTF_8));

        // 2.测试 mav
        // HandlerMethod handlerMethod = new HandlerMethod(new Controller2(), Controller2.class.getMethod("foo"));
        // Exception e = new ArithmeticException("被零除");
        // ModelAndView mav = resolver.resolveException(request, response, handlerMethod, e);
        // System.out.println(mav.getModel());
        // System.out.println(mav.getViewName());

        // 3.测试嵌套异常
        // HandlerMethod handlerMethod = new HandlerMethod(new Controller3(), Controller3.class.getMethod("foo"));
        // Exception e = new Exception("e1", new RuntimeException("e2", new IOException("e3")));
        // resolver.resolveException(request, response, handlerMethod, e);
        // System.out.println(new String(response.getContentAsByteArray(), StandardCharsets.UTF_8));

        // 4.测试异常处理方法参数解析
        HandlerMethod handlerMethod = new HandlerMethod(new Controller4(), Controller4.class.getMethod("foo"));
        Exception e = new Exception("e1");
        resolver.resolveException(request, response, handlerMethod, e);
        System.out.println(new String(response.getContentAsByteArray(), StandardCharsets.UTF_8));


    }

    static class Controller1 {
        public void foo() {
        }

        @ExceptionHandler
        @ResponseBody
        public Map<String, Object> handle(ArithmeticException e) {
            return new HashMap<String, Object>() {{
                put("error", e.getMessage());
            }};
        }
    }

    static class Controller2 {
        public void foo() {
        }

        @ExceptionHandler
        public ModelAndView handle(ArithmeticException e) {
            return new ModelAndView("test2",
                    new HashMap<String, Object>() {{
                        put("error", e.getMessage());
                    }}
            );
        }
    }

    static class Controller3{
        public void foo(){

        }

        @ExceptionHandler
        @ResponseBody
        public Map<String, Object> handle(IOException e) {
            return new HashMap<String, Object>() {{
                put("error", e.getMessage());
            }};
        }
    }

    static class Controller4{
        public void foo(){}

        @ExceptionHandler
        @ResponseBody
        public Map<String, Object> handle(Exception e, HttpServletRequest request) {
            System.out.println(request);
            return new HashMap<String, Object>() {{
                put("error", e.getMessage());
            }};
        }
    }
}
