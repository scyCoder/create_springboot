package com.example.demo.jmm;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description JMM  可见性验证
 * @date 2021/8/19 2:08 下午
 */


import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 在JMM中，可见性等同于多线程的通信机制
 *        意思就是，一个线程修改了共享变量，那么这个线程需要通知其他线程更新自己工作区域的共享变量值
 */
class MyNumber {

    int number = 10;

    public void addTo1205() {
        this.number = 1205;
    }
}

@Slf4j
public class JMMDemo {

    public static void main(String[] args) {

        MyNumber myNumber = new MyNumber();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNumber.addTo1205();
            System.out.println(Thread.currentThread().getName() + "\t" + myNumber.number);
        },"AAA").start();

        while (myNumber.number == 10) {
            // 这里如果使用了打印语句，那么就算没有加volatile 也会跳出while 循环的
                // 说法一：println方法中有synchronize代码块，影响了可见性。
        }
        // 如果没有加volatile 那么while会一直循环，不可见
        // 如果加了volatile  那么当线程A修改了number的值，那么会跳出while 循环  可见
        System.out.println(Thread.currentThread().getName() + "\t" + myNumber.number);
    }
}
