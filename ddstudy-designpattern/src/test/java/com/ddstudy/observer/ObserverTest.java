package com.ddstudy.observer;

import org.junit.jupiter.api.Test;

/**
 * @Classname ObserverTest
 * @Description TODO
 * @Date 2020/6/20
 * @Author Grain Rain
 */
class ObserverTest {

    @Test
    void testObserver(){

        Email email = new Email();

        Observer studentA = new StudentA(email);
        Observer studentB = new StudentB(email);

        //新邮件，自动通知相关订阅者
        email.newEmail();

        Observer studentC = new StudentC(email);
        email.detach(studentA);
        email.newEmail();

    }

}
