package com.example.demo.service.impl;

import com.example.demo.dao.PeopleDao;
import com.example.demo.entity.People;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (People)表服务实现类
 *
 * @author sunchuanyin
 * @since 2021-02-20 16:45:04
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public People queryById(Integer id) {
        return this.peopleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<People> queryAllByLimit(int offset, int limit) {
        return this.peopleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param people 实例对象
     * @return 实例对象
     */
    @Override
    public People insert(People people) {
        this.peopleDao.insert(people);
        return people;
    }

    /**
     * 修改数据
     *
     * @param people 实例对象
     * @return 实例对象
     */
    @Override
    public People update(People people) {
        this.peopleDao.update(people);
        return this.queryById(people.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.peopleDao.deleteById(id) > 0;
    }
}