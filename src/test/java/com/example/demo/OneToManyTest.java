package com.example.demo;

import com.example.demo.service.AppNewConfigsService;
import com.example.demo.service.AppsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/2/24 3:37 下午
 */
public class OneToManyTest extends DemoApplicationTests {

    @Autowired
    private AppsService appsServiceImpl;

    @Autowired
    private AppNewConfigsService appNewConfigsServiceImpl;

    /**
     * 一对多查询
     */
    @Test
    public void oneToManyTest() {

        System.out.println(appsServiceImpl.queryById(7l));
    }

    /**
     * 一对一查询
     */
    @Test
    public void oneToOneTest() {
        System.out.println(appNewConfigsServiceImpl.queryById(73l));
    }
}
