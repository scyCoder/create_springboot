package com.example.demo.mythread.threadpool;

import java.util.concurrent.*;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 通过构造方法手动创建线程池
 * @date 2021/8/11 1:53 下午
 */
public class CreateThreadPoolByThreadPoolExecutor {

    public static void main(String[] args) {

        /**
         * 最大线程数为5，阻塞队列为3，如果执行的任务超过最大线程数 + 阻塞队列的长度。是否报错要分析情况：
         *      1、程序执行速度很快，不会抛出异常
         *             打印结果：
         *                  pool-1-thread-2	办理业务2
         *                  pool-1-thread-3	办理业务6
         *                  pool-1-thread-1	办理业务1
         *                  pool-1-thread-3	办理业务4
         *                  pool-1-thread-2	办理业务3
         *                  pool-1-thread-4	办理业务7
         *                  pool-1-thread-5	办理业务8
         *                  pool-1-thread-3	办理业务9
         *                  pool-1-thread-1	办理业务5
         *
         *      2、程序执行速度满，触发了默认拒绝策略，抛出异常
         *              打印结果：
         *                  pool-1-thread-1	办理业务1
         *                  pool-1-thread-3	办理业务6
         *                  pool-1-thread-2	办理业务2
         *                  pool-1-thread-4	办理业务7
         *                  pool-1-thread-5	办理业务8
         *                  pool-1-thread-2	办理业务4
         *                  pool-1-thread-1	办理业务3
         *                  pool-1-thread-3	办理业务5
         *                  java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@402a079c rejected from java.util.concurrent.ThreadPoolExecutor@3fee9989[Running, pool size = 5, active threads = 0, queued tasks = 0, completed tasks = 8]
         *                  	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
         *                  	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
         *                  	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
         *                  	at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
         *                  	at com.example.demo.mythread.threadpool.CreateThreadPoolByThreadPoolExecutor.main(CreateThreadPoolByThreadPoolExecutor.java:44)
         */

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy()  // 任务数打到最大线程和满队列之和，抛出异常
                // new ThreadPoolExecutor.CallerRunsPolicy() // 将队列外的任务交给main线程执行
                // new ThreadPoolExecutor.DiscardOldestPolicy() // 抛弃队列中等待最久的任务，然后把当前任务加入队列中，尝试再次提交当前任务
                 new ThreadPoolExecutor.DiscardPolicy() // 该策略默默地丢弃无法处理的任务，不予任务处理也不抛出异常
        );
        try {

            // 模拟9个顾客，办理业务，最大只有5个业务员处理，候客区最多3个人
            for (int i = 1; i <= 9; i++) {
                int finalI = i;
                threadPool.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务" + finalI);
                });
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            threadPool.shutdown();
        }
    }
}
