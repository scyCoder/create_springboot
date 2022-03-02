package com.example.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2022/2/18 2:52 下午
 */
public class PrintTest {

    private Lock lock = new ReentrantLock();
    private int flag = 3;
    private int num = 1;
    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private int index = 0;
    private Condition conditionDigital = lock.newCondition();
    private Condition conditionLetter = lock.newCondition();

    public void printDigital() {
        lock.lock();
        try {
            while (flag != 3) {
                conditionDigital.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.print(num++);
            }
            flag = 1;
            conditionLetter.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void printLetter() {
        lock.lock();
        try {
            while (flag != 1) {
                conditionLetter.await();
            }
            System.out.print(letters[index]);
            index++;
            flag = 3;
            conditionDigital.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
