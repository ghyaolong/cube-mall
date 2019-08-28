package com.cube.mallinventoryservice.po;

import javax.persistence.*;

@Table(name = "t_spu")
public class TSpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * SPU编码
     */
    @Column(name = "spu_code")
    private String spuCode;

    /**
     * 分类id
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 品牌id
     */
    @Column(name = "brand_id")
    private String brandId;

    /**
     * 简介
     */
    @Column(name = "` intro`")
    private String intro;

    /**
     * 详解
     */
    private String details;

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
     * 获取产品名称
     *
     * @return name - 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取SPU编码
     *
     * @return spu_code - SPU编码
     */
    public String getSpuCode() {
        return spuCode;
    }

    /**
     * 设置SPU编码
     *
     * @param spuCode SPU编码
     */
    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

    /**
     * 获取分类id
     *
     * @return category_id - 分类id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类id
     *
     * @param categoryId 分类id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取品牌id
     *
     * @return brand_id - 品牌id
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * 设置品牌id
     *
     * @param brandId 品牌id
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取简介
     *
     * @return  intro - 简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置简介
     *
     * @param intro 简介
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 获取详解
     *
     * @return details - 详解
     */
    public String getDetails() {
        return details;
    }

    /**
     * 设置详解
     *
     * @param details 详解
     */
    public void setDetails(String details) {
        this.details = details;
    }
}