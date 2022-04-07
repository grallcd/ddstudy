package com.ddstudy.app.a18;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.*;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author grallcd
 * @since 2022/4/7
 */
public class A18 {

    static class Aspect {

        @Before("execution(* foo())")
        public void before1() {
            System.out.println("Aspect.before1");
        }

        @Before("execution(* foo())")
        public void before2() {
            System.out.println("Aspect.before2");
        }

        public void after() {
            System.out.println("Aspect.after");
        }

        @AfterReturning("execution(* foo())")
        public void afterReturning() {
            System.out.println("Aspect.afterReturning");
        }

        @AfterThrowing("execution(* foo())")
        public void afterThrowing() {
            System.out.println("Aspect.afterThrowing");
        }

        @Around("execution(* foo())")
        public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
            return joinPoint.proceed();
        }
    }

    static class Target {
        public void foo() {
            System.out.println("target foo...");
        }
    }

    public static void main(String[] args) throws Throwable {


        // 1. 高级切面转低级切面类
        List<Advisor> advisors = new ArrayList<>();
        AspectInstanceFactory factory = new SimpleAspectInstanceFactory(Aspect.class);
        for (Method method : Aspect.class.getDeclaredMethods()) {

            Before before;
            if ((before = method.getAnnotation(Before.class)) != null) {
                String expression = before.value();

                // 解析切点
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(expression);
                // 通知类
                AspectJMethodBeforeAdvice advice = new AspectJMethodBeforeAdvice(method, pointcut, factory);
                // 切面
                Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
                advisors.add(advisor);
            } else if (method.isAnnotationPresent(AfterReturning.class)) {
                AfterReturning afterReturning = method.getAnnotation(AfterReturning.class);
                String expression = afterReturning.value();

                // 解析切点
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(expression);
                // 通知类
                AspectJAfterReturningAdvice advice = new AspectJAfterReturningAdvice(method, pointcut, factory);
                // 切面
                Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
                advisors.add(advisor);
            } else if (method.isAnnotationPresent(Around.class)) {
                Around afterReturning = method.getAnnotation(Around.class);
                String expression = afterReturning.value();

                // 解析切点
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(expression);
                // 通知类
                AspectJAroundAdvice advice = new AspectJAroundAdvice(method, pointcut, factory);
                // 切面
                Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
                advisors.add(advisor);
            }
        }
        for (Advisor advisor : advisors) {
            System.out.println(advisor);
        }

        // 2. 统一转化为环绕通知 MethodInterceptor(适配器模式)
        ProxyFactory proxyFactory = new ProxyFactory();
        Target target = new Target();
        proxyFactory.setTarget(target);
        // 准备把 MethodInvocation 放入当前线程
        proxyFactory.addAdvice(ExposeInvocationInterceptor.INSTANCE);
        proxyFactory.addAdvisors(advisors);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<Object> methodInterceptors = proxyFactory.getInterceptorsAndDynamicInterceptionAdvice(Target.class.getMethod("foo"), Target.class);
        for (Object o : methodInterceptors) {
            System.out.println(o);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        // 3. 创建并执行调用链（环绕通知 + 目标）
        Constructor<ReflectiveMethodInvocation> constructor = ReflectiveMethodInvocation.class.getDeclaredConstructor(Object.class, Object.class, Method.class, Object[].class,
                Class.class, List.class);
        constructor.setAccessible(true);
        MethodInvocation methodInvocation = constructor.newInstance(null, target,Target.class.getMethod("foo"), new Object[0],
                Target.class, methodInterceptors);

        methodInvocation.proceed();

    }


}
