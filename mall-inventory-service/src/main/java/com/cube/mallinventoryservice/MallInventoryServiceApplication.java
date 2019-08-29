package com.cube.mallinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan({"com.cube.mallinventoryservice.dao"})
@EnableEurekaClient
@SpringBootApplication
public class MallInventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallInventoryServiceApplication.class, args);
    }

}
