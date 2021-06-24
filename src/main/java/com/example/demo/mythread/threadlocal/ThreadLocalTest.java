package com.example.demo.mythread.threadlocal;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 每一个线程在对ThreadLocal设置值时，和获取值是对应的，无论是否加锁
 * @date 2021/6/17 11:28 上午
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> local = new ThreadLocal<Integer>();

    public void hello(Integer integer) {
        System.out.println("当前线程：" + Thread.currentThread().getName());

//        synchronized (this) {
            System.out.println("当前线程set local: " + Thread.currentThread().getName());
            System.out.println("lock地址：" + local);
            local.set(integer);
            System.out.println("当前线程: " + Thread.currentThread().getName() + "set数据为：" + integer);
//        }

        try {
            System.out.println();
            System.out.println();
            System.out.println();
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        synchronized (this) {
            System.out.println("当前线程get local: " + Thread.currentThread().getName());
            System.out.println("lock地址：" + local);
            Integer integer1 = local.get();
            System.out.println("当前线程: " + Thread.currentThread().getName() + "get数据为：" + integer1);
//        }
    }
}
