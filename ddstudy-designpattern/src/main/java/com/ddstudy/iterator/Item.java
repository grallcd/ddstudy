package com.ddstudy.iterator;

/**
 * @Classname Item
 * @Description TODO
 * @Date 2020/7/9
 * @Author Grain Rain
 */
public class Item {

    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
