package com.cube.productcenter.vo;

import lombok.Data;

@Data
public class SkuSpecificationsOptionsVO {
    private String id;

    /**
     * sku_id
     */
    private String skuId;

    /**
     * 规格选项ID
     */
    private String specificationId;
}
