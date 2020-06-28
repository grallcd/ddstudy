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

    public static final ClosedState CLOSED_STATE = new ClosedState();

    public static final OpenState OPEN_STATE = new OpenState();

    /**
     * 初始状态：关闭
     */
    private State state = CLOSED_STATE;

    public void on() {
        state.open();
    }

    public void close() {
        state.close();
    }

    void setState(State state) {
        this.state = state;
    }
}
