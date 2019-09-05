package com.cube.productcenter.vo;

import lombok.Data;

@Data
public class BrandVO {

    private String id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌编码
     */
    private String code;

    /**
     * 创建时间
     */
    private String createTime;
}
