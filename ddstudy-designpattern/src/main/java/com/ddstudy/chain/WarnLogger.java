package com.ddstudy.chain;

/**
 * @Classname WarnLogger
 * @Description TODO
 * @Date 2020/7/15
 * @Author Grain Rain
 */
public class WarnLogger extends AbstractLogger {
    @Override
    public void handleRequest(Log log) {
        if (log.getType() == LogType.WARN) {
            log(log.getMsg());
        }
        super.handleRequest(log);
    }

    @Override
    public String toString() {
        return "Log-Warn : ";
    }
}
