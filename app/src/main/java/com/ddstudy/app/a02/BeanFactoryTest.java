package com.ddstudy.app.a02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author grallcd
 * @since 2022/3/24
 */
public class BeanFactoryTest {


    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // bean 定义（class、scope）
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();

        // 注册 beanDefinition
        beanFactory.registerBeanDefinition("config", beanDefinition);
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);

        // 添加 beanFactory 的后置处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);

        // 拿到所有的 beanFactory 后置处理器 并进行处理
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(beanFactoryPostProcessor -> {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        });
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);

        // bean后置处理器，针对 bean 的生命周期的各个阶段提供扩展，例如 @Autowired、@Resource
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().forEach(beanFactory::addBeanPostProcessor);

        beanFactory.preInstantiateSingletons();
        System.out.println("》》》》》》》》》》》》》》》》");

        System.out.println(beanFactory.getBean(Bean1.class).getBean2());

    }

    @Configuration
    static class Config {
        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }

    }


    static class Bean1 {

        private static final Logger log = LoggerFactory.getLogger(Bean1.class);


        public Bean1() {
            log.info("构造 bean1...");
        }

        @Autowired
        private Bean2 bean2;

        public Bean2 getBean2() {
            return bean2;
        }
    }

    static class Bean2 {
        private static final Logger log = LoggerFactory.getLogger(Bean2.class);


        public Bean2() {
            log.info("构造 bean2...");
        }
    }
}
