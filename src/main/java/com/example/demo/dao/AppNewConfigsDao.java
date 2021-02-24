package com.example.demo.dao;

import com.example.demo.entity.AppNewConfigs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (AppNewConfigs)表数据库访问层
 *
 * @author sunchuanyin
 * @since 2021-02-24 16:36:22
 */
@Repository
public interface AppNewConfigsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppNewConfigs queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AppNewConfigs> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param appNewConfigs 实例对象
     * @return 对象列表
     */
    List<AppNewConfigs> queryAll(AppNewConfigs appNewConfigs);

    /**
     * 新增数据
     *
     * @param appNewConfigs 实例对象
     * @return 影响行数
     */
    int insert(AppNewConfigs appNewConfigs);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AppNewConfigs> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AppNewConfigs> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AppNewConfigs> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AppNewConfigs> entities);

    /**
     * 修改数据
     *
     * @param appNewConfigs 实例对象
     * @return 影响行数
     */
    int update(AppNewConfigs appNewConfigs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}