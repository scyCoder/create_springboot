package com.example.demo.conf;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/12 11:13 上午
 */
@Configuration
public class TestSetDefaultValue {


    public static final Map<String, Object> defaultMap = new HashMap<>();

    public Map<String, Object> getDefaultMap() {
        defaultMap.put("hello", "world");
        defaultMap.put("1", "2");
        return defaultMap;
    }
}
