package com.ddstudy.mediator;

public enum Action {


    DEVELOP("Concentrate on scientific research and develop projects!"),
    FINANCE("Provide financial support!"),
    MARKET("Run to pick up the project!");

    Action(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }
}
