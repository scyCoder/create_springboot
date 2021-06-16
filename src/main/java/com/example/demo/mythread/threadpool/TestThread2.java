package com.example.demo.mythread.threadpool;

import com.example.demo.mythread.threadpool.LoggingWidget;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 父类、子类doSomething的方法都有synchronized，如果不使用重进入锁，会造成死锁
 * @date 2021/4/26 6:22 下午
 */
public class TestThread2 {

    public static void main(String[] args) throws InterruptedException {

        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                2,
                20,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                // 线程工厂
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        // 次线程执行
        // 程序没有结束，查看thread dump，显示线程waiting，是因为线程池会继续处理接收到的任务，如果需要结束，需要执行shutdown
        executor.execute(() -> new LoggingWidget().doSomething());
        // 程序正常执行完毕
        // new Thread(()->new LoggingWidget().doSomething()).start();


        // 主线程执行，程序正常执行完毕
        LoggingWidget loggingWidget = new LoggingWidget();
       // loggingWidget.doSomething();
    }
}
