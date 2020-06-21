package com.ddstudy.proxy;

import sun.security.krb5.internal.Ticket;

/**
 * @Classname TrainStation
 * @Description 火车站
 * @Date 2020/6/21
 * @Author Grain Rain
 */
public class TrainStation implements Station {
    @Override
    public void sellTickets() {
        System.out.println("Sell a train ticket");
    }
}
