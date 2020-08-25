package com.ddstudy.bridge;

/**
 * @Classname SoulEatingEnchantment
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class SoulEatingEnchantment implements Enchantment {
    @Override
    public void onActivate() {
        System.out.println("The item spreads bloodlust.");
    }

    @Override
    public void apply() {
        System.out.println("The item eats the soul of enemies.");
    }

    @Override
    public void onDeactivate() {
        System.out.println("Bloodlust slowly disappears.");
    }
}
