package com.ddstudy.template;

/**
 * @Classname BasketBall
 * @Description LOL开始选英雄，然后发育推塔，最后胜利
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class LOL extends AbstractGame{
    @Override
    protected void start() {
        System.out.println("Choose a hero ");
    }

    @Override
    protected void continued() {
        System.out.println("Developing regiment and pushing tower");
    }

    @Override
    protected void end() {
        System.out.println("Victory");
    }
}
