package com.ddstudy.strategy;

import org.junit.jupiter.api.Test;

/**
 * @Classname StrategyTest
 * @Description TODO
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class StrategyTest {

    Context context;

    @Test
    void testStrategy() {

        context = new Context(new Alipay());
        context.shopping();

        context = new Context(new Cash());
        context.shopping();

        context = new Context(new WxPay());
        context.shopping();
    }

    @Test
    void testStrategy2() {

        PayType.ALIPAY.pay();

        PayType.WXPAY.pay();

        PayType.CASHPAY.pay();

    }
}
