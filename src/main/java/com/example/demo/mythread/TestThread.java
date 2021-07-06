package com.example.demo.mythread;

import com.example.demo.mythread.threadpool.LoggingWidget;

import java.util.concurrent.*;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/26 6:22 下午
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
////        myThread.setName("a");
////        myThread.start();
//
//        //Thread thread = new Thread(myThread);
////        thread.setName("a");
////        thread.start();
//        myThread.start();
//        Thread.sleep(60000);
//        myThread.interrupt();
//        System.out.println("是否停止1：" + myThread.isInterrupted());
//        System.out.println("是否停止2：" + myThread.isInterrupted());
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,2,20,
//                TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
//                Executors.defaultThreadFactory(),// 线程工厂
//                new ThreadPoolExecutor.AbortPolicy());
//        executor.execute(() -> new LoggingWidget().doSomething());
////        Future<?> submit = executorService.submit(() -> new LoggingWidget().doSomething());
//        LoggingWidget loggingWidget = new LoggingWidget();
//        // loggingWidget.doSomething();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.submit(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程：" + Thread.currentThread().getName() + "====>" + finalI);
            });
        }
    }




}
