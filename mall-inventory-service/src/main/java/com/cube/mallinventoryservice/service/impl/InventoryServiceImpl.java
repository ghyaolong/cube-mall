package com.cube.mallinventoryservice.service.impl;

import com.cube.mall.enums.ExceptionCode;
import com.cube.mall.exception.BizException;
import com.cube.mallinventoryservice.dao.TSkuMapper;
import com.cube.mallinventoryservice.po.TSku;
import com.cube.mallinventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * 库存操作相关
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private TSkuMapper tSkuMapper;

    /**
     * 减库存
     * @param skuId
     * @param num
     */
    @Override
    public void subtractInventroy(String skuId, Integer num) {
        Example example = new Example(TSku.class);
        example.createCriteria().andEqualTo("id",skuId);
        TSku tSku = tSkuMapper.selectOneByExample(example);
        if(tSku.getStock()-num<0){
            throw new BizException(ExceptionCode.STOCK_INSUFFICIENT);
        }
        tSku.setStock(tSku.getStock()-num);
        tSkuMapper.updateByPrimaryKey(tSku);
    }
}
