package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Orders;
import com.example.demo.service.OrderService;
import com.example.demo.service.OrdersService;
import com.example.demo.threadslock.OrderCallBackService;
import com.example.demo.threadslock.ThreadsLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/8 9:40 上午
 */
@Slf4j
public class ThreadsLockTest extends DemoApplicationTests{

    @Autowired
    private OrdersService ordersServiceImpl;

    @Autowired
    private OrderCallBackService orderCallBackServiceImpl;

    @Autowired
    private ThreadsLock threadsLock;

    @Test
    public void threadLock() {

        Thread thread = new Thread(threadsLock);
        thread.start();
        orderCallBackServiceImpl.orderCallBack(7602l);


    }
}
