package com.cube.productcenter.service.impl;

import com.cube.productcenter.common.MyBeanUtils;
import com.cube.productcenter.dao.TCategoryMapper;
import com.cube.productcenter.po.TCategory;
import com.cube.productcenter.service.CategoryService;
import com.cube.productcenter.vo.CategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类管理
 */
@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private TCategoryMapper tCategoryMapper;

    @Override
    public List<CategoryVO> findAll() {
        Example example = new Example(TCategory.class);
        example.createCriteria().andEqualTo("parentId",0);
        List<CategoryVO> voList = new ArrayList<>();
        example.setOrderByClause("sequence asc");
        List<TCategory> tCategories = tCategoryMapper.selectByExample(example);
        List<CategoryVO> categoryVOS = MyBeanUtils.copyList(tCategories, CategoryVO.class);
        for (CategoryVO categoryVO : categoryVOS) {
            findCategory(categoryVO);
        }
        return categoryVOS;
    }

    private void findCategory(CategoryVO vo) {
        Example example = new Example(TCategory.class);
        example.createCriteria().andEqualTo("parentId",vo.getId());
        example.setOrderByClause("sequence asc");
        List<TCategory> tCategories = tCategoryMapper.selectByExample(example);
        List<CategoryVO> listVO = MyBeanUtils.copyList(tCategories, CategoryVO.class, "listVO");
        vo.setListVO(listVO);
        for (TCategory tCategory : tCategories) {
            CategoryVO categoryVO = MyBeanUtils.copy(tCategory, CategoryVO.class);
            findCategory(categoryVO);
        }
    }


    @Override
    public void addCategoryVO(CategoryVO categoryVO) {

    }

    @Override
    public void updateCategoryVO(CategoryVO categoryVO) {

    }

    @Override
    public void delCategoryVO(String id) {

    }
}
