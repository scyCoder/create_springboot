package com.example.demo.annotation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/5/6 4:13 下午
 */
public class User {

    @NotBlank(message = "用户名不能为空", groups = {group1.class})
    public String name;

    public int age;

    public String no;

    public String phone;

    @Email(message = "邮箱格式不正确")
    public String email;
}
