package com.ddstudy.chain;

/**
 * @Classname Log
 * @Description 具体日志
 * @Date 2020/7/15
 * @Author Grain Rain
 */
public class Log {

    /**
     * 日志信息
     */
    private final String msg;

    /**
     * 日志类别
     */
    private final LogType type;

    public Log(String msg, LogType type) {
        this.msg = msg;
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public LogType getType() {
        return type;
    }
}
