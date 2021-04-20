package com.example.demo.contionalxxx;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/9 3:43 下午
 */
@Configuration
public class ConditionalConfig {

    @Bean
    public A a() {
        return new A();
    }

    //@ConditionalOnBean(A.class) 依赖的been存在时，才会注入spring中
    @ConditionalOnMissingBean(A.class) // 依赖的been不存在时，会注入spring中,如果依赖的been存在，则不会实例化been(注入spring中)
    @Bean
    public B b() {
        return new B();
    }
}
