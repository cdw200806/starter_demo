package com.example;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.*;

public class T6 {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(7);
        //   ExecutorService executorService = Executors.newFixedThreadPool(7);
        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 0, TimeUnit.MILLISECONDS, new SynchronousQueue<>(true));
        Thread testCDL = new Thread(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "count down，计数还剩下：" + countDownLatch.getCount());
        });

        for (int i = 0; i < 7; i++) {
            //任务来的太快的话，会无法执行完。
            Thread.sleep(1000);
            executorService.submit(testCDL);
        }
        countDownLatch.await();
        System.out.println("等待结束");
        executorService.shutdown();
        Runnable a;
        Callable b;

    }
}
