package com.example.demo.mythread.synchroized;

import com.example.demo.mythread.synchroized.SynchroizedThreadService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/15 5:20 下午
 */
public class SynchroizedThreadServiceTest {

    public static void main(String[] args) {
        // 创建这个对象，可以使在service方法的重synchronized代码块中的this锁是唯一的
        // SynchroizedThreadService service = new SynchroizedThreadService();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                // 在这里new SynchroizedThreadService()，
                // 会使得service方法中synchronized代码块中获得锁this不是同一个对象，
                // 导致synchronized代码块失效，所以不能在这里new 对象，要保证service方法中的synchronized的锁是一致的。
                // 如果必须这样可以在SynchroizedThreadService类中创建一个静态的对象 private static Object lock = new Object();
                // 将synchronized代码块中的锁换成lock，这个对象必须要是静态的
                SynchroizedThreadService service = new SynchroizedThreadService();
                service.service(Long.parseLong(finalI + ""));
            }).start();
        }
    }
}
