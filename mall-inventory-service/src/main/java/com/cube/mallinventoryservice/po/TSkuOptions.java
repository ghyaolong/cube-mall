package com.cube.mallinventoryservice.po;

import javax.persistence.*;

@Table(name = "t_sku_options")
public class TSkuOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * sku_id
     */
    @Column(name = "sku_id")
    private String skuId;

    /**
     * 属性选项id
     */
    @Column(name = "options_id")
    private String optionsId;

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
     * 获取sku_id
     *
     * @return sku_id - sku_id
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * 设置sku_id
     *
     * @param skuId sku_id
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取属性选项id
     *
     * @return options_id - 属性选项id
     */
    public String getOptionsId() {
        return optionsId;
    }

    /**
     * 设置属性选项id
     *
     * @param optionsId 属性选项id
     */
    public void setOptionsId(String optionsId) {
        this.optionsId = optionsId;
    }
}