package com.example.demo.mythread.threadlocal;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/17 11:36 上午
 */
public class ThreadLocalMainTest {

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> threadLocalTest.hello(finalI)).start();
        }
    }
}
