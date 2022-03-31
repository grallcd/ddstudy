package com.ddstudy.app.a13;

/**
 * @author grallcd
 * @since 2022/3/31
 */
public class A13 {

    interface Foo {

        void foo();

        int bar();
    }


    /*interface InvocationHandler {
        Object invoke(Object proxy, Method method, Object[] params) throws Throwable;
    }*/

    static class Target implements Foo {

        @Override
        public void foo() {
            System.out.println("target foo");
        }

        @Override
        public int bar() {
            System.out.println("target bar");

            return 100;
        }
    }

    public static void main(String[] args) {

        $Proxy0 proxy = new $Proxy0((p, method, params) -> {
            // 方法增强
            System.out.println("before");

            // 方法调用
            // new Target().foo();

            System.out.println("after");

            // 反射调用方法
            return method.invoke(new Target(), params);
        });
        proxy.foo();
        proxy.bar();

    }
}
