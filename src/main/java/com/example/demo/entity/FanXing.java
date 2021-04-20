package com.example.demo.entity;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/12 2:28 下午
 */
public class FanXing<T> {

    private T hello;

    public FanXing(T hello) {
        this.hello = hello;
    }


    public T getT() {
        return hello;
    }



    public <T extends Hello> boolean xianXian(T hello) {
        return  true;
    }

    public static void main(String[] args) {
    }

}
