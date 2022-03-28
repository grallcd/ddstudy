package com.ddstudy.app.a05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

/**
 * @author grallcd
 * @since 2022/3/26
 */
public class AtBeanPostProcessor implements BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        try {
            CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();
            MetadataReader metadataReader = factory.getMetadataReader(new ClassPathResource("com/ddstudy/app/a05/Config.class"));

            Set<MethodMetadata> methods = metadataReader.getAnnotationMetadata().getAnnotatedMethods(Bean.class.getName());
            for (MethodMetadata method : methods) {
                String methodName = method.getMethodName();
                System.out.println("方法名: " + methodName);
                String initMethod = method.getAnnotationAttributes(Bean.class.getName()).get("initMethod").toString();

                BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
                if (initMethod.length() > 0) {
                    builder.setInitMethodName(initMethod);
                }
                AbstractBeanDefinition beanDefinition = builder.setFactoryMethodOnBean(methodName, "config").getBeanDefinition();
                builder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
                registry.registerBeanDefinition(methodName, beanDefinition);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
