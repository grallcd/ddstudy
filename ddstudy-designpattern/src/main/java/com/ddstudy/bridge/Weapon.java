package com.ddstudy.bridge;

/**
 * @Classname Weapon
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public interface Weapon {

    void wield();

    void swing();

    void unWield();

    Enchantment getEnchantment();

}
