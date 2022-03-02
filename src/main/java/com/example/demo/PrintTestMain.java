package com.example.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2022/2/18 3:00 下午
 */
public class PrintTestMain {

    public static void main(String[] args) {
        PrintTest printTest = new PrintTest();
        ThreadPoolExecutor poll = new ThreadPoolExecutor(2,3,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3));

        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        poll.execute(()->{
            for (int i = 0; i < 26; i++) {
                printTest.printDigital();
            }
        });

        poll.execute(()->{
            for (int i = 0; i < 26; i++) {
                printTest.printLetter();
                if (i == 25) {
                    System.out.println();
                }
            }
        });
        long end = System.currentTimeMillis();


//        for (int i = 0; i < 26; i++) {
//               new Thread(() -> {
//                printTest.printDigital();
//            }).start();
//        }
//
//        for (int i = 0; i < 26; i++) {
//            new Thread(() -> {
//                printTest.printLetter();
//            }).start();
//        }

    }
}
