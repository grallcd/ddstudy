package com.ddstudy.app.a05.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

/**
 * @author grallcd
 * @since 2022/3/25
 */
@Slf4j
@Controller
public class Bean3 {

    public Bean3() {
        log.debug("我被 Spring 管理啦...");
    }
}
