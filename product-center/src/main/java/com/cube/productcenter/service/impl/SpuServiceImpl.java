package com.cube.productcenter.service.impl;

import com.cube.mall.model.PageVO;
import com.cube.productcenter.common.MyBeanUtils;
import com.cube.productcenter.dao.TSpuMapper;
import com.cube.productcenter.po.TSpu;
import com.cube.productcenter.service.SpuService;
import com.cube.productcenter.vo.SpuVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cube.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author tututu
 * @description
 * @date 2019/9/5 20:51
 * @email 289911401@qq.com
 * @since V1.0.0
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private TSpuMapper tSpuMapper;

    @Override
    public PageInfo<SpuVO> findSpuList(PageVO<SpuVO> pageVO) {
        SpuVO spuVO = pageVO.getT();
        Example example = new Example(TSpu.class);
        if(spuVO!=null){
            Example.Criteria criteria = example.createCriteria();
            TSpu tSpu = MyBeanUtils.copy(spuVO, TSpu.class);
            if(!StringUtils.isEmpty(tSpu.getName())){
                criteria.andEqualTo("name",tSpu.getName());
            }

            if(!StringUtils.isEmpty(tSpu.getSpuCode())){
                criteria.andEqualTo("code",tSpu.getSpuCode());
            }

            if(!StringUtils.isEmpty(tSpu.getCategoryId())){
                criteria.andEqualTo("categoryId",tSpu.getCategoryId());
            }

            if(!StringUtils.isEmpty(tSpu.getBrandId())){
                criteria.andEqualTo("brandId",tSpu.getBrandId());
            }

            if(!StringUtils.isEmpty(tSpu.getIntro())){
                criteria.andLike("intro","%"+tSpu.getIntro()+"%");
            }
        }
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        List<TSpu> tSpus = tSpuMapper.selectByExample(example);
        List<SpuVO> spuVOS = MyBeanUtils.copyList(tSpus, SpuVO.class);
        return new PageInfo<>(spuVOS);
    }

    @Override
    public SpuVO findSpuById(String id) {
        TSpu tSpu = tSpuMapper.selectByPrimaryKey(id);
        return MyBeanUtils.copy(tSpu,SpuVO.class);
    }

    @Override
    public void addSpu(SpuVO spuVO) {
        Example example = new Example(TSpu.class);
        TSpu tSpu = MyBeanUtils.copy(spuVO, TSpu.class);
        tSpu.setId(UUIDGenerator.UUID32());
        tSpuMapper.insertSelective(tSpu);
    }

    @Override
    public void updateSpu(SpuVO spuVO) {
        TSpu tSpu = MyBeanUtils.copy(spuVO, TSpu.class);
        tSpuMapper.updateByPrimaryKeySelective(tSpu);
    }

    @Override
    public void delSpuById(String id) {
        tSpuMapper.deleteByPrimaryKey(id);
    }
}
