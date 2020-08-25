package com.ddstudy.adapter;

import org.junit.jupiter.api.Test;

/**
 * @Classname AdapterTest
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class AdapterTest {

    @Test
    public void testAdapter(){
        IOSConnector connector = new Adapter(new TypeCConnector());
        connector.chargingForIOS();
    }
}
