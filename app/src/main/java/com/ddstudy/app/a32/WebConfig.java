package com.ddstudy.app.a32;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistrarBeanPostProcessor;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author grallcd
 * @since 2022/4/20
 */
@Configuration
public class WebConfig {

    @Bean
    public TomcatServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public DispatcherServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        DispatcherServletRegistrationBean registrationBean = new DispatcherServletRegistrationBean(dispatcherServlet, "/");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
        handlerAdapter.setMessageConverters(Stream.of(new MappingJackson2HttpMessageConverter()).collect(Collectors.toList()));
        return handlerAdapter;
    }

    // 出现错误，会使用请求转发 forward 跳转到 error 地址
    @Bean
    public ErrorPageRegistrar errorPageRegistrar() {
        return registry -> {
            registry.addErrorPages(new ErrorPage("/error"));
        };
    }

    @Bean
    public ErrorPageRegistrarBeanPostProcessor errorPageRegistrarBeanPostProcessor() {
        return new ErrorPageRegistrarBeanPostProcessor();
    }

    @Controller
    public static class MyController {
        @RequestMapping("test")
        public ModelAndView test() {
            int i = 1 / 0;
            return null;
        }

        /*@RequestMapping("/error")
        @ResponseBody
        public Map<String, Object> error(HttpServletRequest request) {
            Throwable e = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
            return new HashMap<String, Object>() {{
                put("error", e.getMessage());
            }};
        }*/
    }

    @Bean
    public BasicErrorController basicErrorController(){
        ErrorProperties errorProperties = new ErrorProperties();
        errorProperties.setIncludeException(true);
        return new BasicErrorController(new DefaultErrorAttributes(), errorProperties);
    }

    @Bean
    public View error(){
        return (model, request, response) -> {
            System.out.println(model);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("<h3>服务器内部错误</h3>");
        };
    }

    @Bean
    public ViewResolver viewResolver(){
        return new BeanNameViewResolver();
    }
}
