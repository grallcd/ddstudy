package com.ddstudy.chain;

/**
 * @Classname LogType
 * @Description 日志类别
 * @Date 2020/7/15
 * @Author Grain Rain
 */
public enum LogType {

    DEBUG("Debug 级别的日志"), INFO("Info 级别的日志"), ERROR("Error 级别的日志"),
    WARN("Warn 级别的日志");

    private final String description;

    LogType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
