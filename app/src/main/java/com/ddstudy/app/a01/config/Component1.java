package com.ddstudy.app.a01.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author grallcd
 * @since 2022/3/23
 */
@Component
public class Component1 {
    private static final Logger log = LoggerFactory.getLogger(Component1.class);

    @Autowired
    private ApplicationEventPublisher publisher;

    public void register() {

        log.info("用户注册...");
        publisher.publishEvent(new UserRegisterEvent(this));

    }

}
