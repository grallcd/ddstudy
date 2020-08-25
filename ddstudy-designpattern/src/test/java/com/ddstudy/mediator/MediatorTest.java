package com.ddstudy.mediator;

import org.junit.jupiter.api.Test;

/**
 * @Classname MediatorTest
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class MediatorTest {

    @Test
    void testMediator() {

        Manager manager = new Manager();

        Development development = new Development(manager);
        Financial financial = new Financial(manager);
        Market market = new Market(manager);


        development.selfAction();
        development.outAction();

        financial.selfAction();
        financial.outAction();

        market.selfAction();
        market.outAction();

    }
}
