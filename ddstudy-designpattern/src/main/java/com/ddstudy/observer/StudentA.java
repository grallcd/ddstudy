package com.ddstudy.observer;

/**
 * @Classname StudentA
 * @Description 观察者A
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class StudentA implements Observer {

    private Subject subject;

    public StudentA(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("A receive an email");
    }
}
