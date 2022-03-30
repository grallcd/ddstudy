package com.ddstudy.app.a08;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author grallcd
 * @since 2022/3/30
 */
@Scope("application")
@Component
@Slf4j
public class BeanForApplication {

    @PreDestroy
    public void destroy() {
        log.info("destroy...");
    }
}
