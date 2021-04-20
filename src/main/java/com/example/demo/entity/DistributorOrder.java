package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 渠道订购(DistributorOrder)实体类
 *
 * @author sunchuanyin
 * @since 2021-04-16 15:24:09
 */
@Data
public class DistributorOrder implements Serializable {
    private static final long serialVersionUID = 543681356169045613L;
    /**
     * id主键
     */
    private Integer distributorId;
    /**
     * 渠道名称
     */
    private String distributorName;
    /**
     * 订购状态 0：订购中   1：提交订购成功 2：提交订购失败  3：订购成功   4：订购失败
     */
    private String status;
    /**
     * 提交订购code
     */
    private String submitCode;
    /**
     * 提交订购信息
     */
    private String submitMsg;
    /**
     * 订购回调code
     */
    private String reportCode;
    /**
     * 订购回调信息
     */
    private String reportMsg;
    /**
     * push结果code
     */
    private String pushCode;
    /**
     * push结果msg
     */
    private String pushMsg;
    /**
     * 平台订单id
     */
    private String platformOrderId;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 供应商id
     */
    private Integer cpid;
    /**
     * 商品id
     */
    private String id;
    /**
     * 小沃订单号
     */
    private String orderid;
    /**
     * 时间戳，毫秒
     */
    private String timestamp;
    /**
     * 手机号
     */
    private String usercode;
    /**
     * 充值账号
     */
    private String account;
    /**
     * 数量
     */
    private String num;
    /**
     * 价格(分)
     */
    private String price;
    /**
     * 回调地址
     */
    private String callbackUrl;
    /**
     * 下单请求参数中的md5签名
     */
    private String orderRequestSign;
    /**
     * 回调请求code  消息状态码，0是正确，其他错误
     */
    private Integer callbackRequestCode;
    /**
     * 消息内容,用于错误提示
     */
    private String callbackRequestMsg;
    /**
     * 平台订单id与platform_order_id一致
     */
    private String cporderid;
    /**
     * 商品类型：
     * 1-无返回或直充模式
     * 2-券码
     * 3-卡号+卡密
     * 4-卡号+支付链接/领取地址
     * 5-纯支付链接
     * 6-卡号+卡密+支付链接/领取地址（暂不支持）
     * 7-实体终端（暂不支持）
     */
    private Integer type;
    /**
     * 卡号
     */
    private String cardno;
    /**
     * 券码/卡密
     */
    private String cdkey;
    /**
     * 短链
     */
    private String link;
    /**
     * 下单响应md5签名
     */
    private String callbackRequestSign;
    /**
     * 权益开始时间
     */
    private String beginTime;
    /**
     * 权益结束时间
     */
    private String endTime;
    /**
     * 券码/卡密 明文
     */
    private String cdkeyPlaintext;
    /**
     * 下单响应数据
     */
    private String orderResponseData;


}
