package com.ddstudy.strategy;

/**
 * @Classname Context
 * @Description 上下文：用来组合策略
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class Context {

    private PayMethod method;

    public Context(PayMethod method) {
        this.method = method;
    }

    public void shopping() {
        method.pay();
    }
}
