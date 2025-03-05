package org.hl.springlearn.jucdemo;

import java.util.concurrent.Semaphore;

/**
 * 计数信号量 示例
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);  // 允许 2 个线程同时访问

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();  // 获取许可
                    System.out.println(Thread.currentThread().getName() + " 获得了许可");
                    Thread.sleep(2000);  // 模拟资源使用
                    System.out.println(Thread.currentThread().getName() + " 释放了许可");
                    semaphore.release();  // 释放许可
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}