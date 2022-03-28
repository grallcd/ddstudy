package com.ddstudy.app.a04;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author grallcd
 * @since 2022/3/25
 */
@Data
@ConfigurationProperties(prefix = "java")
public class Bean4 {

    private String home;

    private String version;

}
