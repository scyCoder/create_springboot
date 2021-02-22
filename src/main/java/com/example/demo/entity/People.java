package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (People)实体类
 *
 * @author sunchuanyin
 * @since 2021-02-20 16:45:04
 */
@Data
public class People implements Serializable {
    private static final long serialVersionUID = -33044382480350076L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 性别
    */
    private String sex;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 是否为老师
    */
    private Boolean isTeacher;
    /**
    * 创建时间
    */
    private Date createdAt;
    /**
    * 更新时间
    */
    private Date updatedAt;


}