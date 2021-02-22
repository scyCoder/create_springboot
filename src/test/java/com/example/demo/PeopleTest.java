package com.example.demo;

import com.example.demo.entity.People;
import com.example.demo.service.PeopleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/2/20 3:51 下午
 */
public class PeopleTest extends DemoApplicationTests {

    @Autowired
    private PeopleService peopleServiceImpl;

    @Test
    public void getPeople() {
        People people = peopleServiceImpl.queryById(1);
        System.out.println(people);

    }
}
