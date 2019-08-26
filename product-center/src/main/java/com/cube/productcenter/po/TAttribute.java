package com.cube.productcenter.po;

import javax.persistence.*;

@Table(name = "t_attribute")
public class TAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 分类id
     */
    @Column(name = "category_id")
    private String categoryId;

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
     * 获取属性名称
     *
     * @return name - 属性名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置属性名称
     *
     * @param name 属性名称
     */
    public void setName(String name) {
        this.name = name;
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
}