package com.ddstudy.app.a03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author grallcd
 * @since 2022/3/26
 */
@Slf4j
@Component
public class LifeCycleBean {

    public LifeCycleBean() {
        log.info("构造方法...");
    }

    @Autowired
    public void autowired(@Value("${JAVA_HOME}") String home) {
        log.info("依赖注入 home:{}", home);
    }

    @PostConstruct
    public void init() {
        log.info("初始化...");
    }

    @PreDestroy
    public void destroy() {
        log.info("销毁...");
    }
}
