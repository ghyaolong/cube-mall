package com.cube.productcenter.vo;

import lombok.Data;

@Data
public class SpecificationsOptionsVO {
    private Integer id;

    /**
     * 选项值
     */
    private String options;

    /**
     * 规格id
     */
    private String specifictionId;
}
