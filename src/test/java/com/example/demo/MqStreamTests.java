package com.example.demo;

import com.example.demo.springcloudstream.MqSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/29 3:22 下午
 */
public class MqStreamTests  extends DemoApplicationTests{

    @Autowired
    private MqSender mqSender;

    @Test
    public void sendProduceMessage() {
        mqSender.sendProduceMessage();
    }
}
