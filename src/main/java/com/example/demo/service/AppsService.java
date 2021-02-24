package com.example.demo.service;

import com.example.demo.entity.Apps;

import java.util.List;

/**
 * (Apps)表服务接口
 *
 * @author sunchuanyin
 * @since 2021-02-24 16:36:23
 */
public interface AppsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Apps queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Apps> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param apps 实例对象
     * @return 实例对象
     */
    Apps insert(Apps apps);

    /**
     * 修改数据
     *
     * @param apps 实例对象
     * @return 实例对象
     */
    Apps update(Apps apps);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}