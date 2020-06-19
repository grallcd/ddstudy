package com.ddstudy.template;

/**
 * @Classname BasketBall
 * @Description LOL开始选英雄，然后发育推塔，最后胜利
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class LOL extends Game{
    @Override
    void start() {
        System.out.println("Choose a hero ");
    }

    @Override
    void continued() {
        System.out.println("Developing regiment and pushing tower");
    }

    @Override
    void end() {
        System.out.println("Victory");
    }
}
