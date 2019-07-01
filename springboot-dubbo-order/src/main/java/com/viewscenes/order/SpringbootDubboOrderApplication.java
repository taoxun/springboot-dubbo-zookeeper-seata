package com.viewscenes.order;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.viewscenes.order.mapper")
@DubboComponentScan(basePackages = "com.viewscenes.order.dubbo")
public class SpringbootDubboOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboOrderApplication.class, args);
    }

}
