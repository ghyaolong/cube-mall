package com.cube.productcenter.service;


import com.cube.productcenter.vo.SkuSpecificationsOptionsVO;
import com.cube.productcenter.vo.SpecificationsGroupVO;
import com.cube.productcenter.vo.SpecificationsOptionsVO;
import com.cube.productcenter.vo.SpecificationsVO;

import java.util.List;

public interface SpecService {

    /**
     * 查询该规格组下所有规格
     * @param groupId
     * @return
     */
    List<SpecificationsVO> findByGroupId(String groupId);
    /**
     * 查询categoryId下所有的规格
     * @param categoryId
     * @return
     */
    List<SpecificationsVO> findByCategoryId(String categoryId);

    /**
     * 查询该规格id下所有的选项
     * @param specId
     * @return
     */
    List<SpecificationsOptionsVO> findAllOptionsBySpecId(String specId);

    /**
     * 查询该SkuId下所有的规格选项
     * @param skuId
     * @return
     */
    List<SpecificationsOptionsVO> findAllOptionsBySkuId(String skuId);

    void addGroup(SpecificationsGroupVO specificationsGroupVO);

    void addSpec(SpecificationsVO specificationsVO);

    void addSpecOptions(SpecificationsOptionsVO specificationsOptionsVO);

    void addSkuSpecOptions(SkuSpecificationsOptionsVO skuSpecificationsOptionsVO);

    //
    void updateGroup(SpecificationsGroupVO specificationsGroupVO);

    void updateSpec(SpecificationsVO specificationsVO);

    void updateSpecOptions(SpecificationsOptionsVO specificationsOptionsVO);

    void updateSkuSpecOptions(SkuSpecificationsOptionsVO skuSpecificationsOptionsVO);

    //
    void delGroup(String id);

    void delSpec(SpecificationsVO specificationsVO);

    void delSpecOptions(SpecificationsOptionsVO specificationsOptionsVO);

    void delSkuSpecOptions(SkuSpecificationsOptionsVO skuSpecificationsOptionsVO);


}
