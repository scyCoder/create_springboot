package com.example.demo.filter;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 参考地址：https://blog.csdn.net/qq_41315539/article/details/103497449
 * 写过滤器：
 * 1、实现javax.servlet.Filter;
 * 2、在实现类上添加注解@WebFilter
 * 3、在启动上添加注解：@ServletComponentScan("com.example.demo.filter")，扫描过滤器实现类，注入到spring中
 * 4、@WebFilter中如果匹配所有的路径是/*,而不是/**
 *
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/5 5:54 下午
 */
@WebFilter(filterName = "controllerFilter", urlPatterns = "/*")
public class ControllerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ControllerFilter-》init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ControllerFilter-》doFilter()");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("ControllerFilter-》destroy()");
    }
}
