package com.example.demo.dao;

import com.example.demo.entity.Apps;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Apps)表数据库访问层
 *
 * @author sunchuanyin
 * @since 2021-02-24 16:36:23
 */
@Repository
public interface AppsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Apps queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Apps> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param apps 实例对象
     * @return 对象列表
     */
    List<Apps> queryAll(Apps apps);

    /**
     * 新增数据
     *
     * @param apps 实例对象
     * @return 影响行数
     */
    int insert(Apps apps);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Apps> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Apps> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Apps> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Apps> entities);

    /**
     * 修改数据
     *
     * @param apps 实例对象
     * @return 影响行数
     */
    int update(Apps apps);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}