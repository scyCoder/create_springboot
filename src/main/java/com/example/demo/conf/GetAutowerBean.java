package com.example.demo.conf;

import com.example.demo.service.AppsService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 启动加载
 *
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/10 2:47 下午
 */
@Component
public class GetAutowerBean implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Collection<AppsService> values = applicationContext.getBeansOfType(AppsService.class).values();
        System.out.println("GetAutowerBean-》setApplicationContext-》实现ApplicationContextAware，服务启动加载，获得注入的been");
        System.out.print("注入的been对象：");
        values.forEach(System.out::println);
    }
}
