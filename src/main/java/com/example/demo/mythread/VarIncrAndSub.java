package com.example.demo.mythread;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 两个线程，对共享变量加、减
 * @date 2021/8/5 4:06 下午
 */

/**
 * 场景一：
 *      两个线程，A线程生产，加1    B线程消费，减1
 *      条件判断，使用if，没有问题，但是类多线程中条件判断应该使用while,防止虚假唤醒
 *
 * 场景二：
 *      四个线程：A/C线程生产，加1  B/D线程消费，减1
 *      条件判断，使用if,会出现虚假唤醒情况,应该使用while
 *
 *      多线程中互相通信，判断条件应该使用while
 *
 *
 *      操作步骤：
 *          1、高剧低合前提下，线程操作资源类
 *          2、判断/干活/通知
 *          3、防止虚假唤醒
 *
 *
 *
 *
 *   遇到的问题：
 *      1、认为两个线程分别操作加方法和减方法，认为不需要加锁。错误，在多线程操作资源类时，需要加上锁
 *      2、在等待唤醒时，只考虑了一半的情况，认为如果条件不满足加，就等待，那么减的方法线程就会抢到锁，然后唤醒加方法的线程。错误，因为是轮替10次，也就是不论是加方法
 *              还是减方法，都要经过while的条件判断后，wait和notify成对的出现，不然会报：IlleagalMonitorStateException
 *
 *      3、在没有给资源类中的加、减方法加锁时，会在main方法的for循环中判断条件，然后wait和notify
 *
 */

class Aircondition {
    private int number = 0;

    public synchronized void increment() throws Exception {
        // 判断 if 判断不可取
//        if (number != 0) {
//            this.wait();
//        }

        while (number != 0) {
            this.wait();
        }
        // 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 通知
        this.notifyAll();
    }

    public synchronized void decrement() throws Exception {

        // if判断不可取
//        if (number == 0) {
//            this.wait();
//        }

        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }
}

public class VarIncrAndSub {

    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "D").start();
    }
}
