package com.ddstudy.state;

/**
 * @Classname ClosedState
 * @Description 门处于关着的状态
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class ClosedState implements State {

    private Door door;

    @Override
    public void open() {
        System.out.println("open the door");
        door.setState(Door.OPEN_STATE);
    }

    @Override
    public void close() {
        System.out.println("The door is closed");
    }
}
