package com.ddstudy.strategy;

/**
 * @Classname WxPay
 * @Description 微信支付
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class WxPay extends PayMethod{
    @Override
    public void pay() {
        System.out.println("pay by WxPay");
    }
}
