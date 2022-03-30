package com.ddstudy.app.a08;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author grallcd
 * @since 2022/3/30
 */
@Scope("request")
@Component
@Slf4j
public class BeanForRequest {

    @PreDestroy
    public void destroy(){
        log.info("destroy...");
    }
}
