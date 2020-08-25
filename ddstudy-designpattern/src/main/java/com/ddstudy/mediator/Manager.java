package com.ddstudy.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Manager
 * @Description 具体中介者，负责协调各部门
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class Manager implements Mediator {

    private Map<String,Department> map;

    public Manager() {
        map = new HashMap<>(16);
    }

    @Override
    public void register(String name, Department department) {
        map.put(name, department);
    }

    @Override
    public void command(String name) {
        map.get(name).selfAction();
    }

}
