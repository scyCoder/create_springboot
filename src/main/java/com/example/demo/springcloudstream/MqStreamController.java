package com.example.demo.springcloudstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/29 3:53 下午
 */
@RestController
@RequestMapping("/MyStream")
public class MqStreamController {

    @Autowired
    private MqSender mqSender;

    @RequestMapping("/send")
    public void myStream() {
        mqSender.sendProduceMessage();
    }
}
