package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/16 10:39 上午
 */
public class TestTest {

    private static final Map<String,String> map = new HashMap<>();

    private static  final  int a = 1;

    private  final List<String> list;

    public TestTest(List<String> list) {
        this.list = list;
    }

    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        TestTest testTest = new TestTest(list1);
        TestTest testTest1 = new TestTest(list2);
        System.out.println(testTest);
        System.out.println(testTest1);

//        map.put("1","2");
//
//        hello();
//        System.out.println(map);
    }

    public static void hello() {
        // map = new HashMap<>();
        map.put("1","3");
    }
}
