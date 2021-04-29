package com.example.demo.springcloudstream;

import com.google.j2objc.annotations.WeakOuter;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/29 2:50 下午
 */
public interface MqStream {

    /**
     * 发送类消息
     */
    String MY_TEST_PRODUCER_MESSAGE_OUT = "my-test-producer-message-out";

    @Output(MY_TEST_PRODUCER_MESSAGE_OUT)
    MessageChannel sendProducerMessage();

    /**
     * 接收消息
     */
    String MY_TEST_PRODUCER_MESSAGE_IN = "my-test-producer-message-in";

    @Input(MY_TEST_PRODUCER_MESSAGE_IN)
    SubscribableChannel receiveMessage();

}
