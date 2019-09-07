package com.cube.productcenter.service.impl;

import com.cube.mall.model.Message;
import com.cube.productcenter.dao.TSkuSpecificationsOptionsMapper;
import com.cube.productcenter.dao.TSpecificationsGroupMapper;
import com.cube.productcenter.dao.TSpecificationsMapper;
import com.cube.productcenter.dao.TSpecificationsOptionsMapper;
import com.cube.productcenter.service.SpecService;
import com.cube.productcenter.vo.SkuSpecificationsOptionsVO;
import com.cube.productcenter.vo.SpecificationsGroupVO;
import com.cube.productcenter.vo.SpecificationsOptionsVO;
import com.cube.productcenter.vo.SpecificationsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Message findByGroupId(String groupId) {
        return null;
    }

    @Override
    public Message findByCategoryId(String categoryId) {
        return null;
    }

    @Override
    public Message findAllOptionsBySpecId(String specId) {
        return null;
    }

    @Override
    public Message findAllOptionsBySkuId(String skuId) {
        return null;
    }

    @Override
    public void addGroup(SpecificationsGroupVO specificationsGroupVO) {

    }

    @Override
    public void addSpec(SpecificationsVO specificationsVO) {

    }

    @Override
    public void addSpecOptions(SpecificationsOptionsVO specificationsOptionsVO) {

    }

    @Override
    public void addSkuSpecOptions(SkuSpecificationsOptionsVO skuSpecificationsOptionsVO) {

    }

    @Override
    public void updateGroup(SpecificationsGroupVO specificationsGroupVO) {

    }

    @Override
    public void updateSpec(SpecificationsVO specificationsVO) {

    }

    @Override
    public void updateSpecOptions(SpecificationsOptionsVO specificationsOptionsVO) {

    }

    @Override
    public void updateSkuSpecOptions(SkuSpecificationsOptionsVO skuSpecificationsOptionsVO) {

    }

    @Override
    public void delGroup(String id) {

    }

    @Override
    public void delSpec(SpecificationsVO specificationsVO) {

    }

    @Override
    public void delSpecOptions(SpecificationsOptionsVO specificationsOptionsVO) {

    }

    @Override
    public void delSkuSpecOptions(SkuSpecificationsOptionsVO skuSpecificationsOptionsVO) {

    }
}
