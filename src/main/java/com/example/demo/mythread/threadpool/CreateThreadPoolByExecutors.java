package com.example.demo.mythread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 通过使用Executors创建线程池,此种方式创建使用，不建议使用，要求使用ThreadPoolExecutor创建线程
 * @date 2021/8/11 1:53 下午
 */
public class CreateThreadPoolByExecutors {

    public static void main(String[] args) {

        // 创建固定工作线程数量的线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // 创建单例一个工作线程的线程池
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        // 创建可缓存、可扩容工作线程的线程池。这里是没有指定需要创建工作线程的大小。在遇到10个顾客需要处理业务时，会根据需求量创建线程（这里创建了10个工作线程）
        /**
         *      打印结果如下：
         *      pool-1-thread-1	办理业务1
         *      pool-1-thread-6	办理业务6
         *      pool-1-thread-5	办理业务5
         *      pool-1-thread-4	办理业务4
         *      pool-1-thread-2	办理业务2
         *      pool-1-thread-3	办理业务3
         *      pool-1-thread-7	办理业务7
         *      pool-1-thread-8	办理业务8
         *      pool-1-thread-9	办理业务9
         *      pool-1-thread-10	办理业务10
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();


        try {

            // 模拟10个顾客，办理业务，只有5个业务员处理
            for (int i = 1; i <= 10; i++) {
                int finalI = i;
                threadPool.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务" + finalI);
                    try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
