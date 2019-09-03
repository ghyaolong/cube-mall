package com.cube.productcenter.service.impl;

import com.cube.productcenter.common.MyBeanUtils;
import com.cube.productcenter.dao.TBrandMapper;
import com.cube.productcenter.po.TBrand;
import com.cube.productcenter.service.BrandService;
import com.cube.productcenter.vo.BrandVO;
import cube.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 *
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TBrandMapper tBrandMapper;

    @Override
    public List<BrandVO> getAllBrand(BrandVO brandVO) {
        Example example = new Example(TBrand.class);
        example.setOrderByClause("createTime desc");
        List<TBrand> tBrands = tBrandMapper.selectByExample(example);
        List<BrandVO> brandVOS = MyBeanUtils.copyList(tBrands, BrandVO.class);
        return brandVOS;
    }

    @Override
    public BrandVO getBrandById(String id) {
        Example example = new Example(TBrand.class);
        example.createCriteria().andEqualTo("id",id);
        TBrand tBrand = tBrandMapper.selectOneByExample(example);
        return MyBeanUtils.copy(tBrand,BrandVO.class);
    }

    @Override
    public void addBrand(BrandVO brandVO) {
        TBrand tBrand = MyBeanUtils.copy(brandVO, TBrand.class);
        tBrand.setId(UUIDGenerator.UUID32());
        tBrandMapper.insertSelective(tBrand);
    }

    @Override
    public void updateBrand(BrandVO brandVO) {
        TBrand tBrand = MyBeanUtils.copy(brandVO, TBrand.class);
        tBrandMapper.updateByPrimaryKeySelective(tBrand);
    }

    @Override
    public void delBrand(String id) {
        tBrandMapper.deleteByPrimaryKey(id);
    }
}
