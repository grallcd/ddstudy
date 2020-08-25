package com.ddstudy.prototype;

/**
 * @Classname SinaMail
 * @Description TODO
 * @Date 2020/7/14
 * @Author Grain Rain
 */
public class SinaMail extends AbstractMail{
    /**
     * 正文
     */
    private String context;

    public SinaMail(String context) {
        this.context = context;
    }

    public SinaMail(SinaMail sinaMail) {
        super(sinaMail);
        this.context = sinaMail.context;
    }

    @Override
    public AbstractMail copy() {
        return new SinaMail(this);
    }

    @Override
    public String toString() {
        return "SinaMail{" +
                "context='" + context + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SinaMail other = (SinaMail) obj;
        if (context == null) {
            return other.context == null;
        }
        return context.equals(other.context);
    }
}
