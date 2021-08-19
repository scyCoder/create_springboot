package com.example.demo.jvm.gc;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description GC算法值引用计数法 不采用此种回收算法
 * @date 2021/8/18 4:55 下午
 */
public class ReferenceCounterGCDemo {

    private byte[] bigSize = new byte[2 * 1024 * 1024];
    Object instance = null;

    public static void main(String[] args) {
        ReferenceCounterGCDemo demoA = new ReferenceCounterGCDemo();
        ReferenceCounterGCDemo demoB = new ReferenceCounterGCDemo();

        // 互相引用
        demoA.instance = demoB;
        demoB.instance = demoA;
        demoA = null;
        demoB = null;

        // 手动开启gc回收，不是执行了这个代码就立刻执行垃圾回收
        System.gc();
    }
}
