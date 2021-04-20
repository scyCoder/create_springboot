package com.example.demo.controller.abstra;

import org.springframework.context.annotation.Configuration;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/2 2:50 下午
 */
@Configuration
public class Test2Controller extends TestAbstractController {
    @Override
    public void hello() {
        System.out.printf("test2");
    }
}
