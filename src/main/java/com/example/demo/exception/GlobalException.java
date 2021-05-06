package com.example.demo.exception;

import com.example.demo.response.FailResponse;
import com.example.demo.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/5/6 2:58 下午
 */
@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        System.out.println("捕获了异常");
        System.out.println(e);
        return new FailResponse("500",e.getMessage());
    }


    // @ResponseStatus(HttpStatus.UNAUTHORIZED) // 返回到前端显示的状态值，不是根据这个状态值去匹配抛出的异常
    @ExceptionHandler(ArithmeticException.class) // 匹配抛出的异常根据异常类型
    public Response handleException2(ArithmeticException e) {
        System.out.println("捕获了ArithmeticException");
        System.out.println(e);
        return new FailResponse("500",e.getMessage());
    }

}
