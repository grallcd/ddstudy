package com.ddstudy.app.a34;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.function.*;
import org.springframework.web.servlet.function.support.HandlerFunctionAdapter;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;

/**
 * @author grallcd
 * @since 2022/4/21
 */
@Configuration
public class WebConfig {

    @Bean
    public TomcatServletWebServerFactory servletWebServerFactory(){
        return new TomcatServletWebServerFactory(8080);
    }

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }

    @Bean
    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(DispatcherServlet dispatcherServlet){
        return new DispatcherServletRegistrationBean(dispatcherServlet, "/");
    }

    @Bean
    public RouterFunctionMapping routerFunctionMapping(){
        return new RouterFunctionMapping();
    }

    @Bean
    public HandlerFunctionAdapter handlerFunctionAdapter(){
        return new HandlerFunctionAdapter();
    }

    @Bean
    public RouterFunction<ServerResponse> r1(){
        return RouterFunctions.route(RequestPredicates.GET("/r1"), request -> ServerResponse.ok().body("this is r1"));
    }

    @Bean
    public RouterFunction<ServerResponse> r2(){
        return RouterFunctions.route(RequestPredicates.GET("/r2"), request -> ServerResponse.ok().body("this is r2"));
    }
}
