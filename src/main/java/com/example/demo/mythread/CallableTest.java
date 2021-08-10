package com.example.demo.mythread;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description Callable接口线程创建
 * @date 2021/8/9 2:50 下午
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


/**
 *  1、Callable 接口是在java.util.concurrent包中
 *  2、在new Thread()时，传入的是一个实现了Runnable接口的类，但是Callable接口不是，由此可以想到，会有一个中间类，将Thread和Callable连接起来，
 *  查看api可知，FutureTask实现类了RunnableFuture接口，而这个接口又是Runnable接口的子接口，所以可以使用new Thread()通过FutureTask使用Callable接口创建有返回值的线程
 */
class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("*******come in Callable" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(4);
        return 1024;
    }
}
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建线程
        FutureTask<Integer> futureTask = new FutureTask(new MyThread2());
//        FutureTask<Integer> futureTask2 = new FutureTask(new MyThread2());
        /**
         * 这里一个场景
         *      创建两个线程A、B，共用同一个futureTask对象，那么进入call()只有一次，也就是 "*******come in Callable" 只会打印一次
         */
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        System.out.println("main方法计算完成");

        // 获取返回值：
        // get 方法是阻塞方法，放在最后执行
        Integer integer = futureTask.get();
        System.out.println("integer = " + integer);
    }
}
