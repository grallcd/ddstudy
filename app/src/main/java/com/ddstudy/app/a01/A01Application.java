package com.ddstudy.app.a01;

import com.ddstudy.app.a01.config.Component1;
import com.ddstudy.app.a01.config.UserRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;


@SpringBootApplication
public class A01Application {

    private static final Logger log = LoggerFactory.getLogger(A01Application.class);

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        ConfigurableApplicationContext context = SpringApplication.run(A01Application.class, args);
        log.info("context:{}", context);

        Field filed = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        filed.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>) filed.get(beanFactory);
        map.entrySet().stream().filter(e -> e.getKey().startsWith("component")).forEach(entry ->
                log.info("key:{}---value:{}", entry.getKey(), entry.getValue()));

        // 消息国际化
        log.info("zh:{}",context.getMessage("hi",null, Locale.CHINA));
        log.info("ja:{}",context.getMessage("hi",null, Locale.JAPAN));
        log.info("en:{}",context.getMessage("hi",null, Locale.ENGLISH));

        // 资源统一处理
        Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
        Arrays.stream(resources).forEach(System.out::println);

        // 系统环境
        log.info("port:{}", context.getEnvironment().getProperty("server.port"));
        log.info("java_home:{}", context.getEnvironment().getProperty("java_home"));

        // 事件发布
        context.publishEvent(new UserRegisterEvent(context));
        context.getBean(Component1.class).register();

    }

}
