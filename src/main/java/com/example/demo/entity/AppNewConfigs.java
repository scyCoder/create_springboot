package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AppNewConfigs)实体类
 *
 * @author sunchuanyin
 * @since 2021-02-24 16:36:22
 */
@Data
public class AppNewConfigs implements Serializable {
    private static final long serialVersionUID = 273814680924056157L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * apps表主键id
     */
    private Long appId;
    /**
     * 配置项名字
     */
    private String configName;
    /**
     * 配置项值
     */
    private String configValue;

    private Date createdAt;

    private Date updatedAt;

    private Apps apps;


}