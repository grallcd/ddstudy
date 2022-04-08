package com.ddstudy.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatch,让一些线程阻塞到另一些线程完成一系列操作后在执行。
 * 举例：大家一起去吃饭，吃完后必须等买单的人付款后才可以走。
 * 举例：班上的人都走完了，才可以锁门，（锁门这个线程需要等待所有人都走完了，才可以执行。）
 */
@SuppressWarnings("all")
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

    static class LockDoor {
        private AtomicInteger count = new AtomicInteger(0);
        private CountDownLatch countDown;

        public LockDoor(int peoples) {
            countDown = new CountDownLatch(peoples);
        }

        public void leave() {
            System.out.println("走了一个人");
            count.incrementAndGet();
            countDown.countDown();
        }

        public void waitLockDoor() {
            System.out.println("等人走光了我才能锁门");
            try {
                countDown.await();
                System.out.format("走了%d个人，锁门", count.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService threadPools = Executors.newFixedThreadPool(10);
//        Resource resource = new Resource(1);
//        threadPools.execute(resource::canLeave);
//        threadPools.execute(resource::canLeave);
//        threadPools.execute(resource::canLeave);
//        threadPools.execute(resource::canLeave);
//        threadPools.execute(resource::canLeave);
//        TimeUnit.SECONDS.sleep(5);
//        threadPools.execute(resource::pay);
//        threadPools.shutdown();


        ExecutorService threadPools = Executors.newFixedThreadPool(3);
        LockDoor lockDoor = new LockDoor(40);
        threadPools.execute(lockDoor::waitLockDoor);
        threadPools.execute(() -> {
            for (int i = 0; i < 15; i++) {
                lockDoor.leave();
            }
        });
        threadPools.execute(() -> {
            for (int i = 0; i < 15; i++) {
                lockDoor.leave();
            }
        });
        threadPools.execute(() -> {
            for (int i = 0; i < 50; i++) {
                lockDoor.leave();
            }
        });
        threadPools.shutdown();
    }
}