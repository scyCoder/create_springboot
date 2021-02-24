package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Apps)实体类
 *
 * @author sunchuanyin
 * @since 2021-02-24 16:36:23
 */
@Data
public class Apps implements Serializable {
    private static final long serialVersionUID = -37041184263329812L;

    private Long id;

    private String name;

    private String key;

    private Date createdAt;

    private Date updatedAt;

    private List<AppNewConfigs> appNewConfigsList;


}