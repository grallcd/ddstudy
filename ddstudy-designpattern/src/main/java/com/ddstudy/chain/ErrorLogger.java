package com.ddstudy.chain;

/**
 * @Classname ErrorLogger
 * @Description error日志记录器
 * @Date 2020/7/15
 * @Author Grain Rain
 */
public class ErrorLogger extends AbstractLogger {

    @Override
    public void handleRequest(Log log) {
        if (log.getType() == LogType.ERROR) {
            log(log.getMsg());
        }
        super.handleRequest(log);
    }

    @Override
    public String toString() {
        return "Log-Error : ";
    }
}
