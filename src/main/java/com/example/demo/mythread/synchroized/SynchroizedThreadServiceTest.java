package com.example.demo.mythread.synchroized;

import com.example.demo.mythread.synchroized.SynchroizedThreadService;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/15 5:20 下午
 */
public class SynchroizedThreadServiceTest {

    public static void main(String[] args) {
        SynchroizedThreadService service = new SynchroizedThreadService();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                service.service(Long.parseLong(finalI + ""));
            }).start();
        }

//        new Thread(() -> {
//                SynchroizedThreadService service = new SynchroizedThreadService();
//                service.service(Long.parseLong(1 + ""));
//            }).start();
//
//        new Thread(() -> {
//            SynchroizedThreadService service = new SynchroizedThreadService();
//            service.service(Long.parseLong(1 + ""));
//        }).start();
//
//        new Thread(() -> {
//            SynchroizedThreadService service = new SynchroizedThreadService();
//            service.service(Long.parseLong(1 + ""));
//        }).start();
//
//        new Thread(() -> {
//            SynchroizedThreadService service = new SynchroizedThreadService();
//            service.service(Long.parseLong(1 + ""));
//        }).start();
    }
}
