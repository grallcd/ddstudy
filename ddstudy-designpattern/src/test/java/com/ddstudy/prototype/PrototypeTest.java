package com.ddstudy.prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Classname PrototypeTest
 * @Description TODO
 * @Date 2020/7/14
 * @Author Grain Rain
 */
public class PrototypeTest {

    @Test
    void testPrototype() {

        QQMail qqMail = new QQMail("Hello World ~");
        System.out.println(qqMail);

        QQMail copyMail = (QQMail) qqMail.copy();
        System.out.println(copyMail);

        Assertions.assertEquals(qqMail, copyMail);

    }

    @Test
    void testPrototype2(){

        SinaMail sinaMail = new SinaMail("Hello Java ~");
        System.out.println(sinaMail);

        SinaMail copyMail2 = (SinaMail) sinaMail.copy();
        System.out.println(copyMail2);

        Assertions.assertEquals(sinaMail, copyMail2);
    }

    @Test
    void testPrototype3(){
        Sheep original = new Sheep("Jolly");

        Sheep clone = original.clone();
        clone.setName("Dolly");

        Assertions.assertEquals("Dolly", clone.getName());
        Assertions.assertEquals("Jolly", original.getName());

    }
}
