package com.example.demo.currentbookexample.test.chapter_10.transfermoney;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/7/1 2:53 下午
 */
public class TransferMoneyTask implements Runnable{

    private TransferMoneyTest.Account fromAcct;
    private TransferMoneyTest.Account toAcct;
    private TransferMoneyTest.DollarAmount amount;

    public TransferMoneyTask(TransferMoneyTest.Account fromAcct, TransferMoneyTest.Account toAcct, TransferMoneyTest.DollarAmount amount) {
        this.fromAcct = fromAcct;
        this.toAcct = toAcct;
        this.amount = amount;
    }
    private TransferMoneyTest transferMoneyTest = new TransferMoneyTest();

    @Override
    public void run() {
        try {
            transferMoneyTest.transferMoney(fromAcct,toAcct,amount);
        } catch (TransferMoneyTest.InsufficientFundsException e) {
            e.printStackTrace();
        }
    }
}
