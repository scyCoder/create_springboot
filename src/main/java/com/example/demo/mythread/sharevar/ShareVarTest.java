package com.example.demo.mythread.sharevar;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/6/16 3:49 下午
 */
public class ShareVarTest {

    private static boolean b;
    private static int number;

    public static void main(String[] args) {

        new ShareVar().start();
        number = 42;
        b = true;

    }

    public static boolean isB() {
        return b;
    }

    public static void setB(boolean b) {
        ShareVarTest.b = b;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        ShareVarTest.number = number;
    }
}
