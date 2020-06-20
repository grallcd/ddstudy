package com.ddstudy.strategy;

/**
 * @Classname Cash
 * @Description 现金支付
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class Cash extends PayMethod{
    @Override
    public void pay() {
        System.out.println("pay by cash");
    }
}
