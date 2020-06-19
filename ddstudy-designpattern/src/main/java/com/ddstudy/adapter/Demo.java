package com.ddstudy.adapter;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class Demo {

    public static void main(String[] args) {

        IOSConnector iosConnector = new IOSAdapter(new Connector());

        iosConnector.chargingForIOS();

    }
}
