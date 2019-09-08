package com.cube.productcenter.dao;

import com.cube.productcenter.po.TSpecificationsOptions;
import com.cube.productcenter.utils.MyMapper;
import com.cube.productcenter.vo.SpecificationsOptionsVO;

import java.util.List;

public interface TSpecificationsOptionsMapper extends MyMapper<TSpecificationsOptions> {

    /**
     * 查询该skuId下所有的选项
     * @param skuId
     * @return
     */
    List<SpecificationsOptionsVO> findAllOptionsBySkuId(String skuId);
}