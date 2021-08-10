package com.example.demo.mythread;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 线程信号量，控制线程的并发
 * @date 2021/8/10 1:59 下午
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 使用场景：
 *      7个车主，抢占3个车位。只有抢到车位的车主离开后，其他的车主才能继续抢占，否则需要等待
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        // 参数表示资源类的个数，这里可以理解为有 3 个车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                try {
                    // 此线程抢到了车位，资源类需要减一
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到了车位");
                    // 模拟车停留时间  3秒
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 此线程执行完，离开后，需要释放资源
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }

    }
}
