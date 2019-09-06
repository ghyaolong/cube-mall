package com.cube.productcenter.controller;

import com.cube.mall.constant.MsgStatus;
import com.cube.mall.model.Constant;
import com.cube.mall.model.Message;
import com.cube.mall.model.ResponseUtil;
import com.cube.productcenter.feign.InventoryService;
import com.cube.productcenter.vo.SkuVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

   /* @Autowired
    private SkuService skuService;*/

    @PostMapping("/subtract")
    public Message substactStock(String skuId, Integer num){
        Message message = inventoryService.subtractInventroy(skuId, num);
        return message;
    }

    /**
     * 查询sku
     * @param pageInfo
     * @return
     */
    @PostMapping("/query")
    public Message findAll(@RequestBody PageInfo<SkuVO> pageInfo){
        //skuService.findAll(pageInfo);
        return null;
    }
}
