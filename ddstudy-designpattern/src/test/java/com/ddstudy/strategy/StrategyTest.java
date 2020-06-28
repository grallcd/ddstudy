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

        PayTypeEnum.ALIPAY.pay();

        PayTypeEnum.WXPAY.pay();

        PayTypeEnum.CASHPAY.pay();

    }
}
