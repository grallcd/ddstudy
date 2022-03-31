package com.ddstudy.app.a12;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * @author grallcd
 * @since 2022/3/30
 */
@Slf4j
public class JdkProxyDemo {

    interface Foo {
        void foo();
    }

    static class Target implements Foo {
        @Override
        public void foo() {
            System.out.println("target foo");
        }
    }

    public static void main(String[] args) {

        Target target = new Target();

        // 用来加载在运行期间动态生成的字节码
        ClassLoader classLoader = JdkProxyDemo.class.getClassLoader();

        Foo proxy = (Foo) Proxy.newProxyInstance(classLoader, new Class[]{Foo.class},
                (p, method, args1) -> {

                    // 目标.方法(参数)
                    // 方法.invoke(目标,参数)
                    log.info("before..");
                    Object result = method.invoke(target, args1);
                    log.info("after..");

                    // 让代理返回方法执行的结果
                    return result;

                });

        proxy.foo();
    }

}
