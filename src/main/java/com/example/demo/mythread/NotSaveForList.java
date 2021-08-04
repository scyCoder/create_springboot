package com.example.demo.mythread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description list 集合不安全演示，和线程安全解决
 * @date 2021/8/4 5:28 下午
 */

/**
 *1、 List<String> list = new ArrayList<>();
 *      线程不安全，报错：ConcurrentModificationException
 *
 * 2、new Vector
 *      线程安全，底层加了锁，但是效率不高
 *
 * 3、 Collections.synchronizedList(new ArrayList<>());
 *      线程安全
 *
 * 4、new CopyOnWriteArrayList<>();
 *      线程安全，使用了ReentrantLock
 */

public class NotSaveForList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
}
