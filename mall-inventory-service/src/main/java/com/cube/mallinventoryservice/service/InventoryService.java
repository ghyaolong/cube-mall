package com.cube.mallinventoryservice.service;

public interface InventoryService {

    /**
     * 减库存
     * @param skuId
     * @param num
     */
    void subtractInventroy(String skuId,Integer num);
}
