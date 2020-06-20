package com.ddstudy.observer;

/**
 * @Classname ObC
 * @Description TODO
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class StudentC implements Observer {
    Subject subject;

    public StudentC(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }


}
