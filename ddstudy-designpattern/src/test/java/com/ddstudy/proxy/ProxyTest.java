package com.ddstudy.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @Classname ProxyTest
 * @Description TODO
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class ProxyTest {

    @Test
    void testProxy() {

        // 通过火车站出售车票
        TrainStation trainStation = new TrainStation();
        trainStation.sellTickets();

        // 通过代售处出售火车票
        StationProxy stationProxy = new StationProxy();
        stationProxy.sellTickets();

    }

    @Test
    void testDynamicProxy() {

        TrainStation trainStation = new TrainStation();

        ProxyHandler proxyHandler = new ProxyHandler(trainStation);

        Station instance = (Station) Proxy.newProxyInstance(trainStation.getClass().getClassLoader(), trainStation.getClass().getInterfaces(), proxyHandler);

        instance.sellTickets();

    }
}
