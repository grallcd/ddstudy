package com.ddstudy.app.a12;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author grallcd
 * @since 2022/3/30
 */
public class CglibProxyDemo {

    static class Target {
        public void foo() {
            System.out.println("target foo");
        }
    }

    // 代理是子类型，目标是父类型，因此目标类不能用 final 修饰
    public static void main(String[] args) {

        Target target = new Target();
        Target proxy = (Target) Enhancer.create(Target.class, (MethodInterceptor) (o, method, param, methodProxy) -> {
            System.out.println("before");

            // 用方法反射调用目标
            // Object result = method.invoke(target, param);

            // methodProxy 可以避免反射调用，需要目标
            // Object result2 = methodProxy.invoke(target, param);

            // 也没用反射，需要代理
            Object result3 = methodProxy.invokeSuper(o, param);

            System.out.println("after");

            return result3;
        });

        proxy.foo();
    }
}
