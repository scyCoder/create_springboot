package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author sunchuanyin
 * @since 2021-02-24 13:55:03
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -46790440144686543L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 价格
     */
    // @JsonIgnore 有这个注解，不会把被这个注解修饰的字段返回到前端
    private Integer price;


}