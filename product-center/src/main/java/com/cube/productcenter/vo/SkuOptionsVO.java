package com.cube.productcenter.vo;

import lombok.Data;

/**
 * @author tututu
 * @desc todo
 * @Date 2019/9/9 15:12
 * @email 289911401@qq.com
 */
@Data
public class SkuOptionsVO {
    private String id;

    /**
     * sku_id
     */
    private String skuId;

    /**
     * 属性选项id
     */
    private String optionsId;
}
