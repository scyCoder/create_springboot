package com.example.demo.service.impl;

import com.example.demo.entity.DistributorOrder;
import com.example.demo.dao.DistributorOrderDao;
import com.example.demo.service.DistributorOrderService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 渠道订购(DistributorOrder)表服务实现类
 *
 * @author sunchuanyin
 * @since 2021-04-16 15:24:09
 */
@Service
public class DistributorOrderServiceImpl implements DistributorOrderService {

    @Autowired
    private DistributorOrderDao distributorOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param distributorId 主键
     * @return 实例对象
     */
    @Override
    public DistributorOrder queryById(Integer distributorId) {
        return this.distributorOrderDao.queryById(distributorId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DistributorOrder> queryAllByLimit(int offset, int limit) {
        return this.distributorOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param distributorOrder 实例对象
     * @return 实例对象
     */
    @Override
    public DistributorOrder insert(DistributorOrder distributorOrder) {
        this.distributorOrderDao.insert(distributorOrder);
        return distributorOrder;
    }

    /**
     * 修改数据
     *
     * @param distributorOrder 实例对象
     * @return 实例对象
     */
    @Override
    public DistributorOrder update(DistributorOrder distributorOrder) {
        this.distributorOrderDao.update(distributorOrder);
        return this.queryById(distributorOrder.getDistributorId());
    }

    /**
     * 通过主键删除数据
     *
     * @param distributorId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer distributorId) {
        return this.distributorOrderDao.deleteById(distributorId) > 0;
    }
}
