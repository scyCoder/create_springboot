package com.example.demo.threadslock;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Orders;
import com.example.demo.service.impl.OrdersServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/8 9:30 上午
 */
@Slf4j
@Service
public class ThreadsLock implements Runnable{

    @Autowired
    private OrderCallBackService orderCallBackServiceImpl;

    @Override
    public void run() {
        orderCallBackServiceImpl.orderCallBack(7602L);
    }
}
