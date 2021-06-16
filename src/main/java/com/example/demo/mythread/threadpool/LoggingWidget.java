package com.example.demo.mythread.threadpool;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/11 2:03 下午
 */
public class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        System.out.println("我是LoggingWidet 子类=======>" + Thread.currentThread().getState());
        System.out.println("我是LoggingWidet 子类");
        super.doSomething();
    }
}
