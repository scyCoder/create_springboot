package com.example.demo.controller.abstra;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/5/31 1:38 下午
 */
public class HelloController {



    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("hello","123");
        getMap(map);
        System.out.println(map);
        String str = "a";
        getHello(str);
        System.out.println(str);
    }

    public static void getHello(String str) {
        str = "b";
    }

    public static void getMap(Map<String ,String> str) {
        str.put("hello","234");
        str.put("world","888");
    }
}
