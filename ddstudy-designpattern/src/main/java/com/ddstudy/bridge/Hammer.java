package com.ddstudy.bridge;

/**
 * @Classname Hammer
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class Hammer implements Weapon {

    private Enchantment enchantment;

    public Hammer(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void wield() {
        System.out.println("The hammer is wield");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        System.out.println("The hanmme is singed");
        enchantment.apply();
    }

    @Override
    public void unWield() {
        System.out.println("The hammer is unwield");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}
