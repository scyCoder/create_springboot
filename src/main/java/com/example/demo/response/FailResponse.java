package com.example.demo.response;

import lombok.Data;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/5/6 3:01 下午
 */
@Data
public class FailResponse extends Response {

    public String code;

    public String msg;

    public FailResponse() {
    }

    public FailResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
