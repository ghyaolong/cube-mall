package com.cube.productcenter.service.impl;

import com.cube.IDGenerator;
import com.cube.productcenter.common.MyBeanUtils;
import com.cube.productcenter.dao.TAttributeMapper;
import com.cube.productcenter.dao.TAttributeOptionsMapper;
import com.cube.productcenter.dao.TSkuOptionsMapper;
import com.cube.productcenter.po.TAttribute;
import com.cube.productcenter.po.TAttributeOptions;
import com.cube.productcenter.po.TSkuOptions;
import com.cube.productcenter.service.AttributeService;
import com.cube.productcenter.vo.AttributeOptionsVO;
import com.cube.productcenter.vo.AttributeVO;
import com.cube.productcenter.vo.SkuOptionsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author tututu
 * @desc 属性相关操作
 * @Date 2019/9/9 15:13
 * @email 289911401@qq.com
 */
@Service
public class AttributeServiceImpl implements AttributeService {



    @Autowired
    private TAttributeMapper tAttributeMapper;

    @Autowired
    private TAttributeOptionsMapper tAttributeOptionsMapper;

    @Autowired
    private TSkuOptionsMapper tSkuOptionsMapper;

    @Override
    public List<AttributeVO> findAllByCategoryId(String categoryId) {
        Example example = new Example(TAttribute.class);
        example.createCriteria().andEqualTo("categoryId",categoryId);
        List<TAttribute> tAttributes = tAttributeMapper.selectByExample(example);
        List<AttributeVO> attributeVOList = MyBeanUtils.copyList(tAttributes, AttributeVO.class);
        return attributeVOList;
    }


    @Override
    public List<AttributeOptionsVO> findAllAttributeOptionsById(String attributeId) {
        Example example = new Example(TAttributeOptions.class);
        example.createCriteria().andEqualTo("attributeId",attributeId);
        List<TAttributeOptions> tAttributeOptions = tAttributeOptionsMapper.selectByExample(example);
        List<AttributeOptionsVO> attributeOptionsVOList = MyBeanUtils.copyList(tAttributeOptions, AttributeOptionsVO.class);
        return attributeOptionsVOList;
    }

    @Override
    public List<AttributeOptionsVO> findAllAttributeOptionsBySkuId(String skuId) {
        List<TAttributeOptions> tAttributeOptionsList = tAttributeMapper.findAllAttributeOptionsBySkuId(skuId);
        List<AttributeOptionsVO> attributeOptionsVOS = MyBeanUtils.copyList(tAttributeOptionsList, AttributeOptionsVO.class);
        return attributeOptionsVOS ;
    }

    @Override
    public void addAttribute(AttributeVO attributeVO) {
        TAttribute tAttribute = MyBeanUtils.copy(attributeVO, TAttribute.class);
        tAttribute.setId(IDGenerator.UUID32());
        tAttributeMapper.insertSelective(tAttribute);
    }

    @Override
    public void updateAttribute(AttributeVO attributeVO) {
        TAttribute tAttribute = MyBeanUtils.copy(attributeVO, TAttribute.class);
        tAttributeMapper.updateByPrimaryKeySelective(tAttribute);
    }

    @Override
    public void delAttributeById(String id) {
        tAttributeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addAttributeOptions(AttributeOptionsVO attributeOptionsVO) {
        TAttributeOptions tAttributeOptions = MyBeanUtils.copy(attributeOptionsVO, TAttributeOptions.class);
        tAttributeOptions.setId(IDGenerator.UUID32());
        tAttributeOptionsMapper.insertSelective(tAttributeOptions);
    }

    @Override
    public void updateAttributeOptions(AttributeOptionsVO attributeOptionsVO) {
        TAttributeOptions tAttributeOptions = MyBeanUtils.copy(attributeOptionsVO, TAttributeOptions.class);
        tAttributeOptionsMapper.updateByPrimaryKeySelective(tAttributeOptions);
    }

    @Override
    public void delAttributeOptionsById(String id) {
        tAttributeOptionsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addSkuOptions(SkuOptionsVO skuOptionsVO) {
        TSkuOptions tSkuOptions = MyBeanUtils.copy(skuOptionsVO, TSkuOptions.class);
        tSkuOptions.setId(IDGenerator.UUID32());
        tSkuOptionsMapper.insertSelective(tSkuOptions);
    }

    @Override
    public void updateSkuOptions(SkuOptionsVO skuOptionsVO) {
        TSkuOptions tSkuOptions = MyBeanUtils.copy(skuOptionsVO, TSkuOptions.class);
        tSkuOptionsMapper.updateByPrimaryKeySelective(tSkuOptions);
    }

    @Override
    public void delSkuOptions(SkuOptionsVO skuOptionsVO) {
        TSkuOptions tSkuOptions = MyBeanUtils.copy(skuOptionsVO, TSkuOptions.class);
        tSkuOptionsMapper.delete(tSkuOptions);
    }
}
