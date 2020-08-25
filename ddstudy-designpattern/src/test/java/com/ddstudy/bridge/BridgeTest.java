package com.ddstudy.bridge;

import org.junit.jupiter.api.Test;

/**
 * @Classname BridgeTest
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class BridgeTest {

    @Test
    void testBridge(){

        FlyingEnchantment flyingEnchantment = new FlyingEnchantment();

        SoulEatingEnchantment soulEatingEnchantment = new SoulEatingEnchantment();

        Sword sword = new Sword(flyingEnchantment);

        Hammer hammer = new Hammer(soulEatingEnchantment);

        sword.wield();
        sword.swing();
        sword.unWield();

        System.out.println("==========This is a gorgeous dividing line==========");

        hammer.wield();
        hammer.swing();
        hammer.unWield();

    }

}
