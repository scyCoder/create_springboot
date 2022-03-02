package com.example.demo.atomic;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2022/1/23 4:55 下午
 */
public class ABADdemo {

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    // 第一个参数：变量的值    第二个参数：版本号
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {

        System.out.println("======CAS中ABA问题的产生");

        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2022) + "\t" + atomicReference.get());
        },"t2").start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("============CAS的ABA问题解决");
        new Thread(()->{
            // 获得原子引用的版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t" + "第一次获得的版本号：" + stamp);
            try {
                // 睡眠是为了让t4线程获得版本号是初始为改变的版本号
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,stamp,stamp + 1);
            int stamp2 = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t" + "第二次获得的版本号：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,stamp2,stamp2 + 1);
            System.out.println(Thread.currentThread().getName() + "\t" + "第三次获得的版本号：" + atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t" + "第一次获得的版本号：" + stamp);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100, 2022,stamp,stamp + 1) + "\t" + atomicStampedReference.getReference());
            System.out.println(Thread.currentThread().getName() + "\t" + "第二次获得的版本号：" + atomicStampedReference.getStamp());
        },"t4").start();

    }
}
