package com.cube.mallinventoryservice.po;

import javax.persistence.*;

@Table(name = "t_specifications_options")
public class TSpecificationsOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 选项值
     */
    private String options;

    /**
     * 规格id
     */
    @Column(name = "specifiction_id")
    private String specifictionId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取选项值
     *
     * @return options - 选项值
     */
    public String getOptions() {
        return options;
    }

    /**
     * 设置选项值
     *
     * @param options 选项值
     */
    public void setOptions(String options) {
        this.options = options;
    }

    /**
     * 获取规格id
     *
     * @return specifiction_id - 规格id
     */
    public String getSpecifictionId() {
        return specifictionId;
    }

    /**
     * 设置规格id
     *
     * @param specifictionId 规格id
     */
    public void setSpecifictionId(String specifictionId) {
        this.specifictionId = specifictionId;
    }
}