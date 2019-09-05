package com.cube.productcenter.controller;

import com.cube.mall.model.Message;
import com.cube.mall.model.PageVO;
import com.cube.mall.model.ResponseUtil;
import com.cube.productcenter.service.SpuService;
import com.cube.productcenter.vo.SpuVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tututu
 * @description 标准产品单元管理
 * @date 2019/9/5 12:15
 * @email 289911401@qq.com
 * @since V1.0.0
 */
@RequestMapping("/spu")
@RestController
public class SPUController {
    @Autowired
    private SpuService spuService;

    @PostMapping("/query")
    public Message findAllSpu(@RequestBody PageVO<SpuVO> pageVO){
        PageInfo<SpuVO> spuList = spuService.findSpuList(pageVO);
        return ResponseUtil.responseBody(spuList);
    }

    @GetMapping("/{id}")
    public Message findSpuById(@PathVariable String id){
        SpuVO spuVO = spuService.findSpuById(id);
        return ResponseUtil.responseBody(spuVO);
    }

    @PostMapping("/create")
    public Message createSpu(@RequestBody SpuVO spuVO){
        spuService.addSpu(spuVO);
        return ResponseUtil.responseBody("添加成功");
    }

    @PutMapping("/update")
    public Message updateSpu(@RequestBody SpuVO spuVO){
        spuService.updateSpu(spuVO);
        return ResponseUtil.responseBody("更新成功");
    }

    @DeleteMapping("/{id}")
    public Message delSpuById(@PathVariable String id){
        spuService.delSpuById(id);
        return ResponseUtil.responseBody("删除成功");
    }

}
