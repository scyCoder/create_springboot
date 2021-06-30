package com.example.demo.mythread.ticket;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/30 2:25 下午
 */
@Slf4j
public class TicketTask implements Runnable {

    private Integer ticket = 100; // 不能使用volatile ，不能保证原子性
    private final Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (ticket <= 0) {
                    log.info("票已售罄");
                    break;
                }
                ticket--;
                log.info("当前线程：{}卖出一张票,剩余：{}", Thread.currentThread().getName(), ticket);
            }
        }
    }
}
