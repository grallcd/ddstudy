package com.ddstudy.app.a17;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectInstanceFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.aspectj.SimpleAspectInstanceFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author grallcd
 * @since 2022/4/6
 */
public class A17_2 {

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

        public void afterReturning() {
            System.out.println("Aspect.afterReturning");
        }

        public void afterThrowing() {
            System.out.println("Aspect.afterThrowing");
        }

        public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
            return joinPoint.proceed();
        }
    }

    static class Target {
        public void foo() {
            System.out.println("target foo...");
        }
    }

    public static void main(String[] args) {


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
            }
        }

        for (Advisor advisor : advisors) {
            System.out.println(advisor);
        }

    }


}
