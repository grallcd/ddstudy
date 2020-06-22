package com.ddstudy.adapter;

/**
 * @Classname Adapter
 * @Description 适配器，用安卓充电头或TypeC充电头接入适配器后
 * 再插入iPhone给手机充电，一般是将一个接口通过适配器转化成另一个接口
 * 可调用的形式
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class Adapter implements IOSConnector {

    OtherConnector connector;

    public Adapter(OtherConnector otherConnector) {
        this.connector = otherConnector;
    }

    @Override
    public void chargingForIOS() {
        connector.charging();
    }
}
