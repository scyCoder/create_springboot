package com.example.demo.threadslock;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Orders;
import com.example.demo.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/8 9:54 上午
 */
@Service
@Slf4j
public class OrderCallbackServiceImpl implements OrderCallBackService{

    @Autowired
    private OrdersService ordersServiceImpl;

    @Override
    public void orderCallBack(Long id) {
        log.info("当前线程：{},订购回调id: {}==========================================",Thread.currentThread().getName(),id);
        Orders order2 = ordersServiceImpl.queryById(id);
        log.info("当前线程：{},查询的订单数据：{}",Thread.currentThread().getName(),JSON.toJSON(order2));
        // 订购回调失败，更新订单状态为退款中
        // 订单失败，将订单状态改为退款中
        int resutl = updateOrder(order2);
        if (resutl == 0) {
            log.info("当前线程：{},多次推送，拒绝，order: {}==========================================",Thread.currentThread().getName(),JSON.toJSON(order2));
            return;
        }
        log.info("当前线程：{},退款流程==========================================",Thread.currentThread().getName());
    }

    private int updateOrder(Orders order2) {
        if (20 != order2.getState()) {
            log.info("当前线程：{},订购回调  订单非已支付状态，拒绝订购回调,order: {}==========================================",Thread.currentThread().getName(), JSON.toJSON(order2));
            return 0;
        } else {
            // 更新订单状态为退款中
            Orders orders = new Orders();
            orders.setState((byte)40);
            orders.setId(order2.getId());
            orders.setUpdatedAt(new Date());
            return ordersServiceImpl.updateOrder(orders);
        }
    }
}
