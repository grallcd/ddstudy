package com.ddstudy.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 同步阻塞队列。使用同步阻塞队列实现生产者消费者进程。
 */
public class UseBlockingQueue {
    static class Resource {
        private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        // 生产者生产
        public void increment() {
            System.out.println("生产了一个");
            queue.add(0);
        }

        // 消费者，消费
        public void decrement() {
            try {
                Integer take = queue.take(); // 拿不到就阻塞
                System.out.println("消费了一个");
            } catch (Exception e) {
                System.out.println("消费不到，进行等待");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPools = Executors.newFixedThreadPool(5);
        Resource resource = new Resource();
        threadPools.execute(() -> {
            for (int i = 0; i < 10; i++) {
                resource.increment();
            }
        });
        threadPools.execute(() -> {
            for (int i = 0; i < 10; i++) {
                resource.increment();
            }
        });
        threadPools.execute(() -> {
            for (int i = 0; i < 20; i++) {
                resource.decrement();
            }
        });
        threadPools.execute(() -> {
            for (int i = 0; i < 20; i++) {
                resource.decrement();
            }
        });
    }
}
