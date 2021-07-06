package com.example.demo.currentbookexample.test.chapter_10.transfermoney;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/7/1 2:46 下午
 */
public class TransferMoneyTest {

    private static final Object tieLock = new Object();

    /**
     * 不会产生死锁，因为使用了hashCode值判断，这样无论是A-->B,还是B-->A转账都是同一个fromAccount
     * @param fromAcct
     * @param toAcct
     * @param amount
     * @throws InsufficientFundsException
     */
    public void transferMoney(final Account fromAcct,
                              final Account toAcct,
                              final DollarAmount amount)
            throws InsufficientFundsException {
        class Helper {
            public void transfer() throws InsufficientFundsException {
                if (fromAcct.getBalance().compareTo(amount) < 0) {
                    throw new InsufficientFundsException();
                } else {
                    fromAcct.debit(amount);
                    toAcct.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAcct);
        System.out.println("线程名称：" + Thread.currentThread().getName() + "<===fromHash===>" + fromHash);
        int toHash = System.identityHashCode(toAcct);
        System.out.println("线程名称：" + Thread.currentThread().getName() + "<====toHash===>" + toHash);

        if (fromHash < toHash) {
            System.out.println("fromHash < toHash,线程名称：" + Thread.currentThread().getName());
            synchronized (fromAcct) {
                System.out.println("fromHash < toHash=====>fromAcct" + fromAcct + "线程名称：" + Thread.currentThread().getName());
                synchronized (toAcct) {
                    System.out.println("fromHash < toHash=====>toAcct" + toAcct + "线程名称：" + Thread.currentThread().getName());
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            System.out.println("fromHash > toHash，线程名称：" + Thread.currentThread().getName());

            synchronized (toAcct) {// 假设第一个线程（fromHash < toHash）先执行，那么toAcct的值就是第一个线程中的fromAcct，所以在同时执行是，谁先获得锁将会先执行，另一个只能等待
                System.out.println("fromHash > toHash=====>toAcct" + toAcct + "线程名称：" + Thread.currentThread().getName());
                synchronized (fromAcct) {
                    System.out.println("fromHash > toHash=====>fromAcct" + fromAcct + "线程名称：" + Thread.currentThread().getName());
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                System.out.println("fromHash == toHash，线程名称：" + Thread.currentThread().getName());
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }


    /**
     * 造成死锁
     * A-->B
     * B-->A
     * 在两个线程同时转账时，fromAccount不是同一个地址，A-->B fromAccount是fromAccount，而如果是B-->A，fromCount是toAccount
     * 这样就会因资源竞争而死锁
     *
     * @param fromAccount
     * @param toAccount
     * @param amount
     * @throws InsufficientFundsException
     */
    public void transferMoney1(Account fromAccount,
                               Account toAccount,
                               DollarAmount amount)
            throws InsufficientFundsException {
        synchronized (fromAccount) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + "===>" + fromAccount);
            synchronized (toAccount) {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "====》" + toAccount);
                if (fromAccount.getBalance().compareTo(amount) < 0) {
                    throw new InsufficientFundsException();
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }


    interface DollarAmount extends Comparable<DollarAmount> {
    }

    interface Account {
        void debit(DollarAmount d);

        void credit(DollarAmount d);

        DollarAmount getBalance();

        int getAcctNo();
    }

    class InsufficientFundsException extends Exception {
    }
}
