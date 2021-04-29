package com.example.demo.mythread;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/26 6:22 下午
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
//        myThread.setName("a");
//        myThread.start();

        //Thread thread = new Thread(myThread);
//        thread.setName("a");
//        thread.start();
        myThread.start();
        Thread.sleep(60000);
        myThread.interrupt();
        System.out.println("是否停止1：" + myThread.isInterrupted());
        System.out.println("是否停止2：" + myThread.isInterrupted());
    }
}
