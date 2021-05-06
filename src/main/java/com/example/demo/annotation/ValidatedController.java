package com.example.demo.annotation;

import com.example.demo.response.Response;
import com.example.demo.response.SuccessResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 注解@Validated的使用
 * @date 2021/5/6 4:11 下午
 */
@RestController
@RequestMapping("/user")
public class ValidatedController {

    /**
     * @Validated({group1.class})
     *      有{group1.class}表示分组，会匹配加了{group1.class}注解的字段规则，其他的不会验证
     *      如果没有分组，表示加了注解（如：@Email,@NotBlank）的所有字段都需要验证
     * @param user
     * @return
     */
    @RequestMapping("/getUser")
    public Response getUser(@RequestBody @Validated({group1.class}) User user) {
        return new SuccessResponse("200", "成功");
    }
}
