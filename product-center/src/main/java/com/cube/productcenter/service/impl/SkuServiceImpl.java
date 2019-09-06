package com.cube.productcenter.service.impl;

import com.cube.mall.model.PageVO;
import com.cube.productcenter.common.MyBeanUtils;
import com.cube.productcenter.dao.TSkuMapper;
import com.cube.productcenter.po.TSku;
import com.cube.productcenter.po.TSpu;
import com.cube.productcenter.service.SkuService;
import com.cube.productcenter.vo.SkuVO;
import com.cube.productcenter.vo.SpuVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author tututu
 * @desc todo
 * @Date 2019/9/6 18:06
 * @email 289911401@qq.com
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private TSkuMapper tSkuMapper;

    @Override
    public PageInfo<SkuVO> findSkuList(PageVO<SkuVO> pageVO) {
        SkuVO skuVO = pageVO.getT();
        Example example = new Example(TSku.class);
        if(skuVO!=null){
            Example.Criteria criteria = example.createCriteria();
            TSku tSku = MyBeanUtils.copy(skuVO, TSku.class);
            if(!StringUtils.isEmpty(tSku.getName())){
                criteria.andEqualTo("name",tSku.getName());
            }

            if(!StringUtils.isEmpty(tSku.getCode())){
                criteria.andEqualTo("code",tSku.getCode());
            }

            if(!StringUtils.isEmpty(tSku.getSpuId())){
                criteria.andEqualTo("spuId",tSku.getSpuId());
            }

            /**
             * 判断库存
             */
            if(!StringUtils.isEmpty(skuVO.getStartStock()) && StringUtils.isEmpty(skuVO.getEndStock())){
                criteria.andGreaterThanOrEqualTo("stock",skuVO.getStartStock());
            }

            if(StringUtils.isEmpty(skuVO.getStartStock()) && !StringUtils.isEmpty(skuVO.getEndStock())){
                criteria.andLessThanOrEqualTo("stock",skuVO.getStartStock());
            }

            if(!StringUtils.isEmpty(skuVO.getStartStock()) && !StringUtils.isEmpty(skuVO.getEndStock())){
                criteria.andBetween("stock",skuVO.getStartStock(),skuVO.getEndStock());
            }

            /**
             * 判断价格
             */
            if(!StringUtils.isEmpty(skuVO.getStartPrice()) && StringUtils.isEmpty(skuVO.getEndPrice())){
                criteria.andGreaterThanOrEqualTo("price",skuVO.getStartPrice());
            }

            if(StringUtils.isEmpty(skuVO.getStartPrice()) && !StringUtils.isEmpty(skuVO.getEndPrice())){
                criteria.andLessThanOrEqualTo("price",skuVO.getStartStock());
            }

            if(!StringUtils.isEmpty(skuVO.getStartPrice()) && !StringUtils.isEmpty(skuVO.getEndPrice())){
                criteria.andBetween("price",skuVO.getStartStock(),skuVO.getEndStock());
            }

        }
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        List<TSku> tSkus = tSkuMapper.selectByExample(example);
        List<SkuVO> skuVOS = MyBeanUtils.copyList(tSkus, SkuVO.class);
        return new PageInfo<>(skuVOS);
    }

    @Override
    public SkuVO findSkuById(Object id) {
        TSku tSku = tSkuMapper.selectByPrimaryKey(id);
        return MyBeanUtils.copy(tSku,SkuVO.class);
    }

    @Override
    public void addSku(SkuVO skuVO) {

    }

    @Override
    public void updateSku(SkuVO skuVO) {

    }

    @Override
    public void delSkuById(String id) {

    }


}
