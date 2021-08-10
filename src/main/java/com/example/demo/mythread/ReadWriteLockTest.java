package com.example.demo.mythread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 读写锁
 * @date 2021/8/10 3:04 下午
/**
 * // 模拟数据缓存类
 *
 * 第一种情况：
 *      没有加锁，出现的问题：
 *          数据没有一致性，打印结果：也就是在 线程为 1的时候，1线程在写入，还没有写入完成，就有其他的线程来写操作
 *              1	写入数据：key= 1
 *              4	写入数据：key= 4
 *              3	写入数据：key= 3
 *              5	写入数据：key= 5
 *              2	写入数据：key= 2
 *              1	读取数据：key= 1
 *              2	读取数据：key= 2
 *              3	读取数据：key= 3
 *              4	读取数据：key= 4
 *              5	读取数据：key= 5
 *              2	写入完成：key= 2
 *              1	写入完成：key= 1
 *              4	读取完成：key= 4value = null
 *              3	读取完成：key= 3value = null
 *              2	读取完成：key= 2value = null
 *              5	写入完成：key= 5
 *              3	写入完成：key= 3
 *              4	写入完成：key= 4
 *              1	读取完成：key= 1value = null
 *              5	读取完成：key= 5value = 5
 */
//class MyCache{
//
//    private volatile Map<String,Object> map = new HashMap<>();
//
//    public void put(String key,Object value) {
//        System.out.println(Thread.currentThread().getName() + "\t写入数据：key= " + key);
//        try {
//            TimeUnit.MILLISECONDS.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        map.put(key,value);
//        System.out.println(Thread.currentThread().getName() + "\t写入完成：key= " + key);
//    }
//
//    public void get(String key) {
//        System.out.println(Thread.currentThread().getName() + "\t读取数据：key= " + key);
//        try {
//            TimeUnit.MILLISECONDS.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Object value = map.get(key);
//        System.out.println(Thread.currentThread().getName() + "\t读取完成：key= " + key + "value = " + value);
//    }
//
//}

/**
 * 第二种情况：
 *      加上读写锁，在多线程中读取的时候共用锁，写的时候独占锁，保证数据的一致性
 *
 *      打印结果：
 *          1	写入数据：key= 1
 *          1	写入完成：key= 1
 *
 *          2	写入数据：key= 2
 *          2	写入完成：key= 2
 *          3	写入数据：key= 3
 *          3	写入完成：key= 3
 *          4	写入数据：key= 4
 *          4	写入完成：key= 4
 *          5	写入数据：key= 5
 *          5	写入完成：key= 5
 *          1	读取数据：key= 1
 *          2	读取数据：key= 2
 *          3	读取数据：key= 3
 *          5	读取数据：key= 5
 *          4	读取数据：key= 4
 *          3	读取完成：key= 3value = 3
 *          5	读取完成：key= 5value = 5
 *          4	读取完成：key= 4value = 4
 *          1	读取完成：key= 1value = 1
 *          2	读取完成：key= 2value = 2
 */
class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        // 写操作，加入写锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t写入数据：key= " + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入完成：key= " + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        // 读操作，加入读锁
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t读取数据：key= " + key);
            TimeUnit.MILLISECONDS.sleep(300);
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成：key= " + key + "value = " + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}

public class ReadWriteLockTest {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        // 五个写入数据线程
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> myCache.put(finalI + "", finalI), String.valueOf(i)).start();
        }

        // 五个读取数据线程
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> myCache.get(finalI + ""), String.valueOf(i)).start();
        }
    }
}
