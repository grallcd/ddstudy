package com.ddstudy.proxy;

import org.junit.jupiter.api.Test;

/**
 * @Classname ProxyTest
 * @Description TODO
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class ProxyTest {

    @Test
    void testProxy(){

        //通过火车站出售车票
        TrainStation trainStation = new TrainStation();
        trainStation.sellTickets();

        //通过代售处出售火车票
        StationProxy stationProxy = new StationProxy();
        stationProxy.sellTickets();

    }
}
