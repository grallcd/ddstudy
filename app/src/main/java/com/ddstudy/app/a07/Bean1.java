package com.ddstudy.app.a07;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author grallcd
 * @since 2022/3/30
 */
@Slf4j
public class Bean1 implements InitializingBean {

    @PostConstruct
    public void init(){
        log.info("初始化1...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("初始化2...");
    }

    public void init3(){
        log.info("初始化3...");
    }
}
