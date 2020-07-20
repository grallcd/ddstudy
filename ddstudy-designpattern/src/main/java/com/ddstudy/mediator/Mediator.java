package com.ddstudy.mediator;

public interface Mediator {

    void register(String name, Department department);

    void command(String name);

}
