package com.example.demo.contionalxxx;

import lombok.Data;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/9 3:41 下午
 */
@Data
public class B {


    private A a;

    public B() {

        System.out.println("conditional=>B()");
    }
}
