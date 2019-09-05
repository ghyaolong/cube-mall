package com.cube.productcenter.vo;

import lombok.Data;

/**
 * @author tututu
 * @description
 * @date 2019/9/5 12:18
 * @email 289911401@qq.com
 * @since V1.0.0
 */
@Data
public class SpuVO {
    private String id;
    /**
     * 产品名称
     */
    private String name;

    /**
     * SPU编码
     */
    private String spuCode;

    /**
     * 分类id
     */
    private String categoryId;

    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 简介
     */
    private String intro;

    /**
     * 详解
     */
    private String details;
}
