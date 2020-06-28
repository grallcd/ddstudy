package com.ddstudy.strategy;

/**
 * @Classname Alipay
 * @Description 支付宝
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class Alipay extends BasePayMethod {
    @Override
    public void pay() {
        System.out.println("pay by Alipay");
    }
}
