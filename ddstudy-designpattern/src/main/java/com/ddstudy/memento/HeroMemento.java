package com.ddstudy.memento;

/**
 * @Classname HeroMemento
 * @Description 具体备忘录
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class HeroMemento {
    private Integer attack;

    private Integer defense;

    private Integer vitality;

    public HeroMemento(Integer attack, Integer defense, Integer vitality) {
        this.attack = attack;
        this.defense = defense;
        this.vitality = vitality;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getVitality() {
        return vitality;
    }

    public void setVitality(Integer vitality) {
        this.vitality = vitality;
    }
}
