package com.example.demo.jvm;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description jvm  相关代码
 * @date 2021/8/17 2:15 下午
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {

        Object object = new Object();
        // 获取启动类加载器 null 值
        System.out.println(object.getClass().getClassLoader());

        // 获取应用程序加载器  sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoaderDemo hello = new ClassLoaderDemo();
        System.out.println(hello.getClass().getClassLoader());
        // 获取应用程序加载器的上一级（扩展类加载器）sun.misc.Launcher$ExtClassLoader@3f3afe78
        System.out.println(hello.getClass().getClassLoader().getParent());

        // 获取应用程序加载器的上一级的上一级（获取启动类加载器） null
        System.out.println(hello.getClass().getClassLoader().getParent().getParent());
    }
}
