package com.example.demo.service;

import com.example.demo.entity.DistributorOrder;

import java.util.List;

/**
 * 渠道订购(DistributorOrder)表服务接口
 *
 * @author sunchuanyin
 * @since 2021-04-16 15:24:09
 */
public interface DistributorOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param distributorId 主键
     * @return 实例对象
     */
    DistributorOrder queryById(Integer distributorId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DistributorOrder> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param distributorOrder 实例对象
     * @return 实例对象
     */
    DistributorOrder insert(DistributorOrder distributorOrder);

    /**
     * 修改数据
     *
     * @param distributorOrder 实例对象
     * @return 实例对象
     */
    DistributorOrder update(DistributorOrder distributorOrder);

    /**
     * 通过主键删除数据
     *
     * @param distributorId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer distributorId);

}
