package com.ddstudy.app.a04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author grallcd
 * @since 2022/3/25
 */
@Slf4j
public class A04Application {

    public static void main(String[] args) {

        // 干净的 bean 容器
        GenericApplicationContext context = new GenericApplicationContext();

        // 注册 bean
        context.registerBean("bean1", Bean1.class);
        context.registerBean("bean2", Bean2.class);
        context.registerBean("bean3", Bean3.class);
        context.registerBean("bean4", Bean4.class);

        context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);// @Autowired @Value

        context.registerBean(CommonAnnotationBeanPostProcessor.class);// @Resource @PostConstruct @PreDestroy

        ConfigurationPropertiesBindingPostProcessor.register(context); // @ConfigurationProperties

        // 初始化容器
        context.refresh(); // 执行 beanFactory 后置处理器，添加 bean 后置处理器，初始化所有单例

        log.info("bean4:{}",context.getBean(Bean4.class));

        // 销毁容器
        context.close();
    }
}
