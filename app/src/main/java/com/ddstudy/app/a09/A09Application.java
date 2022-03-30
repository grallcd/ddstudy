package com.ddstudy.app.a09;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author grallcd
 * @since 2022/3/30
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class A09Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A09Application.class, args);

        E e = context.getBean(E.class);

        // 代理
        log.info("f1.class:{}", e.getF1().getClass());
        log.info("f1:{}", e.getF1());
        log.info("f1:{}", e.getF1());

        // 代理
        log.info("f2.class:{}", e.getF2().getClass());
        log.info("f2:{}", e.getF2());
        log.info("f2:{}", e.getF2());

        // 对象工厂
        log.info("f3:{}", e.getF3());
        log.info("f3:{}", e.getF3());

        // 通过 IOC 容器获取
        log.info("f4:{}", e.getF4());
        log.info("f4:{}", e.getF4());

        context.close();

    }

}
