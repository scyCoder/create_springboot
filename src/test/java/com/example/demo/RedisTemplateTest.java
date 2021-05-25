package com.example.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/5/24 4:45 下午
 */
public class RedisTemplateTest extends DemoApplicationTests{

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTemplateTest() {
        redisTemplate.opsForValue().set("sun","222",60, TimeUnit.SECONDS);
    }
}
