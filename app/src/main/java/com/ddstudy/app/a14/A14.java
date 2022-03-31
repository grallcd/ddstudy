package com.ddstudy.app.a14;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author grallcd
 * @since 2022/3/31
 */
public class A14 {

    public static void main(String[] args) {

        Proxy proxy = new Proxy();
        Target target = new Target();

        proxy.setInterceptor(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
                // 反射调用
                // return method.invoke(target, objects);

                // 内部无反射，结合目标使用
                // return methodProxy.invoke(target, objects);

                // 内部无反射，结合代理使用
                return methodProxy.invokeSuper(proxy, objects);

            }
        });

        proxy.save();
        proxy.save(10);
        proxy.save(100L);

    }
}
