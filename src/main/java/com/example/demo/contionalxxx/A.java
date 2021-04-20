package com.example.demo.contionalxxx;

import lombok.Data;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/9 3:40 下午
 */
@Data
public class A {

    private String name;

    public A() {

        System.out.println("conditional=>A()");
    }
}
