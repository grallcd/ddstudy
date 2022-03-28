package com.ddstudy.app.a06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author grallcd
 * @since 2022/3/28
 */
@Slf4j
@Configuration
public class MyConfig1 {

    @Autowired
    public void setApplicationContext(ApplicationContext context) {
        log.info("注入 ApplicationContext :{}", context);
    }

    @PostConstruct
    public void init(){
        log.info("初始化...");
    }

    @Bean
    public BeanFactoryPostProcessor processor1() {
        return beanFactory -> {
            log.info("processor1...");
        };
    }

}
