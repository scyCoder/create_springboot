package com.example.demo.aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/3/24 10:11 上午
 */
@RestController
@RequestMapping("/aspect")
public class AspectController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("AspectController=>>hello()");
        return "hello1111";
    }


}
