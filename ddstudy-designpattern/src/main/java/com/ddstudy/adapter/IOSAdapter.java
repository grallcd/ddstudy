package com.ddstudy.adapter;

/**
 * @Classname IOSAdapter
 * @Description ios适配器
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class IOSAdapter implements IOSConnector{

    AndroidConnector androidConnector;

    public IOSAdapter(AndroidConnector androidConnector) {
        this.androidConnector = androidConnector;
    }

    @Override
    public void chargingForIOS() {
        androidConnector.chargingForAndroid();
    }
}
