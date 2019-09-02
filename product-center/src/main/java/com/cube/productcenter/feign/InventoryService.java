package com.cube.productcenter.feign;

import com.cube.mall.model.Message;
import com.cube.productcenter.fallback.InventoryServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author 289911401@qq.com
 * @description
 * @date
 */
/*@FeignClient(value = "mall-inventory-service",fallback = InventoryServiceHystric.class)*/
@FeignClient(value = "mall-inventory-service",fallback = InventoryServiceFallbackFactory.class)
public interface InventoryService {
    @RequestMapping(value = "/inventory/subtract",method = RequestMethod.POST)
    Message subtractInventroy(@RequestParam(value="skuId") String skuId, @RequestParam("num") Integer num);
}
