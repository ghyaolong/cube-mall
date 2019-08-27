package com.cube.ordercenter.po;

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
     * 是否参与查询  0：参与   1：不参与
     */
    @Column(name = "is_query")
    private Integer isQuery;

    /**
     * 是否可见   0：可见   1：隐藏
     */
    @Column(name = "is_visable")
    private Integer isVisable;

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

    /**
     * 获取是否参与查询  0：参与   1：不参与
     *
     * @return is_query - 是否参与查询  0：参与   1：不参与
     */
    public Integer getIsQuery() {
        return isQuery;
    }

    /**
     * 设置是否参与查询  0：参与   1：不参与
     *
     * @param isQuery 是否参与查询  0：参与   1：不参与
     */
    public void setIsQuery(Integer isQuery) {
        this.isQuery = isQuery;
    }

    /**
     * 获取是否可见   0：可见   1：隐藏
     *
     * @return is_visable - 是否可见   0：可见   1：隐藏
     */
    public Integer getIsVisable() {
        return isVisable;
    }

    /**
     * 设置是否可见   0：可见   1：隐藏
     *
     * @param isVisable 是否可见   0：可见   1：隐藏
     */
    public void setIsVisable(Integer isVisable) {
        this.isVisable = isVisable;
    }
}