package com.example.demo.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/11 9:59 上午
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(0);
        Long l = 0L;
        if (l.equals(atomicLong)){
            synchronized (AtomicTest.class) {
                System.out.println("hello");
            }
        }
        System.out.println(l);
    }
}
