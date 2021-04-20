package com.example.demo.service;

import com.example.demo.service.impl.Hello;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 一个类实现了一个带泛型的接口，那么这个类也要是泛型类型的
 * @date 2021/3/12 2:40 下午
 */
public class World<T> implements Hello<T> {
}
