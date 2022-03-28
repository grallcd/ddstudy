package com.ddstudy.app.a06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * @author grallcd
 * @since 2022/3/28
 */
@Slf4j
public class MyBean implements BeanNameAware, ApplicationContextAware, InitializingBean {

    @Override
    public void setBeanName(String name) {
        log.info("Bean:{},name:{}", this, name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("Bean:{},applicationContext:{}", this, applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("实现 InitializingBean 接口初始化...");
    }

    @Autowired
    public void aaa(ApplicationContext context){

        log.info("使用 @Autowired 注入:{}", context);
    }

    @PostConstruct
    public void init(){
        log.info("使用 @PostConstruct 初始化...");
    }


}
