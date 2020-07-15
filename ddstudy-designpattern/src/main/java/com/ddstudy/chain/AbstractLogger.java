package com.ddstudy.chain;

/**
 * @Classname Logger
 * @Description 抽象日志记录器
 * @Date 2020/7/15
 * @Author Grain Rain
 */
public abstract class AbstractLogger {

    private AbstractLogger next;

    public AbstractLogger setNext(AbstractLogger next) {
        this.next = next;
        return this;
    }

    public AbstractLogger getNext() {
        return next;
    }

    public void handleRequest(Log log) {
        if (next != null) {
            next.handleRequest(log);
        }
    }

    protected void log(String msg) {
        System.out.println(this + msg);
    }

    @Override
    public abstract String toString();
}
