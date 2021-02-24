package com.example.demo.controller;

import com.example.demo.entity.AppNewConfigs;
import com.example.demo.service.AppNewConfigsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (AppNewConfigs)表控制层
 *
 * @author sunchuanyin
 * @since 2021-02-24 16:36:22
 */
@RestController
@RequestMapping("/appNewConfigs")
public class AppNewConfigsController {
    /**
     * 服务对象
     */
    @Autowired
    private AppNewConfigsService appNewConfigsServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public AppNewConfigs selectOne(Long id) {
        return this.appNewConfigsServiceImpl.queryById(id);
    }

}