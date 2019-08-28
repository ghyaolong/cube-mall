package com.cube.mallinventoryservice.po;

import javax.persistence.*;

@Table(name = "t_sku_specifications_options")
public class TSkuSpecificationsOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * sku_id
     */
    @Column(name = "sku_id")
    private String skuId;

    /**
     * 规格选项ID
     */
    @Column(name = "specification_id")
    private String specificationId;

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
     * 获取规格选项ID
     *
     * @return specification_id - 规格选项ID
     */
    public String getSpecificationId() {
        return specificationId;
    }

    /**
     * 设置规格选项ID
     *
     * @param specificationId 规格选项ID
     */
    public void setSpecificationId(String specificationId) {
        this.specificationId = specificationId;
    }
}