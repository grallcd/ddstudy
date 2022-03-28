package com.ddstudy.app.a03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author grallcd
 * @since 2022/3/26
 */
@Slf4j
@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {


    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {

        if (Objects.equals(beanName, "lifeCycleBean")) {
            log.info("销毁之前执行...");
        }
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (Objects.equals(beanName, "lifeCycleBean")) {
            log.info("实例化之前执行...");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "lifeCycleBean")) {
            log.info("实例化之后执行...");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "lifeCycleBean")) {
            log.info("依赖注入阶段... 如 @Autowired、@Value、@Resource");
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "lifeCycleBean")) {
            log.info("初始化之前，此处返回的 bean 会替换原本的 bean... 如 @PostConstruct、@ConfigurationProperties");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "lifeCycleBean")) {
            log.info("初始化之后，此处返回的 bean 会替换原本的 bean... 可用作代理增强");
        }
        return bean;
    }
}
