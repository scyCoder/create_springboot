package com.example.demo.service.impl.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/31 3:23 下午
 */
@Service
public class ThreadServiceTest {

    @Autowired
    private ThreadService threadService;


    public void threadServiceTest() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 5; i++) {
            executor.submit(threadService);
        }
    }

}
