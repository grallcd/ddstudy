package com.ddstudy.app.a14;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Signature;

/**
 * @author grallcd
 * @since 2022/3/31
 */
@Slf4j
public class TargetFastClass {

    private static final Signature s0;
    private static final Signature s1;
    private static final Signature s2;

    static {
        s0 = new Signature("save", "()V");
        s1 = new Signature("save", "(I)V");
        s2 = new Signature("save", "(J)V");
    }

    /*
        Target
            save()                0
            save(int i)           1
            save(long j)          2
        Signature: 包括方法名、参数和返回值
     */
    public int getIndex(Signature signature) {
        if (s0.equals(signature)) {
            return 0;
        } else if (s1.equals(signature)) {
            return 1;
        } else if (s2.equals(signature)) {
            return 2;
        }
        return -1;
    }


    /**
     * 根据方法编号，正常调用目标方法
     *
     * @param index  方法编号
     * @param target 目标对象
     * @param args   方法参数
     * @return
     */
    public Object invoke(int index, Object target, Object[] args) {
        if (index == 0) {
            ((Target) target).save();
            return null;
        } else if (index == 1) {
            ((Target) target).save((Integer) args[0]);
            return null;
        } else if (index == 2) {
            ((Target) target).save((Long) args[0]);
            return null;
        }
        throw new RuntimeException("无此方法");
    }

    public static void main(String[] args) {

        TargetFastClass fastClass = new TargetFastClass();
        Signature signature = new Signature("save", "()V");
        int index = fastClass.getIndex(signature);
        log.info("index:{}", index);
        fastClass.invoke(index, new Target(), new Object[0]);


        Signature signature2 = new Signature("save", "(I)V");
        int index2 = fastClass.getIndex(signature2);
        log.info("index2:{}", index2);
        fastClass.invoke(index2, new Target(), new Object[]{100});
    }

}
