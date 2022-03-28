package com.ddstudy.app.a06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author grallcd
 * @since 2022/3/28
 */
@Slf4j
@Configuration
public class MyConfig2 implements InitializingBean, ApplicationContextAware {
    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("初始化...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("注入 ApplicationContext :{}", applicationContext);

    }

    @Bean
    public BeanFactoryPostProcessor processor2() {
        return beanFactory -> {
            log.info("processor2...");
        };
    }
}
