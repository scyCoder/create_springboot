package com.example.demo.mythread;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 正向计数，当线程数打到指定的数量后才会继续执行
 * @date 2021/8/10 11:47 上午
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 场景一：
 * 当所有人员都到了，才开会
 * <p>
 * 场景二：集齐7颗龙珠，才能召唤神龙
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        // 第一个参数，表示要打到的线程数
        // 第二个参数，表示当线程数打到指定的数量，需要执行的
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("***召唤神龙"));

        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t第" + finalI + "龙珠");
                try {
                    // 线程执行完，如果没有到达指定的线程数量，需要等待
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
