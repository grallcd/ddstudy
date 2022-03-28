package com.ddstudy.app.a04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.core.env.StandardEnvironment;

import java.lang.reflect.Method;

/**
 * @author grallcd
 * @since 2022/3/25
 */
@Slf4j
public class DigInAutowired {

    public static void main(String[] args) throws Throwable {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建、依赖注入、初始化
        beanFactory.registerSingleton("bean2", new Bean2());
        beanFactory.registerSingleton("bean3", new Bean3());

        beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver()); // @Value
        beanFactory.addEmbeddedValueResolver(new StandardEnvironment()::resolvePlaceholders); // ${} 解析器

        // 查找哪些属性、方法加了 @Autowired ，称之为 InjectionMetaData
        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
        processor.setBeanFactory(beanFactory);

        Bean1 bean1 = new Bean1();
        // log.info("bean1:{}", bean1);
        processor.postProcessProperties(null, bean1, "bean1");
        // log.info("bean1:{}", bean1);


        Method findAutowiringMetadata = AutowiredAnnotationBeanPostProcessor.class.getDeclaredMethod("findAutowiringMetadata", String.class, Class.class, PropertyValues.class);
        findAutowiringMetadata.setAccessible(true);
        InjectionMetadata metadata = (InjectionMetadata) findAutowiringMetadata.invoke(processor, "bean1", Bean1.class, null);

        System.out.println(metadata);

        // 调用 InjectionMetaData 来进行依赖注入，注入时按类型来查找值
        metadata.inject(bean1, "bean1", null);
        log.info("bean1:{}", bean1);


    }

}
