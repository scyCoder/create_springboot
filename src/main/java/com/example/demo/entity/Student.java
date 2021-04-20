package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Student)实体类
 *
 * @author sunchuanyin
 * @since 2021-02-25 11:48:45
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -17304785869668609L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 分数
     */
    private Object score;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 教师id
     */
    private Integer tId;


    private Teacher teacher;

}