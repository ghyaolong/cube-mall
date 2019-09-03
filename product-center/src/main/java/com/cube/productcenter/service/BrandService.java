package com.cube.productcenter.service;

import com.cube.productcenter.vo.BrandVO;

import java.util.List;

/**
 *
 */
public interface BrandService {

    List<BrandVO> getAllBrand(BrandVO brandVO);

    BrandVO getBrandById(String id);

    void addBrand(BrandVO brandVO);

    void updateBrand(BrandVO brandVO);

    void delBrand(String id);
}
