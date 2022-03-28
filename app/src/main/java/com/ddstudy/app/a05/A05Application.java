package com.ddstudy.app.a05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author grallcd
 * @since 2022/3/25
 */
@Slf4j
public class A05Application {

    public static void main(String[] args) throws IOException {
        GenericApplicationContext context = new GenericApplicationContext();

        context.registerBean("config", Config.class);
        // context.registerBean(ConfigurationClassPostProcessor.class); // @ComponentScan @Bean @Import @ImportResource
        // context.registerBean(MapperScannerConfigurer.class,
        //         bd -> bd.getPropertyValues().add("basePackage", "com.ddstudy.app.a05.mapper")
        // ); // @MapperScan

        // context.registerBean(ComponentScanPostProcessor.class);

        context.registerBean(AtBeanPostProcessor.class); // 解析 @Bean

        context.registerBean(MapperPostProcessor.class); // @MapperScan

        // 初始化容器
        context.refresh();

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        // 销毁容器
        context.close();
    }
}
