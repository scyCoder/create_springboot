package com.example.demo.service.impl.thread;

import org.springframework.stereotype.Component;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/31 3:15 下午
 */
@Component
public class ThreadService implements Runnable {


    public synchronized void threadService() {
            System.out.println(Thread.currentThread().getName() + "开始执行（进来了）");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕（出去了）");
    }

    @Override
    public void run() {
        this.threadService();
    }
}
