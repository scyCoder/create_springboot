package com.example.demo.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/23 11:18 上午
 */
@Configuration
@ConditionalOnProperty(value = "system.test",havingValue = "true",matchIfMissing = true)
public class TestAnnotaionConditionalOnProperties {

    public TestAnnotaionConditionalOnProperties() {
        System.out.println("TestAnnotaionConditionalOnProperties=》()注入");
    }

    public String hello() {
        return "hello";
    }
}
