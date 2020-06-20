package com.ddstudy.state;

/**
 * @Classname Door
 * @Description 状态模式：门可以有2种状态
 * 1.关着 2.开着，不同状态时可以进行不同的操作
 * 另：状态转化的过程可以封装在具体状态或环境类中，此例
 * 则是封装在具体状态中
 * @Date 2020/6/20
 * @Author Grain Rain
 */
public class Door {

    private final ClosedState CLOSED_STATE = new ClosedState(this);

    private final OpenState OPEN_STATE = new OpenState(this);

    //初始处于关着的状态
    private State state = CLOSED_STATE;

    public void on() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public State getCLOSED_STATE() {
        return CLOSED_STATE;
    }

    public State getOPEN_STATE() {
        return OPEN_STATE;
    }

    void setState(State state) {
        this.state = state;
    }
}
