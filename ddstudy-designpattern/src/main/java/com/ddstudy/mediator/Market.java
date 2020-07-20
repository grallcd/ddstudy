package com.ddstudy.mediator;

/**
 * @Classname Market
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class Market implements Department {

    private Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("market", this);
    }

    @Override
    public void selfAction() {
        System.out.println(Action.MARKET.getDescription());
    }

    @Override
    public void outAction() {
        System.out.println("Report work! And we need more money.");
        mediator.command("financial");

    }
}
