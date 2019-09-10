package com.cube.productcenter.dao;

import com.cube.productcenter.po.TAttribute;
import com.cube.productcenter.po.TAttributeOptions;
import com.cube.productcenter.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAttributeMapper extends MyMapper<TAttribute> {


    List<TAttributeOptions> findAllAttributeOptionsBySkuId(@Param("skuId") String skuId);

}