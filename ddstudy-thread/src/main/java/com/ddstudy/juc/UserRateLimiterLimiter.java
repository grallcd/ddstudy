package com.ddstudy.juc;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用 Guava 的 RateLimiter 进行限流
 */
public class UserRateLimiterLimiter {
    // 每秒 10 个许可证
    static RateLimiter limiter = RateLimiter.create(5);
    static AtomicInteger count = new AtomicInteger(0);

    public static void access() {
        for (int i = 0; i < 10; i++) {
            limiter.acquire();
            long curTime = System.currentTimeMillis();
            System.out.format("%d访问%d次\n", curTime, count.incrementAndGet());
        }
    }

    public static void tryAccess() {
        for (int i = 0; i < 10; i++) {
            if(limiter.tryAcquire()){
                long curTime = System.currentTimeMillis();
                System.out.format("%d访问%d次\n", curTime, count.incrementAndGet());
            }else{
                System.out.println("丢弃请求");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
//        threadPool.execute(UserRateLimiterLimiter::access);
        threadPool.execute(UserRateLimiterLimiter::tryAccess);
        threadPool.shutdown();
    }
}
