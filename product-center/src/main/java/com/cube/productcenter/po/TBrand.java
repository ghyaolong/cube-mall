package com.cube.productcenter.po;

import javax.persistence.*;

@Table(name = "t_brand")
public class TBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌编码
     */
    private String code;

    @Column(name = "create_time")
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

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
     * 获取品牌名称
     *
     * @return name - 品牌名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置品牌名称
     *
     * @param name 品牌名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取品牌编码
     *
     * @return code - 品牌编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置品牌编码
     *
     * @param code 品牌编码
     */
    public void setCode(String code) {
        this.code = code;
    }
}