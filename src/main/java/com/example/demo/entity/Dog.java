package com.example.demo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/5/10 1:57 下午
 */
@Data
public class Dog {

    private int level;
    private String name;
}

class test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setLevel(3);
        dog.setName("3");

        Dog dog1 = new Dog();
        dog1.setLevel(2);
        dog1.setName("2");

        List<Dog> dogList = new ArrayList<>();
        dogList.add(dog);
        dogList.add(dog1);
//        Map<Integer, Dog> collect = dogList.stream().collect(Collectors.toMap(Dog::getLevel, a -> a, (k1, k2) -> k1));
//        int size = collect.keySet().size();
//        System.out.println(size);
//        System.out.println(collect);
        dogList.stream().sorted(Comparator.comparing(Dog::getLevel).reversed()).collect(Collectors.toList());
        System.out.println(dogList);
    }
}
