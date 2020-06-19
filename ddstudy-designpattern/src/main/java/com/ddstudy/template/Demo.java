package com.ddstudy.template;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class Demo {

    public static void main(String[] args) {
        Game poker = new Poker();

        Game lol = new LOL();

        poker.playGame();

        lol.playGame();
    }
}
