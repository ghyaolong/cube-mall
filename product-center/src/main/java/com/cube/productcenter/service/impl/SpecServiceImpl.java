package com.cube.productcenter.service.impl;

import com.cube.IDGenerator;
import com.cube.productcenter.common.MyBeanUtils;
import com.cube.productcenter.dao.TSkuSpecificationsOptionsMapper;
import com.cube.productcenter.dao.TSpecificationsGroupMapper;
import com.cube.productcenter.dao.TSpecificationsMapper;
import com.cube.productcenter.dao.TSpecificationsOptionsMapper;
import com.cube.productcenter.po.TSkuSpecificationsOptions;
import com.cube.productcenter.po.TSpecifications;
import com.cube.productcenter.po.TSpecificationsGroup;
import com.cube.productcenter.po.TSpecificationsOptions;
import com.cube.productcenter.service.SpecService;
import com.cube.productcenter.vo.SkuSpecificationsOptionsVO;
import com.cube.productcenter.vo.SpecificationsGroupVO;
import com.cube.productcenter.vo.SpecificationsOptionsVO;
import com.cube.productcenter.vo.SpecificationsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 规格相关业务逻辑
 */
@Service
public class SpecServiceImpl implements SpecService {

    @Autowired
    private TSpecificationsGroupMapper tSpecificationsGroupMapper;

    @Autowired
    private TSpecificationsMapper tSpecificationsMapper;

    @Autowired
    private TSpecificationsOptionsMapper tSpecificationsOptionsMapper;

    @Autowired
    private TSkuSpecificationsOptionsMapper tSkuSpecificationsOptionsMapper;


    @Override
    public List<SpecificationsVO> findByGroupId(String groupId) {
        Example example = new Example(TSpecifications.class);
        example.createCriteria().andEqualTo("specificGroupId",groupId);
        List<TSpecifications> tSpecifications = tSpecificationsMapper.selectByExample(example);
        return MyBeanUtils.copyList(tSpecifications,SpecificationsVO.class);
    }

    @Override
    public List<SpecificationsVO> findByCategoryId(String categoryId) {
        Example example = new Example(TSpecifications.class);
        example.createCriteria().andEqualTo("categoryId",categoryId);
        List<TSpecifications> tSpecifications = tSpecificationsMapper.selectByExample(example);
        return MyBeanUtils.copyList(tSpecifications,SpecificationsVO.class);
    }

    @Override
    public List<SpecificationsOptionsVO> findAllOptionsBySpecId(String specId) {
        Example example = new Example(TSpecificationsOptions.class);
        example.createCriteria().andEqualTo("specifictionId",specId);
        List<TSpecificationsOptions> tSpecificationsOptions = tSpecificationsOptionsMapper.selectByExample(example);
        return MyBeanUtils.copyList(tSpecificationsOptions,SpecificationsOptionsVO.class);
    }

    @Override
    public List<SpecificationsOptionsVO> findAllOptionsBySkuId(String skuId) {
        return null;
    }

    @Override
    public void addGroup(SpecificationsGroupVO specificationsGroupVO) {
        TSpecificationsGroup copy = MyBeanUtils.copy(specificationsGroupVO, TSpecificationsGroup.class);
        copy.setId(IDGenerator.UUID32());
        tSpecificationsGroupMapper.insertSelective(copy);
    }

    @Override
    public void addSpec(SpecificationsVO specificationsVO) {
        TSpecifications copy = MyBeanUtils.copy(specificationsVO, TSpecifications.class);
        copy.setId(IDGenerator.UUID32());
        tSpecificationsMapper.insertSelective(copy);
    }

    @Override
    public void addSpecOptions(SpecificationsOptionsVO specificationsOptionsVO) {
        TSpecificationsOptions copy = MyBeanUtils.copy(specificationsOptionsVO, TSpecificationsOptions.class);
        copy.setId(IDGenerator.UUID32());
        tSpecificationsOptionsMapper.insertSelective(copy);
    }

    @Override
    public void addSkuSpecOptions(SkuSpecificationsOptionsVO skuSpecificationsOptionsVO) {
        TSkuSpecificationsOptions copy = MyBeanUtils.copy(skuSpecificationsOptionsVO, TSkuSpecificationsOptions.class);
        copy.setId(IDGenerator.UUID32());
        tSkuSpecificationsOptionsMapper.insertSelective(copy);
    }

    @Override
    public void updateGroup(SpecificationsGroupVO specificationsGroupVO) {
        TSpecificationsGroup copy = MyBeanUtils.copy(specificationsGroupVO, TSpecificationsGroup.class);
        tSpecificationsGroupMapper.updateByPrimaryKeySelective(copy);
    }

    @Override
    public void updateSpec(SpecificationsVO specificationsVO) {
        TSpecifications copy = MyBeanUtils.copy(specificationsVO, TSpecifications.class);
        tSpecificationsMapper.updateByPrimaryKeySelective(copy);
    }

    @Override
    public void updateSpecOptions(SpecificationsOptionsVO specificationsOptionsVO) {
        TSpecificationsOptions copy = MyBeanUtils.copy(specificationsOptionsVO, TSpecificationsOptions.class);
        tSpecificationsOptionsMapper.updateByPrimaryKeySelective(copy);
    }

    @Override
    public void updateSkuSpecOptions(SkuSpecificationsOptionsVO skuSpecificationsOptionsVO) {
        TSkuSpecificationsOptions copy = MyBeanUtils.copy(skuSpecificationsOptionsVO, TSkuSpecificationsOptions.class);
        tSkuSpecificationsOptionsMapper.updateByPrimaryKeySelective(copy);
    }

    @Override
    public void delGroup(String id) {
        tSpecificationsGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delSpec(SpecificationsVO specificationsVO) {
        tSpecificationsMapper.delete(MyBeanUtils.copy(specificationsVO,TSpecifications.class));
    }

    @Override
    public void delSpecOptions(SpecificationsOptionsVO specificationsOptionsVO) {
        tSpecificationsOptionsMapper.delete(MyBeanUtils.copy(specificationsOptionsVO,TSpecificationsOptions.class));
    }

    @Override
    public void delSkuSpecOptions(SkuSpecificationsOptionsVO skuSpecificationsOptionsVO) {
        tSkuSpecificationsOptionsMapper.delete(MyBeanUtils.copy(skuSpecificationsOptionsVO,TSkuSpecificationsOptions.class));
    }
}
