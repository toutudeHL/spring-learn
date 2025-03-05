package org.hl.springlearn.jucdemo;

import java.util.concurrent.CountDownLatch;

/**
 * 倒计数器 示例
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 3;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        // 创建并启动三个工作线程
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 正在工作");
                try {
                    Thread.sleep(1000);  // 模拟工作时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();  // 完成工作，计数器减一
                System.out.println(Thread.currentThread().getName() + " 完成工作");
            }).start();
        }

        System.out.println("主线程等待工作线程完成");
        latch.await();  // 主线程等待，直到计数器为 0
        System.out.println("所有工作线程已完成，主线程继续执行");
    }
}