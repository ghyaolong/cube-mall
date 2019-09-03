package com.cube.productcenter.controller;

import com.cube.mall.model.Message;
import com.cube.mall.model.ResponseUtil;
import com.cube.productcenter.service.CategoryService;
import com.cube.productcenter.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类管理
 */
@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 所有类别
     * @return
     */
    @GetMapping("/list")
    public Message findAllCategory(){
        List<CategoryVO> categoryVOList = categoryService.findAll();
        return ResponseUtil.responseBody(categoryVOList);
    }


    /**
     * 创建类别
     * @param categoryVO
     * @return
     */
    @PostMapping("/create")
    public Message addCategory(@RequestBody CategoryVO categoryVO){
        return ResponseUtil.responseBody("创建类别成功");
    }

    /**
     * 修改类别
     * @param categoryVO
     * @return
     */
    @PutMapping("update")
    public Message editCategory(@RequestBody CategoryVO categoryVO){
        return ResponseUtil.responseBody("修改类别成功");
    }

    /**
     * 删除类别
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    public Message editCategory(@PathVariable String id){
        return ResponseUtil.responseBody("删除类别成功");
    }




}
