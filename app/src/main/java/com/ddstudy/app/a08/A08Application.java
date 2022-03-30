package com.ddstudy.app.a08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author grallcd
 * @since 2022/3/30
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class A08Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A08Application.class, args);
    }

}
