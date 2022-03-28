package com.ddstudy.app.a05;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

/**
 * @author grallcd
 * @since 2022/3/25
 */
@Slf4j
public class ComponentScanPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            ComponentScan componentScan = AnnotationUtils.findAnnotation(Config.class, ComponentScan.class);
            if (componentScan != null) {
                // 输出包名
                String[] basePackages = componentScan.basePackages();
                // Arrays.stream(basePackages).forEach(System.out::println);

                // com.ddstudy.app.a05.component --> classpath*:com/ddstudy/app/a05/component/**/*.class
                for (String basePackage : basePackages) {
                    String path = "classpath*:" + basePackage.replace(".", "/") + "/**/*.class";
                    // System.out.println("路径: " + path);

                    CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();
                    Resource[] resources = new PathMatchingResourcePatternResolver().getResources(path);
                    AnnotationBeanNameGenerator beanNameGenerator = AnnotationBeanNameGenerator.INSTANCE;

                    for (Resource resource : resources) {
                        MetadataReader reader = factory.getMetadataReader(resource);
                        String className = reader.getClassMetadata().getClassName();
                        // System.out.println("类名：" + className);
                        AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();

                        boolean hasComponent = annotationMetadata.hasAnnotation(Component.class.getName());
                        // System.out.println("是否加了 @Component: " + hasComponent);

                        boolean hasDerivedComponent = annotationMetadata.hasMetaAnnotation(Component.class.getName());
                        // System.out.println("是否加了 @Component 派生注解: " + hasDerivedComponent);

                        if (hasComponent || hasDerivedComponent) {
                            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(className).getBeanDefinition();
                            if (beanFactory instanceof DefaultListableBeanFactory) {
                                DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
                                String beanName = beanNameGenerator.generateBeanName(beanDefinition, defaultListableBeanFactory);

                                // System.out.println("beanName: " + beanName);
                                (defaultListableBeanFactory).registerBeanDefinition(beanName, beanDefinition);
                            }

                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("解析异常...", e);
        }
    }
}
