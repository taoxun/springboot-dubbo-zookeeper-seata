package com.viewscenes.storage;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.viewscenes.storage.mapper")
@DubboComponentScan(basePackages = "com.viewscenes.storage.dubbo")
public class SpringbootDubboStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboStorageApplication.class, args);
    }

}
