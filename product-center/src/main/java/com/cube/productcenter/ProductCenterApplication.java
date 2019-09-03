package com.cube.productcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan({"com.cube.productcenter.dao"})
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
/*@SpringCloudApplication*/
public class ProductCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCenterApplication.class, args);
    }

}
