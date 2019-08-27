package com.cube.productcenter.vo;

import lombok.Data;

import java.util.List;

@Data
public class CategoryVO {

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
    private String parentId;

    /**
     * 门户是否可见  0：可见    1：隐藏
     */
    private Integer isVisable;

    /**
     * 链接URL
     */
    private String url;

    /**
     * 排序，数字越小，越靠前
     */
    private Float sequence;

    private List<CategoryVO> listVO;
}
