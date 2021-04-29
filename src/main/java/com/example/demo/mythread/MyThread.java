package com.example.demo.mythread;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/26 6:22 下午
 */
public class MyThread extends Thread{


    @Override
    public void run() {
//        System.out.println("Thread.currentThread.getName" + Thread.currentThread().getName());
//        System.out.println("this.getName" + this.getName());


        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("i=" + (i + 1));

        }
    }
}
