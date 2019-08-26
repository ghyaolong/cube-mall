package com.cube.productcenter.po;

import javax.persistence.*;

@Table(name = "t_specifications_group")
public class TSpecificationsGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 规格组名称
     */
    private String name;

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
     * 获取规格组名称
     *
     * @return name - 规格组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置规格组名称
     *
     * @param name 规格组名称
     */
    public void setName(String name) {
        this.name = name;
    }
}