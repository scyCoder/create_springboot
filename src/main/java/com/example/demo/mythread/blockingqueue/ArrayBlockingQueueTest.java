package com.example.demo.mythread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 阻塞队列
 * @date 2021/8/10 5:49 下午
 */

/**
 * 阻塞队列中的api 有三种情况
 *      第一种：超过有界值，抛出异常
 *          add 返回boolean
 *          remove 返回队列头元素
 *          element：检索队列头元素，不是删除。。。。如果队列为空，则会抛出异常      （可以理解为队列是否为空）    返回头元素
 *      第二种：超出有界值，不跑异常，返回false 或 null
 *          offer  返回boolean
 *          poll   返回队列头元素
 *          peek   与element作用一样,只不过，peek检索的队列如果没有数据，将返回null，返回头元素
 *      第三中：超出有界值，阻塞等待，永远等待
 *          put   void
 *          take  返回队列头元素
 *      第四种：超出有界值，在规定的时间内阻塞等待，时间一到，将不会等待
 *          offer(e,time,unit) 返回true / false
 *          poll(time,unit)  返回队列头元素 / null
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        // 创建有界的阻塞队列，默认有界值为 3
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);


        /**
         * 第一种
         */
/*        // 添加三个元素，返回true
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        // 再添加第四个，将会报异常：IllegalStateException
//        System.out.println(blockingQueue.add("d"));

        // 移除元素，返回的是队列头元素
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        // 在移除第四个元素，报异常：NoSuchElementException
//        System.out.println(blockingQueue.remove());

        // 检索队列头元素,如果队列为空，则抛出异常：NoSuchElementException
        System.out.println(blockingQueue.element());*/


        /**
         * 第二种
         */
/*        // 添加元素
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        // 添加第四个元素，超过了有界值，没有报异常，返回false
//        System.out.println(blockingQueue.offer("d"));

        // 移除元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        // 移除第四个元素,没有报异常，返回null
        System.out.println(blockingQueue.poll());

        // 检索元素,队列为空，返回null
        System.out.println(blockingQueue.peek());*/

        /**
         * 第三种
         */
/*        // 添加元素，添加三个元素，到达队列的有界值，程序退出
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");

        // 在添加第四个元素，超出了队列的有界值，程序阻塞等待
//        blockingQueue.put("a");

        // 移除
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

        // 移除第四个元素，因队列没有数据，所以程序阻塞等待
        System.out.println(blockingQueue.take());*/

        /**
         * 第四种
         */
        // 添加元素
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        // 在队列已满，添加第一个元素时，将会等待3秒，如果3秒内队列仍没有空位，则不会继续等待,返回false
        System.out.println(blockingQueue.offer("d", 3L, TimeUnit.SECONDS));

        // 移除元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 在移除第四个元素时，等待3秒，如果3秒内仍没有元素，则退出等待，返回null
        System.out.println(blockingQueue.poll(3L, TimeUnit.SECONDS));
    }
}
