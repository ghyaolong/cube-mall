package com.cube.mallinventoryservice.po;

import javax.persistence.*;

@Table(name = "t_attribute_options")
public class TAttributeOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 选项值
     */
    private String option;

    /**
     * 属性id
     */
    @Column(name = "attribute_id")
    private String attributeId;

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
     * 获取选项值
     *
     * @return option - 选项值
     */
    public String getOption() {
        return option;
    }

    /**
     * 设置选项值
     *
     * @param option 选项值
     */
    public void setOption(String option) {
        this.option = option;
    }

    /**
     * 获取属性id
     *
     * @return attribute_id - 属性id
     */
    public String getAttributeId() {
        return attributeId;
    }

    /**
     * 设置属性id
     *
     * @param attributeId 属性id
     */
    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
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