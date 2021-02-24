package com.example.demo.service.impl;

import com.example.demo.dao.AppsDao;
import com.example.demo.entity.Apps;
import com.example.demo.service.AppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Apps)表服务实现类
 *
 * @author sunchuanyin
 * @since 2021-02-24 16:36:23
 */
@Service
public class AppsServiceImpl implements AppsService {
    @Autowired
    private AppsDao appsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Apps queryById(Long id) {
        return this.appsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Apps> queryAllByLimit(int offset, int limit) {
        return this.appsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param apps 实例对象
     * @return 实例对象
     */
    @Override
    public Apps insert(Apps apps) {
        this.appsDao.insert(apps);
        return apps;
    }

    /**
     * 修改数据
     *
     * @param apps 实例对象
     * @return 实例对象
     */
    @Override
    public Apps update(Apps apps) {
        this.appsDao.update(apps);
        return this.queryById(apps.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.appsDao.deleteById(id) > 0;
    }
}