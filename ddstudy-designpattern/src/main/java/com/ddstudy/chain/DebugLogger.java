package com.ddstudy.chain;

/**
 * @Classname DebugLogger
 * @Description debug日志记录器
 * @Date 2020/7/15
 * @Author Grain Rain
 */
public class DebugLogger extends AbstractLogger {

    @Override
    public void handleRequest(Log log) {
        if (log.getType() == LogType.DEBUG) {
            log(log.getMsg());
        }
        super.handleRequest(log);
    }

    @Override
    public String toString() {
        return "Log-Debug : ";
    }
}
