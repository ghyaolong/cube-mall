package com.cube.productcenter.service;

import com.cube.mall.model.PageVO;
import com.cube.productcenter.vo.SpuVO;
import com.github.pagehelper.PageInfo;

/**
 * @author tututu
 * @description
 * @date 2019/9/5 20:39
 * @email 289911401@qq.com
 * @since V1.0.0
 */
public interface SpuService {

    /**
     * 分页查询SPU
     * @param pageVO
     * @return
     */
    PageInfo<SpuVO> findSpuList(PageVO<SpuVO> pageVO);

    SpuVO findSpuById(String id);

    void addSpu(SpuVO spuVO);

    void updateSpu(SpuVO spuVO);

    void delSpuById(String id);
}
