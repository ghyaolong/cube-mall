package com.cube.productcenter.controller;

import com.cube.mall.model.Message;
import com.cube.mall.model.ResponseUtil;
import com.cube.productcenter.service.BrandService;
import com.cube.productcenter.vo.BrandVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 289911401@qq.com
 * @description
 * @date
 */
@RequestMapping("/brands")
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/query")
    public Message getAllBrand(@RequestBody(required = false) BrandVO brandVO){
        //todo 需要对参数做统一的验证处理，  加注解，然后在对象的非空字段上加@NotNull注解，类似于这种
        List<BrandVO> allBrand = brandService.getAllBrand(brandVO);
        return ResponseUtil.responseBody(allBrand);
    }

    @GetMapping("/brands/{id}")
    public Message getBrand(@PathVariable String id){
        BrandVO brandOne = brandService.getBrandById(id);
        return ResponseUtil.responseBody(brandOne);
    }

    @PostMapping("/brands/add")
    public Message addBrand(@RequestBody BrandVO brandVO){
        brandService.addBrand(brandVO);
        return ResponseUtil.responseBody("添加成功");
    }

    @PutMapping("/brands")
    public Message editBrand(@RequestBody BrandVO brandVO){
        brandService.updateBrand(brandVO);
        return ResponseUtil.responseBody("更新成功");
    }
    @DeleteMapping("/id")
    public Message delBrand(String id){
        brandService.delBrand(id);
        return ResponseUtil.responseBody("删除成功");
    }
}
