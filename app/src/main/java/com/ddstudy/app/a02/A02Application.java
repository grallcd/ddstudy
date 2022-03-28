package com.ddstudy.app.a02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.Controller;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author grallcd
 * @since 2022/3/24
 */
@Slf4j
public class A02Application {

    public static void main(String[] args) {
        testXmlApplicationContext();
        // testFileSystemXmlApplicationContext();
        // testAnnotationConfigApplicationContext();
        // testAnnotationConfigServletWebServerApplicationContext();
    }


    public static void testBeanDefinitionReader() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // reader.loadBeanDefinitions(new ClassPathResource("a02Config.xml")); //基于类路径
        reader.loadBeanDefinitions(new FileSystemResource("src/main/resources/a02Config.xml")); // 基于磁盘路径
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
    }

    /**
     * 基于 classpath 下 xml 格式的配置文件
     */
    public static void testXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("a02Config.xml");
        logBeans(context);
    }

    /**
     * 基于磁盘路径下的 xml 配置文件
     */
    public static void testFileSystemXmlApplicationContext() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/test/resources/config.xml");
        logBeans(context);
    }

    /**
     * 基于 java 配置类
     */

    public static void testAnnotationConfigApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        logBeans(context);
    }


    /**
     * 内嵌容器、注册 DispatcherServlet
     */
    public static void testAnnotationConfigServletWebServerApplicationContext() {
        AnnotationConfigServletWebServerApplicationContext context = new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
        logBeans(context);
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    /**
     * 打印 beanDefinition 信息
     *
     * @param context
     */
    private static void logBeans(ApplicationContext context) {
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Configuration
    static class WebConfig {
        @Bean
        public ServletWebServerFactory servletWebServerFactory() {
            return new TomcatServletWebServerFactory();
        }

        @Bean
        public DispatcherServlet dispatcherServlet() {
            return new DispatcherServlet();
        }

        @Bean
        public DispatcherServletRegistrationBean registrationBean() {
            return new DispatcherServletRegistrationBean(dispatcherServlet(), "/");
        }

        @Bean("/hello")
        public Controller controller() {
            return (request, response) -> {
                response.getWriter().write("hello");
                return null;
            };
        }


    }

    @Configuration
    static class Config {

        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            Bean2 bean2 = new Bean2();
            bean2.setBean1(bean1());
            return bean2;
        }

    }

    static class Bean1 {

    }

    static class Bean2 {

        private Bean1 bean1;

        public Bean1 getBean1() {
            return bean1;
        }

        public void setBean1(Bean1 bean1) {
            this.bean1 = bean1;
        }
    }
}
