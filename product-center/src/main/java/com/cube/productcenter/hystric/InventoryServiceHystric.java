package com.cube.productcenter.hystric;

import com.cube.mall.model.Message;
import com.cube.productcenter.feign.InventoryService;
import org.springframework.stereotype.Component;

/**
 * @Author 289911401@qq.com
 * @description
 * @date
 */
//@Component
public class InventoryServiceHystric implements InventoryService {
    @Override
    public Message subtractInventroy(String skuId, Integer num) {
        System.out.println("hystrix调用了");
        throw new RuntimeException("库存服务不可用");
    }
}
