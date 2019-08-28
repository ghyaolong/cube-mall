package com.cube.mallinventoryservice.po;

import javax.persistence.*;

@Table(name = "t_category")
public class TCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类编码
     */
    private String code;

    /**
     * 父类Id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 门户是否可见  0：可见    1：隐藏
     */
    @Column(name = "is_visable")
    private Integer isVisable;

    /**
     * 链接URL
     */
    private String url;

    /**
     * 排序，数字越小，越靠前
     */
    private Float sequence;

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
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取分类编码
     *
     * @return code - 分类编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置分类编码
     *
     * @param code 分类编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取父类Id
     *
     * @return parent_id - 父类Id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父类Id
     *
     * @param parentId 父类Id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取门户是否可见  0：可见    1：隐藏
     *
     * @return is_visable - 门户是否可见  0：可见    1：隐藏
     */
    public Integer getIsVisable() {
        return isVisable;
    }

    /**
     * 设置门户是否可见  0：可见    1：隐藏
     *
     * @param isVisable 门户是否可见  0：可见    1：隐藏
     */
    public void setIsVisable(Integer isVisable) {
        this.isVisable = isVisable;
    }

    /**
     * 获取链接URL
     *
     * @return url - 链接URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接URL
     *
     * @param url 链接URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取排序，数字越小，越靠前
     *
     * @return sequence - 排序，数字越小，越靠前
     */
    public Float getSequence() {
        return sequence;
    }

    /**
     * 设置排序，数字越小，越靠前
     *
     * @param sequence 排序，数字越小，越靠前
     */
    public void setSequence(Float sequence) {
        this.sequence = sequence;
    }
}