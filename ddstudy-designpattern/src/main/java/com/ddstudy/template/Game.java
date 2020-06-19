package com.ddstudy.template;

/**
 * @Classname Game
 * @Description 抽象游戏类
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public abstract class Game {

    //开始游戏
    abstract void start();

    //游戏进行中
    abstract void continued();

    //结束游戏
    abstract void end();

    //玩游戏的整个过程
    final void playGame() {
        this.start();

        this.continued();

        this.end();
    }
}
