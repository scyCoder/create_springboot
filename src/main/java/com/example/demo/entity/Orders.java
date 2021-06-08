package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 订单表(Orders)实体类
 *
 * @author sunchuanyin
 * @since 2021-06-08 09:35:53
 */
public class Orders {

    private Long id;

    private Long appId;

    private Long userId;

    private Byte state;

    private Long skuId;

    private Integer price;

    private Long couponId;

    private String outTradeNo;

    private String outSignNo;

    private String outOrderNo;

    private Date paidAt;

    private Date signedAt;

    private Date successAt;

    private Date refundedAt;

    private String outRefundNo;

    private String third;

    private String promotion;

    private Date createdAt;

    private Date updatedAt;


    // 价钱小于100分时
    private Integer newPrice;

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getOutSignNo() {
        return outSignNo;
    }

    public void setOutSignNo(String outSignNo) {
        this.outSignNo = outSignNo == null ? null : outSignNo.trim();
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo == null ? null : outOrderNo.trim();
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public Date getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(Date signedAt) {
        this.signedAt = signedAt;
    }

    public Date getSuccessAt() {
        return successAt;
    }

    public void setSuccessAt(Date successAt) {
        this.successAt = successAt;
    }

    public Date getRefundedAt() {
        return refundedAt;
    }

    public void setRefundedAt(Date refundedAt) {
        this.refundedAt = refundedAt;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo == null ? null : outRefundNo.trim();
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third == null ? null : third.trim();
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion == null ? null : promotion.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Orders{");
        sb.append("id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", userId=").append(userId);
        sb.append(", state=").append(state);
        sb.append(", skuId=").append(skuId);
        sb.append(", price=").append(price);
        sb.append(", couponId=").append(couponId);
        sb.append(", outTradeNo='").append(outTradeNo).append('\'');
        sb.append(", outSignNo='").append(outSignNo).append('\'');
        sb.append(", outOrderNo='").append(outOrderNo).append('\'');
        sb.append(", paidAt=").append(paidAt);
        sb.append(", signedAt=").append(signedAt);
        sb.append(", successAt=").append(successAt);
        sb.append(", refundedAt=").append(refundedAt);
        sb.append(", outRefundNo='").append(outRefundNo).append('\'');
        sb.append(", third='").append(third).append('\'');
        sb.append(", promotion='").append(promotion).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", newPrice=").append(newPrice);
        sb.append('}');
        return sb.toString();
    }


}
