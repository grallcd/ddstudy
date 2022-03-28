package com.ddstudy.app.a05.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author grallcd
 * @since 2022/3/25
 */
@Slf4j
@Component
public class Bean2 {

    public Bean2() {
        log.debug("我被 Spring 管理啦...");
    }
}
