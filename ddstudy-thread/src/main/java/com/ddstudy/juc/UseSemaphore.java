package com.ddstudy.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量，控制可以访问的线程数目，可以用来做单机的限流。
 * 示例：10 辆车抢 3 个停车位
 */
public class UseSemaphore {
    static class Resource {
        private Semaphore semaphore;

        public Resource(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        public void parkCar() {
            try {
                semaphore.acquire();
                System.out.format("%s 抢到了一个停车位\n", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPools = Executors.newFixedThreadPool(10);
        Resource resource = new Resource(new Semaphore(3));
        for (int i = 0; i < 10; i++) {
            threadPools.execute(resource::parkCar);
        }
        threadPools.shutdown();
    }
}
