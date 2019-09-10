package com.cube.productcenter.controller;

import com.cube.mall.model.Message;
import com.cube.mall.model.ResponseUtil;
import com.cube.productcenter.service.AttributeService;
import com.cube.productcenter.vo.AttributeOptionsVO;
import com.cube.productcenter.vo.AttributeVO;
import com.cube.productcenter.vo.SkuOptionsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tututu
 * @desc todo
 * @Date 2019/9/9 14:59
 * @email 289911401@qq.com
 */
@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @GetMapping("/query/{categoryId}")
    public Message findAllByCategoryId(@PathVariable String categoryId){
        List<AttributeVO> attributeVOS = attributeService.findAllByCategoryId(categoryId);
        return ResponseUtil.responseBody(attributeVOS);
    }

    /**
     * 查询属性选项
     * @param type options values is attribute or sku
     * @param type
     * @return
     */
    @GetMapping("/query/options/{type}/{typeId}")
    public Message findAllAttributeOptionsById(@PathVariable String typeId,@PathVariable String type){
        switch (type){
            case "attribute":
                List<AttributeOptionsVO> attributeOptionsVOS = attributeService.findAllAttributeOptionsById(typeId);
                return ResponseUtil.responseBody(attributeOptionsVOS);
            case "sku":
                List<AttributeOptionsVO> attributeOptionsVOSBySkuId = attributeService.findAllAttributeOptionsBySkuId(typeId);
                return ResponseUtil.responseBody(attributeOptionsVOSBySkuId);
        }
        return null;
    }

    @PostMapping("/create")
    public Message createAttribute(@RequestBody AttributeVO attributeVO){
        attributeService.addAttribute(attributeVO);
        return ResponseUtil.responseBody("创建成功");
    }

    @PutMapping("/update")
    public Message updateAttribute(@RequestBody AttributeVO attributeVO){
        attributeService.updateAttribute(attributeVO);
        return ResponseUtil.responseBody("更新成功");
    }

    @DeleteMapping("/del/{id}")
    public Message createAttribute(@PathVariable String id){
        attributeService.delAttributeById(id);
        return ResponseUtil.responseBody("删除成功");
    }

    @PostMapping("/options/create")
    public Message createAttributeOptions(@RequestBody AttributeOptionsVO attributeOptionsVO){
        attributeService.addAttributeOptions(attributeOptionsVO);
        return ResponseUtil.responseBody("创建成功");
    }

    @PutMapping("/options/update")
    public Message updateAttributeOptions(@RequestBody AttributeOptionsVO attributeOptionsVO){
        attributeService.updateAttributeOptions(attributeOptionsVO);
        return ResponseUtil.responseBody("更新成功");
    }

    @DeleteMapping("/options/del/{id}")
    public Message delAttributeOptions(@PathVariable String id){
        attributeService.delAttributeOptionsById(id);
        return ResponseUtil.responseBody("删除成功");
    }

    @PostMapping("/skuOptions/create")
    public Message addSkuOptions(@RequestBody SkuOptionsVO skuOptionsVO){
        attributeService.addSkuOptions(skuOptionsVO);
        return ResponseUtil.responseBody("创建成功");
    }

    @PutMapping("/skuOptions/update")
    public Message updateSkuOptions(@RequestBody SkuOptionsVO skuOptionsVO){
        attributeService.updateSkuOptions(skuOptionsVO);
        return ResponseUtil.responseBody("修改成功");
    }

    @DeleteMapping("/skuOptions/del")
    public Message delSkuOptions(@RequestBody SkuOptionsVO skuOptionsVO){
        attributeService.delSkuOptions(skuOptionsVO);
        return ResponseUtil.responseBody("删除成功");
    }

}
