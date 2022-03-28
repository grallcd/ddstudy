package com.ddstudy.app.a06;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author grallcd
 * @since 2022/3/28
 */
public class A06Application {

    public static void main(String[] args) {

        GenericApplicationContext context = new GenericApplicationContext();

        // context.registerBean("myBean", MyBean.class);

        // context.registerBean("myConfig1", MyConfig1.class);

        context.registerBean("myConfig2", MyConfig2.class);

        // @Autowired 的解析需要用到 Bean 的后置处理器，属于扩展功能
        // aware 接口属于内置功能，不加任何扩展，Spring 就能识别
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        context.registerBean(CommonAnnotationBeanPostProcessor.class);
        context.registerBean(ConfigurationClassPostProcessor.class);

        /**
         * 1. beanFactory 后置处理器
         * 2. 添加 bean 后置处理器
         * 3. 初始化单例
         */
        context.refresh();

        context.close();

    }
}
