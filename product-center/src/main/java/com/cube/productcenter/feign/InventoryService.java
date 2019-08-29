package com.cube.productcenter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author 289911401@qq.com
 * @description
 * @date
 */
@FeignClient("mall-inventory-service")
public interface InventoryService {
    @RequestMapping(value = "/inventory/subtract",method = RequestMethod.POST)
    Boolean subtractInventroy(@RequestParam(value="skuId") String skuId,@RequestParam("num") Integer num);
}
