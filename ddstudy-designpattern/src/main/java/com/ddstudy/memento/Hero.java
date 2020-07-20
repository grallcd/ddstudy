package com.ddstudy.memento;

/**
 * @Classname Hero
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class Hero {

    private Integer attack;

    private Integer defense;

    private Integer vitality;

    public Hero() {
        initHero();
    }

    /**
     * 初始化
     */
    private void initHero() {
        this.attack = 100;
        this.defense = 100;
        this.vitality = 100;
    }

    /**
     * 战斗
     */
    public void fight() {
        this.vitality -= 10;
    }

    /**
     * 存档
     *
     * @return
     */
    public HeroMemento store() {
        return new HeroMemento(attack, defense, vitality);
    }

    /**
     * 读取存档
     *
     * @param heroMemento
     */
    public void restore(HeroMemento heroMemento) {
        this.attack = heroMemento.getAttack();
        this.defense = heroMemento.getDefense();
        this.vitality = heroMemento.getVitality();
    }

    public void display() {
        System.out.println("The Hero State : ");
        System.out.println("-------------------");
        System.out.println("|Attack   :  " + attack + "  |");
        System.out.println("|Defense  :  " + defense + "  |");
        System.out.println("|Vitality :  " + vitality + "  |");
        System.out.println("-------------------");

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
