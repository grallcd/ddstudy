package com.ddstudy.observer;

/**
 * @Classname StudentC
 * @Description 观察者C
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class StudentC implements Observer {

    private Subject subject;

    public StudentC(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }


}
