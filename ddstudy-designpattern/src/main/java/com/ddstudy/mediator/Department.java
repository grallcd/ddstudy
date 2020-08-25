package com.ddstudy.mediator;

public interface Department {

    /**
     * 做本部门自己的事情
     */
    void selfAction();


    /**
     * 向中介者申请，需其他部门协助做的事情
     */
    void outAction();

}
