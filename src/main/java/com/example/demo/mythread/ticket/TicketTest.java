package com.example.demo.mythread.ticket;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 多线程买票
 * @date 2021/6/30 2:25 下午
 */
public class TicketTest {

    public static void main(String[] args) {
        TicketTask ticketTask = new TicketTask();
        new Thread(ticketTask).start();
        new Thread(ticketTask).start();
        new Thread(ticketTask).start();
        new Thread(ticketTask).start();
    }
}
