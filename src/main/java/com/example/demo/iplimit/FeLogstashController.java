package com.example.demo.iplimit;


import com.example.demo.response.ActionResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.http.HttpStatus;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 前端日志上传ELK系统
 *
 *   限流脚本
 *      1、使用.lua脚本操作redis保证原子性
 *      2、redisTemplate 需要设置，在启动类中
 *
 * @author sunchuanyin
 * @version 1.0
 * @date 2020/11/6 3:43 下午
 */
@Slf4j
@RestController
@RequestMapping("/fe-logstash")
public class FeLogstashController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * IP计数key值后缀
     */
    private static final String COUNT_SUFFIX = "_count_fe_logstash";

    /**
     * 同一个IP一分钟内请求的最大次数不能超过50
     */
    private static final Integer MAX_REQUEST_COUNT = 50;

    /**
     * 限时60秒
     */
    private static final Integer TIME = 60;

    /**
     * 请求日志参数不能超过300KB
     */
    private static final Integer FE_LOG_SIZE = 300 * 1024;

    private DefaultRedisScript<Long> script;


    /**
     * 初始化LUA脚本
     */
    @PostConstruct
    private void init() {
        script = new DefaultRedisScript<Long>();
        script.setResultType(Long.class);
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("iplimit.lua")));
    }


    /**
     * 前端日志上传ELK
     *
     * @param request
     * @param feLog
     * @return
     */
    @PostMapping("/uploadLog")
    public ActionResponse uploadLog(HttpServletRequest request, @RequestBody String feLog) {

        // 一、校验数据大小（超过300k，拒绝）
        if (feLog.getBytes(StandardCharsets.UTF_8).length > FE_LOG_SIZE) {
            log.error("日志大小超过300KB,拒绝请求");
            return ActionResponse.error(HttpStatus.PAYLOAD_TOO_LARGE);
        }

        // 二、校验IP限时限量
        String ip = this.getIp(request);
        List<String> keys = new ArrayList<>();
        keys.add(ip + COUNT_SUFFIX);
        // returnCode: 1：请求超限，拒绝  0：允许
        Long returnCode = redisTemplate.execute(script, keys, TIME, MAX_REQUEST_COUNT);
        if (0 != returnCode.intValue()) {
            log.error("IP为{},在一分钟内请求超过{}次，拒绝请求", ip, MAX_REQUEST_COUNT);
            return ActionResponse.error(HttpStatus.TOO_MANY_REQUESTS);
        }

        // 日志上传ELK
        log.info("前端日志上传ELK：{}",feLog);
        return ActionResponse.success(HttpStatus.OK);
    }

    /**
     * 获取用户IP
     *
     * @param request
     * @return
     */
    public String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip)) {
            String remoteAddr = request.getRemoteAddr();
            return remoteAddr;
        }
        // split
        if (ip.length() > 0 && ip.contains(",")) {
            String realIp = ip.split(",")[0];
            return Optional.ofNullable(realIp).orElse("");
        }
        return Optional.of(ip).orElse("");
    }

}
