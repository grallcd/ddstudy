package com.ddstudy.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Email
 * @Description 观察者模式：具体主题对象
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class Email implements Subject{

    private List<Observer> observers;

    public Email() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyChange() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * 新写一封邮件自动推送到订阅它的observer上
     */
    public void newEmail(){
        notifyChange();
    }
}
