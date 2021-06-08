package com.example.demo.service.impl;

import com.example.demo.entity.Orders;
import com.example.demo.dao.OrdersDao;
import com.example.demo.service.OrdersService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单表(Orders)表服务实现类
 *
 * @author sunchuanyin
 * @since 2021-06-08 09:35:54
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(Long id) {
        return this.ordersDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Orders> queryAllByLimit(int offset, int limit) {
        return this.ordersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders insert(Orders orders) {
        this.ordersDao.insert(orders);
        return orders;
    }

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders update(Orders orders) {
        this.ordersDao.update(orders);
        return this.queryById(orders.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.ordersDao.deleteById(id) > 0;
    }

    @Override
    public Orders queryByIdd(Long id) {
        return this.ordersDao.queryByIdd(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateOrder(Orders orders) {
        int result = ordersDao.updateOrder(orders);
        return result;
    }
}
