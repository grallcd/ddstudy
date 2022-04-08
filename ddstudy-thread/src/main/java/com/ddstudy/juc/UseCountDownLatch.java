package com.ddstudy.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch,让一些线程阻塞到另一些线程完成一系列操作后在执行。
 * 距离：大家一起去吃饭，吃完后必须等买单的人付款后才可以走。
 */
public class UseCountDownLatch {
    static class Resource {
        private CountDownLatch countDown;

        public Resource(int times) {
            countDown = new CountDownLatch(times);
        }

        public void canLeave() {
            try {
                System.out.format("我是 %s,我可以走了吗？\n", Thread.currentThread().getName());
                countDown.await();
                System.out.format("%s,跑路~ \n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void pay() {
            System.out.println("我付好钱了，大家可以走了");
            countDown.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPools = Executors.newFixedThreadPool(10);
        Resource resource = new Resource(1);
        threadPools.execute(resource::canLeave);
        threadPools.execute(resource::canLeave);
        threadPools.execute(resource::canLeave);
        threadPools.execute(resource::canLeave);
        threadPools.execute(resource::canLeave);
        TimeUnit.SECONDS.sleep(5);
        threadPools.execute(resource::pay);
        threadPools.shutdown();
    }
}
