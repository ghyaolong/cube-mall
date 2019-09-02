package com.cube.productcenter.fallback;

import com.cube.mall.model.Message;
import com.cube.mall.model.ResponseUtil;
import com.cube.productcenter.feign.InventoryService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author 289911401@qq.com
 * @description
 * @date
 */
@Component
public class InventoryServiceFallbackFactory implements FallbackFactory<InventoryService> {

    @Override
    public InventoryService create(Throwable throwable) {
        return new InventoryService() {
            @Override
            public Message subtractInventroy(String skuId, Integer num) {
                return ResponseUtil.responseBody(throwable.getMessage());
                //return null;
            }
        };
    }
}
