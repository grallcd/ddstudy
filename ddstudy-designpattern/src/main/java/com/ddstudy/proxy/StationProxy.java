package com.ddstudy.proxy;

/**
 * @Classname Proxy
 * @Description 代理模式:通过火车票代售点出售火车票
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class StationProxy implements Station {

    private TrainStation trainStation;

    public StationProxy() {
        this.trainStation = new TrainStation();
    }

    @Override
    public void sellTickets() {
        System.out.println("Selling tickets by the proxy");
        trainStation.sellTickets();
    }
}
