package com.cube.productcenter.service;


import com.cube.mall.model.PageVO;
import com.cube.productcenter.vo.SkuVO;
import com.github.pagehelper.PageInfo;

public interface SkuService {
    /**
     * 分页查询SPU
     * @param pageVO
     * @return
     */
    PageInfo<SkuVO> findSkuList(PageVO<SkuVO> pageVO);

    SkuVO findSkuById(Object id);

    void addSku(SkuVO skuVO);

    void updateSku(SkuVO skuVO);

    void delSkuById(String id);
}
