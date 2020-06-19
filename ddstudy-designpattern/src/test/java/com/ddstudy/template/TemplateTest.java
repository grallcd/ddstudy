package com.ddstudy.template;

import org.junit.jupiter.api.Test;

/**
 * @Classname TemplateTest
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
public class TemplateTest {

    @Test
    public void testTemplate() {
        Game lol = new LOL();

        Game poker = new Poker();

        lol.playGame();

        poker.playGame();
    }
}
