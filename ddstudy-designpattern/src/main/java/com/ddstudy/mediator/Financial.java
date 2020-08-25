package com.ddstudy.mediator;

/**
 * @Classname Finacial
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class Financial implements Department {

    private Mediator mediator;

    public Financial(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("financial", this);
    }

    @Override
    public void selfAction() {
        System.out.println(Action.FINANCE.getDescription());
    }

    @Override
    public void outAction() {
        System.out.println("There's too much money to run out of");
    }
}
