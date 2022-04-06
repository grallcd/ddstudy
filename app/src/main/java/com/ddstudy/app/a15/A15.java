package com.ddstudy.app.a15;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author grallcd
 * @since 2022/4/3
 */
@Slf4j
public class A15 {

    @Aspect
    static class MyAspect {

        @Before("execution(* foo())")
        public void before() {
            System.out.println("before...");
        }

        @After("execution(* bar())")
        public void after() {
            System.out.println("after...");
        }
    }

    public static void main(String[] args) {

        /**
         * 切面
         * aspect：
         *      通知1(advice) + 切点1(pointcut)
         *      通知2(advice) + 切点2(pointcut)
         *      通知3(advice) + 切点3(pointcut)
         * advisor:
         *      更细粒度的切面，包含一个通知和一个切点
         */

        // 1.备好切点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* foo())");
        // 2.备好通知
        MethodInterceptor advice = invocation -> {
            System.out.println("before...");
            Object result = invocation.proceed();
            System.out.println("after...");
            return result;
        };
        // 3.备好切面
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        /**
         * 4.创建代理
         *      a. proxyTargetClass = false, 目标实现了接口，用 jdk 实现
         *      b. proxyTargetClass = false, 目标没有实现接口，用 cglib 实现
         *      c. proxyTargetClass = true, 总是使用 cglib 实现
         */
        Target1 target = new Target1();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.setInterfaces(target.getClass().getInterfaces());
        factory.setProxyTargetClass(true);
        factory.addAdvisor(advisor);

        I1 proxy = (I1) factory.getProxy();
        log.info("proxy.class:{}", proxy.getClass());

        proxy.foo();
        proxy.bar();


    }

    interface I1 {

        void foo();

        void bar();
    }

    static class Target1 implements I1 {

        @Override
        public void foo() {
            System.out.println("Target1 foo...");
        }

        @Override
        public void bar() {
            System.out.println("Target1 bar...");
        }
    }

    static class Target2 {

        public void foo() {
            System.out.println("Target2 foo...");
        }

        public void bar() {
            System.out.println("Target2 bar...");
        }
    }
}
