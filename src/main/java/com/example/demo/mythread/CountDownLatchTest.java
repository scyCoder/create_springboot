package com.example.demo.mythread;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description CountDownLatch  这个类使一个线程等待其他线程各自执行完毕后再执行。
 * 是通过一个计数器来实现的，计数器的初始值是线程的数量。每当一个线程执行完毕后，计数器的值就-1，当计数器的值为0时，
 * 表示所有线程都执行完毕，然后在闭锁上等待的线程就可以恢复工作了。
 * @date 2021/8/9 5:25 下午
 */

import java.util.concurrent.CountDownLatch;

/**
 * 场景：
 *      六个线程   一个主线程
 *      只有在六个线程都打印了"离开教室"，主线程才能打印"离开教室
 *
 */

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 第一种不可取：
         *      打印结果：
         *          1	离开教室
         *          5	离开教室
         *          main	离开教室
         *          4	离开教室
         *          3	离开教室
         *          2	离开教室
         *          6	离开教室
         */

        /*for (int i = 1; i <= 6; i++) {
            // 模拟六个线程
            new Thread(()-> System.out.println(Thread.currentThread().getName()  + "\t离开教室"),i + "").start();
        }

        System.out.println(Thread.currentThread().getName() + "\t离开教室");*/

        /**
         * 第二种
         *      使用CountDownLatch，让其主线程等待其余的线程执行完后在执行
         */

        // 创建一个CountDownLatch 计数线程类，其参数表示的是线程的数
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            // 模拟六个线程
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName()  + "\t离开教室");
                countDownLatch.countDown(); // 减少锁存器的计数，如果计数达到零，释放所有等待的线程。
            },i + "").start();
        }

        countDownLatch.await(); // 导致当前线程阻塞等到锁存器计数到零，除非线程是 interrupted 。
        System.out.println(Thread.currentThread().getName() + "\t离开教室");

    }
}
