package com.ddstudy.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 ReentrantLock 进行同步控制。
 * 多生产者多消费者问题。
 */
@SuppressWarnings("all")
public class UseReentrantLock {
    // 资源类
    static class Resource {
        private int count = 0;
        private Lock lock = new ReentrantLock();
        private Condition consumerWait = lock.newCondition();
        private Condition productWait = lock.newCondition();

        // 生产产品
        private void increment() {
            try {
                lock.lock();
                while (count >= 10) {
                    // 无法生产了，则阻塞生产者线程，唤醒所有的消费者线程
                    consumerWait.signalAll();
                    productWait.await();
                }
                // 可以生产，则生产者生产产品。并通知消费者可以进行消费了
                System.out.format("生产【%s】生产产品,现有产品【%d】\n", Thread.currentThread().getName(), ++count);
                productWait.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        // 消费产品
        public void decrement() {
            try {
                lock.lock();
                while (count <= 0) {
                    // 无法消费了，阻塞消费者线程，通知生产者生产
                    consumerWait.await();
                    productWait.signalAll();
                }
                // 可以消费，消费者消费产品，同时唤醒所有生产者生产
                System.out.format("消费者【%s】消费产品,剩余产品【%d】\n", Thread.currentThread().getName(), --count);
                productWait.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        ExecutorService threadPools = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 2; i++) {
            threadPools.execute(() -> {
                while (true) {
                    try {
                        resource.decrement();
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadPools.execute(() -> {
                while (true) {
                    try {
                        resource.decrement();
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadPools.execute(() -> {
                while (true) {
                    try {
                        resource.increment();
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
