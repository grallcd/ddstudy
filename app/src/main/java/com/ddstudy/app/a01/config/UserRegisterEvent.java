package com.ddstudy.app.a01.config;

import org.springframework.context.ApplicationEvent;

/**
 * @author grallcd
 * @since 2022/3/23
 */
public class UserRegisterEvent extends ApplicationEvent {

    public UserRegisterEvent(Object source) {
        super(source);
    }
}
