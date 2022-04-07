package com.ddstudy.app.a19;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author grallcd
 * @since 2022/4/7
 */
public class A19 {

    @Aspect
    static class MyAspect {

        // 静态通知调用，不需参数绑定，执行时不需要切点
        @Before("execution(* foo(..))")
        public void before1() {
            System.out.println("MyAspect.before1");
        }

        // 动态通知调用，需要参数绑定，执行时还需要切点对象
        @Before("execution(* foo(..)) && args(x)")
        public void before2(int x) {
            System.out.printf("MyAspect.before2(%d)%n", x);
        }
    }

    static class Target {
        public void foo(int x) {
            System.out.printf("Target foo(%d)%n", x);
        }
    }

    @Configuration
    static class MyConfig {
        @Bean
        public AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator() {
            return new AnnotationAwareAspectJAutoProxyCreator();
        }

        @Bean
        public MyAspect myAspect() {
            return new MyAspect();
        }
    }

    public static void main(String[] args) throws Throwable {

        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(ConfigurationClassPostProcessor.class);
        context.registerBean(MyConfig.class);
        context.refresh();

        AnnotationAwareAspectJAutoProxyCreator creator = context.getBean(AnnotationAwareAspectJAutoProxyCreator.class);
        Method method1 = AbstractAdvisorAutoProxyCreator.class.getDeclaredMethod("findEligibleAdvisors", Class.class, String.class);
        method1.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<Advisor> advisors = (List<Advisor>) method1.invoke(creator, Target.class, "target");
        for (Advisor advisor : advisors) {
            System.out.println(advisor);
        }

        Target target = new Target();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvisors(advisors);
        Object proxy = factory.getProxy();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<Object> interceptors = factory.getInterceptorsAndDynamicInterceptionAdvice(Target.class.getMethod("foo", int.class), Target.class);
        for (Object interceptor : interceptors) {
            System.out.println(interceptor);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ReflectiveMethodInvocation invocation = new ReflectiveMethodInvocation(
                proxy, target, Target.class.getMethod("foo", int.class), new Object[]{100}, Target.class, interceptors) {};
        invocation.proceed();

    }
}
