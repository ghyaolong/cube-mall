package com.cube.productcenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.cube.IDGeneratorUtils;
import com.cube.productcenter.common.MyBeanUtils;
import com.cube.productcenter.dao.TCategoryMapper;
import com.cube.productcenter.po.TCategory;
import com.cube.productcenter.service.CategoryService;
import com.cube.productcenter.vo.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 分类管理
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private TCategoryMapper tCategoryMapper;

    @Override
    public List<CategoryVO> findAll() {
        log.info("查询所有类别start");
        Example example = new Example(TCategory.class);
        example.createCriteria().andEqualTo("parentId",0);
        example.setOrderByClause("sequence asc");
        List<TCategory> tCategories = tCategoryMapper.selectByExample(example);
        List<CategoryVO> categoryVOS = MyBeanUtils.copyList(tCategories, CategoryVO.class);
        for (CategoryVO categoryVO : categoryVOS) {
            findCategory(categoryVO);
        }
        log.info("查询所有类别END，结果{}", JSON.toJSONString(categoryVOS));
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
        log.info("添加类别,入参[{}]",JSON.toJSONString(categoryVO));
        TCategory tCategory = MyBeanUtils.copy(categoryVO, TCategory.class);
        tCategory.setId(IDGeneratorUtils.UUID32());
        tCategoryMapper.insertSelective(tCategory);
        log.info("添加类别成功");
    }

    @Override
    public void updateCategoryVO(CategoryVO categoryVO) {
        log.info("修改类别,入参[{}]",JSON.toJSONString(categoryVO));
        TCategory tCategory = MyBeanUtils.copy(categoryVO, TCategory.class);
        tCategoryMapper.updateByPrimaryKeySelective(tCategory);
        log.info("修改类别成功");
    }

    @Override
    public void delCategoryVO(String id) {
        log.info("删除类别,入参[{}]",id);
        tCategoryMapper.deleteByPrimaryKey(id);
        log.info("删除类别成功");
    }
}
