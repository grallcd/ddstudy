package com.ddstudy.prototype;

/**
 * @Classname Mail
 * @Description TODO
 * @Date 2020/7/14
 * @Author Grain Rain
 */
public abstract class AbstractMail implements Prototype {

    public AbstractMail() {
    }

    public AbstractMail(AbstractMail source) {

    }

    @Override
    public abstract AbstractMail copy();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass();
    }
}
