package com.cube.ordercenter.po;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order")
public class TOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 客户编号
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 订单状态 0未付款,1已付款,2已发货,3已签收,-1退货申请,-2退货中,-3已退货,-4取消交易
     */
    private Integer status;

    /**
     * 用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     */
    @Column(name = "after_status")
    private Integer afterStatus;

    /**
     * 商品数量
     */
    @Column(name = "product_count")
    private Integer productCount;

    /**
     * 商品总价
     */
    @Column(name = "product_amount_total")
    private BigDecimal productAmountTotal;

    /**
     * 实际付款金额
     */
    @Column(name = "order_amount_total")
    private BigDecimal orderAmountTotal;

    /**
     * 收货地址编码
     */
    @Column(name = "address_id")
    private String addressId;

    /**
     * 支付渠道 0余额 1微信 2支付宝
     */
    @Column(name = "pay_channel")
    private Byte payChannel;

    /**
     * 订单支付单号
     */
    @Column(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 发货时间
     */
    @Column(name = "delivery_time")
    private Date deliveryTime;

    /**
     * 交易完成时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 买家是否评价
     */
    @Column(name = "is_comment")
    private Integer isComment;

    /**
     * 快递名称：  顺丰   ，圆通......
     */
    @Column(name = "delivery_name")
    private String deliveryName;

    /**
     * 快递单号
     */
    @Column(name = "delivery_code")
    private String deliveryCode;

    /**
     * skuId
     */
    @Column(name = "sku_id")
    private Integer skuId;

    /**
     * 属性选项 json格式存储，有多个选项，就存储多个选项
     */
    @Column(name = "attribute_options")
    private String attributeOptions;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取订单编号
     *
     * @return order_no - 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单编号
     *
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取客户编号
     *
     * @return member_id - 客户编号
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置客户编号
     *
     * @param memberId 客户编号
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取订单状态 0未付款,1已付款,2已发货,3已签收,-1退货申请,-2退货中,-3已退货,-4取消交易
     *
     * @return status - 订单状态 0未付款,1已付款,2已发货,3已签收,-1退货申请,-2退货中,-3已退货,-4取消交易
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单状态 0未付款,1已付款,2已发货,3已签收,-1退货申请,-2退货中,-3已退货,-4取消交易
     *
     * @param status 订单状态 0未付款,1已付款,2已发货,3已签收,-1退货申请,-2退货中,-3已退货,-4取消交易
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     *
     * @return after_status - 用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     */
    public Integer getAfterStatus() {
        return afterStatus;
    }

    /**
     * 设置用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     *
     * @param afterStatus 用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     */
    public void setAfterStatus(Integer afterStatus) {
        this.afterStatus = afterStatus;
    }

    /**
     * 获取商品数量
     *
     * @return product_count - 商品数量
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * 设置商品数量
     *
     * @param productCount 商品数量
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * 获取商品总价
     *
     * @return product_amount_total - 商品总价
     */
    public BigDecimal getProductAmountTotal() {
        return productAmountTotal;
    }

    /**
     * 设置商品总价
     *
     * @param productAmountTotal 商品总价
     */
    public void setProductAmountTotal(BigDecimal productAmountTotal) {
        this.productAmountTotal = productAmountTotal;
    }

    /**
     * 获取实际付款金额
     *
     * @return order_amount_total - 实际付款金额
     */
    public BigDecimal getOrderAmountTotal() {
        return orderAmountTotal;
    }

    /**
     * 设置实际付款金额
     *
     * @param orderAmountTotal 实际付款金额
     */
    public void setOrderAmountTotal(BigDecimal orderAmountTotal) {
        this.orderAmountTotal = orderAmountTotal;
    }

    /**
     * 获取收货地址编码
     *
     * @return address_id - 收货地址编码
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * 设置收货地址编码
     *
     * @param addressId 收货地址编码
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取支付渠道 0余额 1微信 2支付宝
     *
     * @return pay_channel - 支付渠道 0余额 1微信 2支付宝
     */
    public Byte getPayChannel() {
        return payChannel;
    }

    /**
     * 设置支付渠道 0余额 1微信 2支付宝
     *
     * @param payChannel 支付渠道 0余额 1微信 2支付宝
     */
    public void setPayChannel(Byte payChannel) {
        this.payChannel = payChannel;
    }

    /**
     * 获取订单支付单号
     *
     * @return out_trade_no - 订单支付单号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 设置订单支付单号
     *
     * @param outTradeNo 订单支付单号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取发货时间
     *
     * @return delivery_time - 发货时间
     */
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * 设置发货时间
     *
     * @param deliveryTime 发货时间
     */
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * 获取交易完成时间
     *
     * @return end_time - 交易完成时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置交易完成时间
     *
     * @param endTime 交易完成时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取买家是否评价
     *
     * @return is_comment - 买家是否评价
     */
    public Integer getIsComment() {
        return isComment;
    }

    /**
     * 设置买家是否评价
     *
     * @param isComment 买家是否评价
     */
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    /**
     * 获取快递名称：  顺丰   ，圆通......
     *
     * @return delivery_name - 快递名称：  顺丰   ，圆通......
     */
    public String getDeliveryName() {
        return deliveryName;
    }

    /**
     * 设置快递名称：  顺丰   ，圆通......
     *
     * @param deliveryName 快递名称：  顺丰   ，圆通......
     */
    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    /**
     * 获取快递单号
     *
     * @return delivery_code - 快递单号
     */
    public String getDeliveryCode() {
        return deliveryCode;
    }

    /**
     * 设置快递单号
     *
     * @param deliveryCode 快递单号
     */
    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    /**
     * 获取skuId
     *
     * @return sku_id - skuId
     */
    public Integer getSkuId() {
        return skuId;
    }

    /**
     * 设置skuId
     *
     * @param skuId skuId
     */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取属性选项 json格式存储，有多个选项，就存储多个选项
     *
     * @return attribute_options - 属性选项 json格式存储，有多个选项，就存储多个选项
     */
    public String getAttributeOptions() {
        return attributeOptions;
    }

    /**
     * 设置属性选项 json格式存储，有多个选项，就存储多个选项
     *
     * @param attributeOptions 属性选项 json格式存储，有多个选项，就存储多个选项
     */
    public void setAttributeOptions(String attributeOptions) {
        this.attributeOptions = attributeOptions;
    }
}