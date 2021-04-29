package com.example.demo.springcloudstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.example.demo.springcloudstream.MqStream.MY_TEST_PRODUCER_MESSAGE_IN;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/29 4:40 下午
 */
@Component
public class MqListener {

    @Autowired
    private MqStream mqStream;

    @StreamListener(MY_TEST_PRODUCER_MESSAGE_IN)
    public void receiveMessage(@Payload String message) {
        System.out.println("**********************************************");
        System.out.println("监听的消息：" + message);
    }
}
