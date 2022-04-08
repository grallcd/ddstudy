package com.ddstudy.juc;

import java.util.concurrent.*;

/**
 * 可循环（Cyclic）使用的屏障（Barrier）。
 * CountDownLatch 使用完毕后，如果需要在用相同的功能，需要重新
 * new 一个 CountDownLatch 而 CyclicBarrier 不用，可以循环使用。
 * CyclicBarrier 的计数器通过调用 reset() 方法可以循环使用，所以它才叫做循环屏障。
 */
public class UseCyclicBarrier {
    // 集齐七颗龙珠召唤神龙

    static class Resource {
        private CyclicBarrier cyclicBarrier;

        public Resource(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        public void consumer() {
            try {
                System.out.println("wait~~");
                TimeUnit.SECONDS.sleep(2);
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public static void executor() {
            System.out.println("召唤神龙！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 执行 7 次 await 之后，回调参数中的第二个方法
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, Resource::executor);
        Resource resource = new Resource(cyclicBarrier);

        ExecutorService threadPools = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            threadPools.submit(resource::consumer);
        }

        TimeUnit.SECONDS.sleep(5);

        cyclicBarrier.reset(); // 重置，循环计数
        for (int i = 0; i < 7; i++) {
            threadPools.submit(resource::consumer);
        }

        threadPools.shutdown();
    }
}
