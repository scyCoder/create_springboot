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

}
