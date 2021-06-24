package com.example.demo.mythread.synchroized;

import org.springframework.stereotype.Service;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description synchronized代码块的使用，和锁的获取，必须是唯一的
 * @date 2021/6/15 5:15 下午
 */
@Service
public class SynchroizedThreadService {

    private static Object lock = new Object();

    public void service(long req) {

        System.out.println("当前线程未进入synchroized A块中：" + Thread.currentThread().getName());
//        try {
//
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        synchronized (lock) {
            System.out.println("this ===============" + lock);
            System.out.println("当前线程拿到了锁进入了synchroized A块中：" + Thread.currentThread().getName());
            try {
                System.out.println("当前线程synchroized A,睡一觉====================" + Thread.currentThread().getName());
                Thread.sleep(8000);
                System.out.println("当前线程synchroized A,睡觉结束========" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("当前线程未进入synchroized B块中：" + Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("当前线程拿到了锁进入了synchroized B块中：" + Thread.currentThread().getName());
            try {
                System.out.println("当前线程synchroized B,睡一觉====================" + Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程synchroized B,睡觉结束========" + Thread.currentThread().getName());
        }
    }
}
