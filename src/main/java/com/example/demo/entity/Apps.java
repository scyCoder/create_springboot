package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "接口返回对象", description = "接口返回对象")
public class Apps implements Serializable {
    private static final long serialVersionUID = -37041184263329812L;

    private Long id;

    @ApiModelProperty(value = "成功标志")
    private String name;

    private String key;

    private Date createdAt;

    private Date updatedAt;

    private List<AppNewConfigs> appNewConfigsList;

    private Byte hello;


}