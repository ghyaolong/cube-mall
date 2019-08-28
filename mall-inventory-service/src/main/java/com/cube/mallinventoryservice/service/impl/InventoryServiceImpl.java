package com.cube.mallinventoryservice.service.impl;

import com.cube.mallinventoryservice.dao.TSkuMapper;
import com.cube.mallinventoryservice.po.TSku;
import com.cube.mallinventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private TSkuMapper tSkuMapper;
    @Override
    public void subtractInventroy(String skuId, Integer num) {

        Example example = new Example(TSku.class);
        example.createCriteria().andEqualTo("skuId",skuId);
        TSku tSku = tSkuMapper.selectOneByExample(example);
        if(tSku.getStatus()-num<0){
            //todo here
            //throw new BizException();
        }
        TSku sku = new TSku();
        sku.setStock(sku.getStock()-num);
        tSkuMapper.updateByExampleSelective(sku,example);
    }
}
