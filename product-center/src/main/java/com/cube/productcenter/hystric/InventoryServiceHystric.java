package com.cube.productcenter.hystric;

import com.cube.mall.enums.ExceptionCode;
import com.cube.mall.model.Message;
import com.cube.mall.model.ResponseUtil;
import com.cube.productcenter.feign.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author 289911401@qq.com
 * @description
 * @date
 */
@Slf4j
@Component
public class InventoryServiceHystric implements InventoryService {
    @Override
    public Message subtractInventroy(String skuId, Integer num) {
        log.error("调用库存服务-subtractInventroy方法失败:入参skuId={},num={}",skuId,num);
        //return null;
        return ResponseUtil.responseBody(ExceptionCode.STOCK_SERVICE_ERROR.getCode(),ExceptionCode.STOCK_SERVICE_ERROR.getMsg());
    }
}
