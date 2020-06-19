package com.ddstudy.observer;

/**
 * @Classname StudentB
 * @Description 观察者B
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class StudentB implements Observer {

    Subject subject;

    public StudentB(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("B receive an email");
    }
}
