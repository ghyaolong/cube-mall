package com.cube.productcenter.service;

import com.cube.productcenter.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有分类
     * @return
     */
    List<CategoryVO> findAll();

    /**
     * 添加分类
     * @param categoryVO
     */
    void addCategoryVO(CategoryVO categoryVO);


    /**
     * 修改
     * @param categoryVO
     */
    void updateCategoryVO(CategoryVO categoryVO);

    /**
     * 删除
     * @param id
     */
    void delCategoryVO(String id);

}
