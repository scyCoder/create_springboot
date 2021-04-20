package com.example.demo.intercept;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

/**
 * 拦截器：
 * 1、编写一个类实现HandlerInterceptor并写上@Component注解交给spring容器
 * 2、编写一个配置类InterceptorConfigTest 继承WebMvcConfigurationSupport或实现WebMvcConfigurer，重新方法addInterceptors
 * 3、需要注意的是：   如果也有过滤器，一定要主要过滤器和拦截器的执行顺序   过滤前->拦截前->action执行->拦截后->过滤后
 * 因未注意过滤器和拦截器的执行顺序，在编写demo的时候，一直发现拦截器没有执行，其实是可以执行的，只是在ControllerFilter过滤器中的doFilter
 * 方法中忘记执行chain.doFilter(request, response);就没有放行过滤器，程序也就没有继续执行，所以拦截器也没有执行
 *
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/11 10:35 上午
 */
@Component
public class TestInterceptor implements HandlerInterceptor {

    /**
     * //在请求处理之前进行调用（Controller方法调用之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TestInterceptor-》preHandle()");
        return true;
    }

    /**
     * /请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("TestInterceptor-》postHandle()");
    }

    /**
     * //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("TestInterceptor-》afterCompletion()");
    }
}
