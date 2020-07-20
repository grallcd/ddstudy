package com.ddstudy.memento;

import org.junit.jupiter.api.Test;

/**
 * @Classname MementoTest
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class MementoTest {

    @Test
    void testMemento() {

        Hero hero = new Hero();

        // 打怪前存档
        hero.display();
        MementoCaretaker caretaker = new MementoCaretaker();
        caretaker.setHeroMemento(hero.store());

        // 打完怪
        hero.fight();
        hero.fight();
        hero.display();

        // 恢复存档
        hero.restore(caretaker.getHeroMemento());
        hero.display();

    }
}
