package com.example.demo.controller;

import com.example.demo.entity.Apps;
import com.example.demo.service.AppsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Apps)表控制层
 *
 * @author sunchuanyin
 * @since 2021-02-24 16:36:24
 */
@Api("app接口")
@RestController
@RequestMapping("/apps")
public class AppsController {
    /**
     * 服务对象
     */
    @Autowired
    private AppsService appsServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("未登录默认渠道")
    @GetMapping("/selectOne")
    public Apps selectOne(Long id) {
        return this.appsServiceImpl.queryById(id);
    }

}