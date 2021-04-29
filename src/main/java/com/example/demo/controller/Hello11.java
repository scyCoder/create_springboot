package com.example.demo.controller;

import com.example.demo.entity.People;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/2/23 10:21 上午
 */

/**
 * 抽象类可以实现接口，可已继承其他类，也ç可以有main方法
 */
public abstract class Hello11 extends People {

    static  int x,y;
    public static void main(String[] args) {

      x--;
        System.out.println(x);
      testmethod();
        System.out.println(x + y++ + x);
    }

    private static void testmethod() {
        System.out.println(x);
        y=x++ + ++x;
    }

}
