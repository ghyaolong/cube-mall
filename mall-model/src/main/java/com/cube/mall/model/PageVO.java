package com.cube.mall.model;

import lombok.Data;

/**
 * @author tututu
 * @description
 * @date 2019/9/5 20:54
 * @email 289911401@qq.com
 * @since V1.0.0
 */
@Data
public class PageVO<T> {
    private Integer pageNum;
    private Integer pageSize;
    private T t;
}
