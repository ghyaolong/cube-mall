package com.cube.productcenter.vo;

import lombok.Data;

@Data
public class SpecificationsVO {

    private String id;

    /**
     * 参数名称
     */
    private String parameterName;

    /**
     * 规格组
     */
    private String specificGroupId;

    /**
     * 分类Id
     */
    private String categoryId;

    /**
     * 显示位置
     */
    private String showPosition;

    /**
     * 是否参与查询  0：参与   1：不参与
     */
    private Integer isQuery;

    /**
     * 是否可见   0：可见   1：隐藏
     */
    private Integer isVisable;
}
