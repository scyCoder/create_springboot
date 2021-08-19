package com.example.demo.jvm;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description jvm  堆内存调优
 * @date 2021/8/18 3:16 下午
 */
public class HeapMemoryDemo {

    public static void main(String[] args) {
        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
        long maxMemory = Runtime.getRuntime().maxMemory();
        // 堆内存的初始大小
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx:MAX_MEMORY:" + (maxMemory / (double) 1024 / 1024) + "MB");
        System.out.println("-Xms:TOTAL_MEMORY:" + (totalMemory / (double) 1024 / 1024) + "MB");
    }
}
