package com.cube.productcenter.service;

import com.cube.productcenter.po.TSkuOptions;
import com.cube.productcenter.vo.AttributeOptionsVO;
import com.cube.productcenter.vo.AttributeVO;
import com.cube.productcenter.vo.SkuOptionsVO;

import java.util.List;

/**
 * @author tututu
 * @desc todo
 * @Date 2019/9/9 15:00
 * @email 289911401@qq.com
 */
public interface AttributeService {

    List<AttributeVO>  findAllByCategoryId(String categoryId);

    /**
     * 查询改属性id下所有的属性选项
     * @param attributeId
     * @return
     */
    List<AttributeOptionsVO> findAllAttributeOptionsById(String attributeId);

    /**
     *
     * @param skuId
     * @return
     */
    List<AttributeOptionsVO> findAllAttributeOptionsBySkuId(String skuId);

    void addAttribute(AttributeVO attributeVO);

    void updateAttribute(AttributeVO attributeVO);

    void delAttributeById(String id);

    void addAttributeOptions(AttributeOptionsVO attributeOptionsVO);

    void updateAttributeOptions(AttributeOptionsVO attributeOptionsVO);

    void delAttributeOptionsById(String id);

    void addSkuOptions(SkuOptionsVO skuOptionsVO);

    void updateSkuOptions(SkuOptionsVO skuOptionsVO);

    void delSkuOptions(SkuOptionsVO skuOptionsVO);



}
