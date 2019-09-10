package com.cube.productcenter.vo;

import lombok.Data;

/**
 * @author tututu
 * @desc todo
 * @Date 2019/9/9 15:02
 * @email 289911401@qq.com
 */
@Data
public class AttributeOptionsVO {

    private String id;

    /**
     * 选项值
     */
    private String option;

    /**
     * 属性id
     */
    private String attributeId;

    /**
     * 是否参与查询  0：参与   1：不参与
     */
    private Integer isQuery;

    /**
     * 是否可见   0：可见   1：隐藏
     */
    private Integer isVisable;
}
