package com.ddstudy.mediator;

/**
 * @Classname Development
 * @Description TODO
 * @Date 2020/7/20
 * @Author Grain Rain
 */
public class Development implements Department {

    private Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("development", this);
    }

    @Override
    public void selfAction() {
        System.out.println(Action.DEVELOP.getDescription());
    }

    @Override
    public void outAction() {
        System.out.println("Develop project! And we need more money to develop");
        mediator.command("financial");
    }
}
