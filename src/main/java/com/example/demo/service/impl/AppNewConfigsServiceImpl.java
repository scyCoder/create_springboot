package com.example.demo.service.impl;

import com.example.demo.dao.AppNewConfigsDao;
import com.example.demo.entity.AppNewConfigs;
import com.example.demo.service.AppNewConfigsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (AppNewConfigs)表服务实现类
 *
 * @author sunchuanyin
 * @since 2021-02-24 16:36:22
 */
@Service
public class AppNewConfigsServiceImpl implements AppNewConfigsService {
    @Autowired
    private AppNewConfigsDao appNewConfigsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AppNewConfigs queryById(Long id) {
        return this.appNewConfigsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AppNewConfigs> queryAllByLimit(int offset, int limit) {
        return this.appNewConfigsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param appNewConfigs 实例对象
     * @return 实例对象
     */
    @Override
    public AppNewConfigs insert(AppNewConfigs appNewConfigs) {
        this.appNewConfigsDao.insert(appNewConfigs);
        return appNewConfigs;
    }

    /**
     * 修改数据
     *
     * @param appNewConfigs 实例对象
     * @return 实例对象
     */
    @Override
    public AppNewConfigs update(AppNewConfigs appNewConfigs) {
        this.appNewConfigsDao.update(appNewConfigs);
        return this.queryById(appNewConfigs.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.appNewConfigsDao.deleteById(id) > 0;
    }
}