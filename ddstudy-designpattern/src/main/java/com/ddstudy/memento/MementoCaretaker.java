package com.ddstudy.memento;

/**
 * @Classname MementoCaretaker
 * @Description 备忘录管理者
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class MementoCaretaker {

    private HeroMemento heroMemento;

    public void setHeroMemento(HeroMemento heroMemento) {
        this.heroMemento = heroMemento;
    }

    public HeroMemento getHeroMemento() {
        return heroMemento;
    }
}
