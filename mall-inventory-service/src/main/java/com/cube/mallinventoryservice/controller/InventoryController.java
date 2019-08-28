package com.cube.mallinventoryservice.controller;

import com.cube.mallinventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作库存，这里为了测试分布式事务，应该和下单在一个服务里
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {


    @Autowired
    private InventoryService inventoryService;

    /**
     * 减库存
     * @param skuId 商品skuId
     * @param num 减库存的数量
     * @return
     */
    @PostMapping("/subtract/{skuId}/{num}")
    public Boolean subtractInventroy(@PathVariable String skuId,@PathVariable Integer num){
        if(num<=0){
            //throw new BizException();
        }
        inventoryService.subtractInventroy(skuId,num);
        return true;
    }
}
