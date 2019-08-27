package com.cube.ordercenter.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderVO {

    private String id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 客户编号
     */
    private Integer memberId;

    /**
     * 订单状态 0未付款,1已付款,2已发货,3已签收,-1退货申请,-2退货中,-3已退货,-4取消交易
     */
    private Integer status;

    /**
     * 用户售后状态 0 未发起售后 1 申请售后 -1 售后已取消 2 处理中 200 处理完毕
     */
    private Integer afterStatus;

    /**
     * 商品数量
     */
    private Integer productCount;

    /**
     * 商品总价
     */
    private BigDecimal productAmountTotal;

    /**
     * 实际付款金额
     */
    private BigDecimal orderAmountTotal;

    /**
     * 收货地址编码
     */
    private String addressId;

    /**
     * 支付渠道 0余额 1微信 2支付宝
     */
    private Byte payChannel;

    /**
     * 订单支付单号
     */
    private String outTradeNo;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 交易完成时间
     */
    private Date endTime;

    /**
     * 买家是否评价
     */
    private Integer isComment;

    /**
     * 快递名称：  顺丰   ，圆通......
     */
    private String deliveryName;

    /**
     * 快递单号
     */
    private String deliveryCode;

    /**
     * skuId
     */
    private Integer skuId;

    /**
     * 属性选项 json格式存储，有多个选项，就存储多个选项
     */
    private String attributeOptions;
}
