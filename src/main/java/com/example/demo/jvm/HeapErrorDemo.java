package com.example.demo.jvm;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 演示ooM
 * @date 2021/8/18 3:50 下午
 */

import java.util.Random;

/**
 * 第一步：将jvm堆内存调小
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 *
 */


/**
 * 打印输出
 *          [GC (Allocation Failure) [PSYoungGen: 2048K->502K(2560K)] 2048K->754K(9728K), 0.0011764 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 2550K->486K(2560K)] 2802K->1037K(9728K), 0.0009752 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 2492K->480K(2560K)] 3043K->1330K(9728K), 0.0007832 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 2486K->486K(2560K)] 3335K->1789K(9728K), 0.0009259 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 2214K->486K(2560K)] 3517K->2243K(9728K), 0.0010267 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 1785K->486K(1536K)] 5230K->3939K(8704K), 0.0005042 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 *          [GC (Allocation Failure) --[PSYoungGen: 1348K->1348K(1536K)] 7333K->7723K(8704K), 0.0043675 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *          [Full GC (Ergonomics) [PSYoungGen: 1348K->0K(1536K)] [ParOldGen: 6375K->3372K(7168K)] 7723K->3372K(8704K), [Metaspace: 3011K->3011K(1056768K)], 0.0142775 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 10K->32K(2048K)] 6758K->6779K(9216K), 0.0004067 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *          [Full GC (Ergonomics) [PSYoungGen: 32K->0K(2048K)] [ParOldGen: 6747K->4999K(7168K)] 6779K->4999K(9216K), [Metaspace: 3011K->3011K(1056768K)], 0.0096497 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 18K->32K(2048K)] 6706K->6719K(9216K), 0.0005051 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 *          [Full GC (Ergonomics) [PSYoungGen: 32K->0K(2048K)] [ParOldGen: 6687K->2467K(7168K)] 6719K->2467K(9216K), [Metaspace: 3011K->3011K(1056768K)], 0.0061604 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4154K->4154K(9216K), 0.0003906 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4154K->4154K(9216K), 0.0003404 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *          [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4154K->4154K(7168K)] 4154K->4154K(9216K), [Metaspace: 3011K->3011K(1056768K)], 0.0021565 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
 *          [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4154K->4154K(9216K), 0.0003266 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 *          [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4154K->4137K(7168K)] 4154K->4137K(9216K), [Metaspace: 3011K->3011K(1056768K)], 0.0119268 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 *          Heap
 *           PSYoungGen      total 2048K, used 71K [0x00000007bfd00000, 0x00000007c0000000, 0x00000007c0000000)
 *            eden space 1024K, 6% used [0x00000007bfd00000,0x00000007bfd11d40,0x00000007bfe00000)
 *            from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 *            to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 *           ParOldGen       total 7168K, used 4137K [0x00000007bf600000, 0x00000007bfd00000, 0x00000007bfd00000)
 *            object space 7168K, 57% used [0x00000007bf600000,0x00000007bfa0a6d8,0x00000007bfd00000)
 *           Metaspace       used 3043K, capacity 4556K, committed 4864K, reserved 1056768K
 *            class space    used 318K, capacity 392K, committed 512K, reserved 1048576K
 *          Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *          	at java.util.Arrays.copyOf(Arrays.java:3332)
 *          	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
 *          	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:448)
 *          	at java.lang.StringBuilder.append(StringBuilder.java:136)
 *          	at com.example.demo.jvm.HeapErrorDemo.main(HeapErrorDemo.java:28)
 *          Disconnected from the target VM, address: '127.0.0.1:55256', transport: 'socket'
 */

public class HeapErrorDemo {

    public static void main(String[] args) {

        // 第一种方式：创建的对象大于了堆内存的最大化大小
        // byte str[] = new byte[40 * 1024 * 1024];

        // 第二种方式
        String str = "";
        while (true) {
            str += str + new Random().nextInt(8888888) + new Random().nextInt(9999999);
        }
    }
}
