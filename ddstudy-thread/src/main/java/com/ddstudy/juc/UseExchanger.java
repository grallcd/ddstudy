package com.ddstudy.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程直接，两两交换数据
 */
@SuppressWarnings("all")
public class UseExchanger {
    static class Resource<T> {
        private Exchanger<T> exchanger;

        public Resource(Exchanger<T> exchanger) {
            this.exchanger = exchanger;
        }

        public void swap(T message) {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.format("线程 %s 持有数据 %s\n", threadName, message);
                T exchange = exchanger.exchange(message);
                System.out.format("线程 %s 持有数据 %s\n", threadName, exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPools = Executors.newFixedThreadPool(2);
        Resource<String> resource = new Resource<>(new Exchanger());
        threadPools.execute(() -> {
            resource.swap("AK47");
        });
        TimeUnit.SECONDS.sleep(5);
        threadPools.execute(() -> {
            resource.swap("AWM");
        });
        threadPools.shutdown();
    }
}
