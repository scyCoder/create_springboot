package com.example.demo.currentbookexample.test.chapter_10.transfermoney;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 通过锁的hashcode 来判断锁的执行顺序，避免死锁
 * @date 2021/7/1 2:56 下午
 */
public class TransferMoneyMain {

    public static void main(String[] args) {
        TransferMoneyTest.Account fromAccout = new TransferMoneyTest.Account() {
            @Override
            public void debit(TransferMoneyTest.DollarAmount d) {

            }

            @Override
            public void credit(TransferMoneyTest.DollarAmount d) {

            }

            @Override
            public TransferMoneyTest.DollarAmount getBalance() {
                return null;
            }

            @Override
            public int getAcctNo() {
                return 0;
            }
        };

        TransferMoneyTest.Account toAccount = new TransferMoneyTest.Account() {
            @Override
            public void debit(TransferMoneyTest.DollarAmount d) {

            }

            @Override
            public void credit(TransferMoneyTest.DollarAmount d) {

            }

            @Override
            public TransferMoneyTest.DollarAmount getBalance() {
                return null;
            }

            @Override
            public int getAcctNo() {
                return 0;
            }
        };

        TransferMoneyTest.DollarAmount dollarAmount = new TransferMoneyTest.DollarAmount() {
            @Override
            public int compareTo(TransferMoneyTest.DollarAmount o) {
                return 0;
            }
        };

        new Thread(new TransferMoneyTask(fromAccout,toAccount,dollarAmount),"from==>to").start();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(new TransferMoneyTask(toAccount,fromAccout,dollarAmount),"to==>from").start();
    }
}
