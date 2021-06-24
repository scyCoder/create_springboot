package com.example.demo.mythread.sharevar;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/16 3:48 下午
 */
public class ShareVar extends Thread {

    @Override
    public void run() {
        System.out.println("执行了");
        while (!ShareVarTest.isB()) {
            Thread.yield();
        }
        System.out.println(ShareVarTest.getNumber());
    }
}
