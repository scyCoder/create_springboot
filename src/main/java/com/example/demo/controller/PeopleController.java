package com.example.demo.controller;

import com.example.demo.entity.People;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (People)表控制层
 *
 * @author sunchuanyin
 * @since 2021-02-20 16:45:04
 */
@RestController
@RequestMapping("/people")
public class PeopleController {
    /**
     * 服务对象
     */
    @Autowired
    private PeopleService peopleServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public People selectOne(Integer id) {
        return this.peopleServiceImpl.queryById(id);
    }

}