package com.cube.productcenter.controller;

import com.cube.productcenter.feign.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品相关
 */
@RequestMapping("/sku")
@RestController
public class SkuController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/subtract")
    public Boolean substactStock(String skuId,Integer num){
        Boolean bool = inventoryService.subtractInventroy(skuId, num);
        return bool;
    }
}
