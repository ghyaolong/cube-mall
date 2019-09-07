package com.cube.productcenter.controller;

import com.cube.mall.model.Message;
import com.cube.mall.model.PageVO;
import com.cube.mall.model.ResponseUtil;
import com.cube.productcenter.feign.InventoryService;
import com.cube.productcenter.service.SkuService;
import com.cube.productcenter.vo.SkuVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 商品相关
 */
@RequestMapping("/sku")
@RestController
public class SkuController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private SkuService skuService;

    @PostMapping("/subtract")
    public Message substactStock(String skuId, Integer num){
        Message message = inventoryService.subtractInventroy(skuId, num);
        return message;
    }

    /**
     * 查询sku
     * @param pageVO
     * @return
     */
    @PostMapping("/query")
    public Message findAll(@RequestBody PageVO<SkuVO> pageVO){
        PageInfo<SkuVO> pageInfo = skuService.findSkuList(pageVO);
        return ResponseUtil.responseBody(pageInfo);
    }

    /**
     * 添加SKU
     * @param skuVO
     * @return
     */
    @PostMapping("/create")
    public Message createSku(@RequestBody SkuVO skuVO){
        skuService.addSku(skuVO);
        return ResponseUtil.responseBody("添加成功");
    }

    @PutMapping("/update")
    public Message updateSku(@RequestBody SkuVO skuVO){
        skuService.updateSku(skuVO);
        return ResponseUtil.responseBody("更新成功");
    }

    @DeleteMapping("/{id}")
    public Message delById(@PathVariable String id){
        skuService.delSkuById(id);
        return ResponseUtil.responseBody("删除成功");
    }
}
