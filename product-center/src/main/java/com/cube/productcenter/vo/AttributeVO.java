package com.cube.productcenter.vo;

import lombok.Data;

/**
 * @author tututu
 * @desc todo
 * @Date 2019/9/9 15:01
 * @email 289911401@qq.com
 */

@Data
public class AttributeVO {

    private String id;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 分类id
     */
    private String categoryId;

    /**
     * 是否参与查询  0：参与   1：不参与
     */
    private Integer isQuery;

    /**
     * 是否可见   0：可见   1：隐藏
     */
    private Integer isVisable;
}
