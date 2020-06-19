package com.ddstudy.template;

/**
 * @Classname Poker
 * @Description 扑克先发牌，再打牌，最后结束
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class Poker extends Game {
    @Override
    void start() {
        System.out.println("Distribute Poker");
    }

    @Override
    void continued() {
        System.out.println("Poker in progress");
    }

    @Override
    void end() {
        System.out.println("Game over");
    }
}
