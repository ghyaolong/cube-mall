package com.cube.productcenter.vo;

import lombok.Data;

@Data
public class SkuVO {
    private String id;

    /**
     * sku名称
     */
    private String name;

    /**
     * sku编码
     */
    private String code;

    /**
     * 价格
     */
    private Double price;

    /**
     * 开始价格
     */
    private Double startPrice;

    /**
     * 结束价格
     */
    private Double endPrice;

    /**
     * spuId
     */
    private String spuId;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 开始库存
     */
    private Integer startStock;
    /**
     * 结束库存
     */
    private Integer endStock;

    /**
     * 0:未上架  1：已上架   2：已下架  3：已删除
     */
    private Integer status;

}
