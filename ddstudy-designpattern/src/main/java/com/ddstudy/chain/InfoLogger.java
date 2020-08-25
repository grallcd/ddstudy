package com.ddstudy.chain;

/**
 * @Classname InfoLogger
 * @Description info日志记录器
 * @Date 2020/7/15
 * @Author Grain Rain
 */
public class InfoLogger extends AbstractLogger {

    @Override
    public void handleRequest(Log log) {
        if (log.getType() == LogType.INFO) {
            log(log.getMsg());
        }
        super.handleRequest(log);
    }

    @Override
    public String toString() {
        return "Log-Info : ";
    }
}
