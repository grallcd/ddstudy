package com.ddstudy.app.a17;

import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author grallcd
 * @since 2022/4/6
 */
public class A17 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("aspect1", Aspect1.class);
        context.registerBean("config", Config.class);
        context.registerBean(ConfigurationClassPostProcessor.class);
        context.registerBean(AnnotationAwareAspectJAutoProxyCreator.class);

        context.refresh();

        // for (String name : context.getBeanDefinitionNames()) {
        //     System.out.println(name);
        // }

        // 找到有'资格'的 Advisors
        AnnotationAwareAspectJAutoProxyCreator creator = context.getBean(AnnotationAwareAspectJAutoProxyCreator.class);
        Method method1 = AbstractAdvisorAutoProxyCreator.class.getDeclaredMethod("findEligibleAdvisors", Class.class, String.class);
        method1.setAccessible(true);
        // List<Advisor> advisors = (List<Advisor>) method1.invoke(creator, Target1.class, "target1");
        @SuppressWarnings("unchecked")
        List<Advisor> advisors = (List<Advisor>) method1.invoke(creator, Target2.class, "target2");
        for (Advisor advisor : advisors) {
            System.out.println(advisor);
        }

        // 内部调用 findEligibleAdvisors,只要返回集合不为空，则表示需要创建代理
        Method method2 = AbstractAutoProxyCreator.class.getDeclaredMethod("wrapIfNecessary", Object.class, String.class, Object.class);
        method2.setAccessible(true);
        Object o1 = method2.invoke(creator, new Target1(), "target1", "target1");
        System.out.println(o1.getClass());
        Target1 target1 = (Target1) o1;
        target1.foo();


        Object o2 = method2.invoke(creator, new Target2(), "target2", "target2");
        System.out.println(o2.getClass());

    }

    static class Target1 {

        public void foo() {
            System.out.println("Target1.foo");
        }
    }

    static class Target2 {
        public void bar() {
            System.out.println("Target2.bar");
        }
    }

    @Aspect
    @Order(1)
    static class Aspect1 {

        @Before("execution(* foo())")
        public void before() {
            System.out.println("Aspect1 before...");
        }

        @After("execution(* foo())")
        public void after() {
            System.out.println("Aspect1 after...");
        }
    }

    @Configuration
    static class Config {

        @Bean
        public Advisor advisor3(MethodInterceptor advice3) {
            AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
            pointcut.setExpression("execution(* foo())");
            DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, advice3);
            advisor.setOrder(2);
            return advisor;
        }

        @Bean
        public MethodInterceptor advice3() {

            return invocation -> {
                System.out.println("advice3 before...");
                Object result = invocation.proceed();
                System.out.println("advice3 after...");
                return result;
            };
        }
    }
}
