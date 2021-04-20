package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Teacher)实体类
 *
 * @author sunchuanyin
 * @since 2021-02-25 11:51:00
 */
@Data
public class Teacher extends Student implements Serializable {
    private static final long serialVersionUID = 610398308834593857L;
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
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;

    private List<Student> studentList;


}