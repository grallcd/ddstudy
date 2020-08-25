package com.ddstudy.observer;

public interface Observer {

    default void update(){
        System.out.println("receive an email");
    };
}
