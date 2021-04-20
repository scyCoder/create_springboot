package com.example.demo.controller;

import com.example.demo.entity.DistributorOrder;
import com.example.demo.service.DistributorOrderService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 渠道订购(DistributorOrder)表控制层
 *
 * @author sunchuanyin
 * @since 2021-04-16 15:24:10
 */
@RestController
@RequestMapping("/distributorOrder")
public class DistributorOrderController {

    @Autowired
    private DistributorOrderService distributorOrderServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public DistributorOrder selectOne(Integer id) {
        return this.distributorOrderServiceImpl.queryById(id);
    }

}
