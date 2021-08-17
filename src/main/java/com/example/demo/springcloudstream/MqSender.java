package com.example.demo.springcloudstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/29 3:17 下午
 */
@Service
public class MqSender {

    @Autowired
    private MqStream mqStream;

    public void sendProduceMessage() {
        mqStream.sendProducerMessage().send(MessageBuilder.withPayload("hello world").build());
    }

    /**
     * mq延迟消息发送
     *  延迟时间：毫秒
     *  延迟发送mq消息遇到的问题
     *      1、使用延迟的mq消息需要安装rabbitmq插件：rabbitmq_delayed_message_exchange
     *           具体的实现，参考博客：https://blog.didispace.com/spring-cloud-starter-finchley-7-7/
     *      2、在项目启动会报错：Channel shutdown: channel error; protocol method: #method<channel.close>(reply-code=406, reply-text=PRECONDITION_FAILED - inequivalent arg 'type' for exchange 'delay-topic' in vhost '/': received 'topic' but current is ''x-delayed-message'', class-id=40, method-id=10)
     *          两个原因：
     *              1、在mq中已经有了一个exchanges，而且这个exchanges的type是direct，而延迟消息用的是x-delayed-message，解决这个方法：1、删除这个exchanges 2、重新换一个exchange的名字
     *              2、在配置文件中没有配置生产者和消费者延迟的配置
     */
    public void sendProduceMessageDeLay() {
        mqStream.sendProducerMessage().send(MessageBuilder.withPayload("hello").setHeader("x-delay",1000).build());
    }

}
