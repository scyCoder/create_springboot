package com.example.demo.conf;

import com.example.demo.intercept.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/11 11:21 上午
 */
@Configuration
public class InterceptorConfigTest /*extends WebMvcConfigurationSupport*/ implements WebMvcConfigurer {

/*    @Autowired
    private TestInterceptor testInterceptor;*/

   /* @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        System.out.println("InterceptorConfig-》addInterceptors()添加拦截器");
        registry.addInterceptor(new TestInterceptor()). // 注册拦截器
                excludePathPatterns("/order/hello2"); // 将指定的url放行，不通过拦截器
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("InterceptorConfig-》addInterceptors()添加拦截器");
        registry.addInterceptor(new TestInterceptor()). // 注册拦截器
                excludePathPatterns("/order/hello2"); // 将指定的url放行，不通过拦截器
    }
}
