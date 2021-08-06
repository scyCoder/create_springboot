package com.example.demo.mythread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description ReentrantLock 和 Condition多线程之间的定点通知
 * @date 2021/8/6 3:05 下午
 */

/**
 * A线程打印5次 ,B线程打印10次，C线程打印15次，A->B->C 交替10次
 */
class PrintLog {
    private int size = 5; // 标志位，判断条件
    private Lock lock = new ReentrantLock();
    // 对于不同的线程，选择对应的condition,以便定向等待和通知
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public void printLogByA() {
        lock.lock();
        try {
            while (size != 5) {
                conditionA.await();
            }
            for (int i = 0; i < size; i++) {
                System.out.println("AA");
            }
            size = 10;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printLogByB() {
        lock.lock();
        try {
            while (size != 10) {
                conditionB.await();
            }
            for (int i = 0; i < size; i++) {
                System.out.println("BB");
            }
            size = 15;
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printLogByC() {
        lock.lock();
        try {
            while (size != 15) {
                conditionC.await();
            }
            for (int i = 0; i < size; i++) {
                System.out.println("CC");
            }
            size = 5;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printLog() {
        lock.lock();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockDingDianNotify {
    public static void main(String[] args) {
        PrintLog printLog = new PrintLog();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printLog.printLogByA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printLog.printLogByB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                printLog.printLogByC();
            }
        }, "C").start();
    }
}
