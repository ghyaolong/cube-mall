package com.cube.productcenter.po;

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
}