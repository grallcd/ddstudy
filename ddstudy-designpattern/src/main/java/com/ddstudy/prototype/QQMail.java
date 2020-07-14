package com.ddstudy.prototype;

/**
 * @Classname QQMail
 * @Description TODO
 * @Date 2020/7/14
 * @Author Grain Rain
 */
public class QQMail extends AbstractMail {

    /**
     * 正文
     */
    private String context;

    public QQMail(String context) {
        this.context = context;
    }

    public QQMail(QQMail qqMail) {
        super(qqMail);
        System.out.println("我是构造方法");
        this.context = qqMail.context;
    }

    @Override
    public AbstractMail copy() {
        return new QQMail(this);
    }

    @Override
    public String toString() {
        return "QQMail{" +
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
        QQMail other = (QQMail) obj;
        if (context == null) {
            return other.context == null;
        }
        return context.equals(other.context);
    }
}
