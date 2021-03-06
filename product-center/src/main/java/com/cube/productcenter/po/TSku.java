package com.cube.productcenter.po;

import javax.persistence.*;

@Table(name = "t_sku")
public class TSku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * spuId
     */
    @Column(name = "spu_id")
    private String spuId;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 0:未上架  1：已上架   2：已下架  3：已删除
     */
    private Integer status;

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
     * 获取sku名称
     *
     * @return name - sku名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置sku名称
     *
     * @param name sku名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取sku编码
     *
     * @return code - sku编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置sku编码
     *
     * @param code sku编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取spuId
     *
     * @return spu_id - spuId
     */
    public String getSpuId() {
        return spuId;
    }

    /**
     * 设置spuId
     *
     * @param spuId spuId
     */
    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取0:未上架  1：已上架   2：已下架  3：已删除
     *
     * @return status - 0:未上架  1：已上架   2：已下架  3：已删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:未上架  1：已上架   2：已下架  3：已删除
     *
     * @param status 0:未上架  1：已上架   2：已下架  3：已删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}