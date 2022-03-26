package com.ddstudy.app.a01.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author grallcd
 * @since 2022/3/23
 */
@Component
public class Component2 {
    private static final Logger log = LoggerFactory.getLogger(Component2.class);


    @EventListener
    public void receive(UserRegisterEvent event){

        log.info("receive event:{}", event);

    }
}
