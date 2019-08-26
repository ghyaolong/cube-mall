package com.cube.productcenter.po;

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
}