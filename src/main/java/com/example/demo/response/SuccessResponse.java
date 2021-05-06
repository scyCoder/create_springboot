package com.example.demo.response;

import lombok.Data;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/5/6 2:59 下午
 */
@Data
public class SuccessResponse extends Response{

    public String code;

    public String msg;

    public SuccessResponse() {
    }

    public SuccessResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
