package com.ddstudy.bridge;

/**
 * @Classname Sword
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class Sword implements Weapon {

    private Enchantment enchantment;

    public Sword(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void wield() {
        System.out.println("The sword is wield");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        System.out.println("The sword is swinged");
        enchantment.apply();
    }

    @Override
    public void unWield() {
        System.out.println("The sword is unwield");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}
