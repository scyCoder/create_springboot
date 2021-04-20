package com.example.demo.dao;

import com.example.demo.entity.DistributorOrder;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 渠道订购(DistributorOrder)表数据库访问层
 *
 * @author sunchuanyin
 * @since 2021-04-16 15:24:09
 */
@Repository
public interface DistributorOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param distributorId 主键
     * @return 实例对象
     */
    DistributorOrder queryById(Integer distributorId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DistributorOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param distributorOrder 实例对象
     * @return 对象列表
     */
    List<DistributorOrder> queryAll(DistributorOrder distributorOrder);

    /**
     * 新增数据
     *
     * @param distributorOrder 实例对象
     * @return 影响行数
     */
    int insert(DistributorOrder distributorOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DistributorOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DistributorOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DistributorOrder> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DistributorOrder> entities);

    /**
     * 修改数据
     *
     * @param distributorOrder 实例对象
     * @return 影响行数
     */
    int update(DistributorOrder distributorOrder);

    /**
     * 通过主键删除数据
     *
     * @param distributorId 主键
     * @return 影响行数
     */
    int deleteById(Integer distributorId);

}

