package com.example.demo.mythread.threadpool;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/11 2:03 下午
 */
public class Widget {

    public synchronized void doSomething() {
        System.out.println("hello,我是Widget   父类=======>" + Thread.currentThread().getState());
        System.out.println("hello,我是Widget   父类");
    }
}
