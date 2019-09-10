package com.cube.productcenter.controller;

import com.cube.mall.model.Message;
import com.cube.mall.model.ResponseUtil;
import com.cube.productcenter.service.SpecService;
import com.cube.productcenter.vo.SkuSpecificationsOptionsVO;
import com.cube.productcenter.vo.SpecificationsGroupVO;
import com.cube.productcenter.vo.SpecificationsOptionsVO;
import com.cube.productcenter.vo.SpecificationsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 规格相关Controller
 */
@RequestMapping("/spec")
@RestController
public class SpecificationController {

    @Autowired
    private SpecService specService;

    /**
     * 查询所有规格
     * @param type  group或者category，
     * @param typeId 对应的groupId或者categoryId
     * @return
     */
    @GetMapping("/{type}/{typeId}")
    public Message findByGroupId(@PathVariable String type,@PathVariable String typeId){
        switch (type.toLowerCase()){
            case "group":
                return ResponseUtil.responseBody(specService.findByGroupId(typeId));
            case "category":
                return ResponseUtil.responseBody(specService.findByCategoryId(typeId));
        }
        return ResponseUtil.responseBody(null);
    }

    /**
     * 查询所有选项
     * @param type spec或者sku
     * @param typeId 对应是specId 或者skuId
     * @return
     */
    @GetMapping("/query/options/{type}/{typeId}")
    public Message findAllOptionsBySpecId(@PathVariable String type,@PathVariable String typeId){
        switch (type.toLowerCase()){
            case "spec":
                return ResponseUtil.responseBody(specService.findAllOptionsBySpecId(typeId));
            case "sku":
                return ResponseUtil.responseBody(specService.findAllOptionsBySkuId(typeId));
        }

        return ResponseUtil.responseBody(null);
    }

    @PostMapping("/group/create")
    public Message addGroup(@RequestBody SpecificationsGroupVO specificationsGroupVO){
        specService.addGroup(specificationsGroupVO);
        return ResponseUtil.responseBody("添加成功");
    }

    @PutMapping("/group/update")
    public Message updateGroup(@RequestBody SpecificationsGroupVO specificationsGroupVO){
        specService.updateGroup(specificationsGroupVO);
        return ResponseUtil.responseBody("更新成功");
    }

    @DeleteMapping("/group/{id}")
    public Message delGroup(@PathVariable String id){
        specService.delGroup(id);
        return ResponseUtil.responseBody("删除成功");
    }

    //规格相关
    @PostMapping("/spec/create")
    public Message addSpec(@RequestBody SpecificationsVO specificationsVO){
        specService.addSpec(specificationsVO);
        return ResponseUtil.responseBody("添加成功");
    }

    @PutMapping("/spec/update")
    public Message udpateSpec(@RequestBody SpecificationsVO specificationsVO){
        specService.updateSpec(specificationsVO);
        return ResponseUtil.responseBody("修改成功");
    }

    @DeleteMapping("/spec")
    public Message delSpec(@RequestBody SpecificationsVO specificationsVO){
        specService.delSpec(specificationsVO);
        return ResponseUtil.responseBody("删除成功");
    }

    //规格选项
    @PostMapping("/specOptions/create")
    public Message addSpecOptions(@RequestBody SpecificationsOptionsVO specificationsOptionsVO){
        specService.addSpecOptions(specificationsOptionsVO);
        return ResponseUtil.responseBody("添加成功");
    }

    @PutMapping("/specOptions/update")
    public Message udpateSpecOptions(@RequestBody SpecificationsOptionsVO specificationsOptionsVO){
        specService.updateSpecOptions(specificationsOptionsVO);
        return ResponseUtil.responseBody("修改成功");
    }

    @DeleteMapping("/specOptions")
    public Message delSpecOptions(@RequestBody SpecificationsOptionsVO specificationsOptionsVO){
        specService.delSpecOptions(specificationsOptionsVO);
        return ResponseUtil.responseBody("删除成功");
    }


    //SKU-规格选项 相关
    @PostMapping("/skuSpecOptions/create")
    public Message addSkuSpecOptions(@RequestBody SkuSpecificationsOptionsVO skuSpecificationsOptionsVO){
        specService.addSkuSpecOptions(skuSpecificationsOptionsVO);
        return ResponseUtil.responseBody("添加成功");
    }

    @PutMapping("/skuSpecOptions/update")
    public Message udpateSkuSpecOptions(@RequestBody SkuSpecificationsOptionsVO skuSpecificationsOptionsVO){
        specService.updateSkuSpecOptions(skuSpecificationsOptionsVO);
        return ResponseUtil.responseBody("修改成功");
    }

    @DeleteMapping("/skuSpecOptions")
    public Message delSkuSpecOptions(@RequestBody SkuSpecificationsOptionsVO skuSpecificationsOptionsVO){
        specService.delSkuSpecOptions(skuSpecificationsOptionsVO);
        return ResponseUtil.responseBody("删除成功");
    }


}
