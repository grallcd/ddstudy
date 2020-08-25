package com.ddstudy.prototype;

/**
 * @Classname Sheep
 * @Description TODO
 * @Date 2020/7/14
 * @Author Grain Rain
 */
public class Sheep implements Cloneable {

    private String name;

    public Sheep() {
    }

    public Sheep(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Sheep clone() {
        try {
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
