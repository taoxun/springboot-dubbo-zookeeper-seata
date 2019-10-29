package com.viewscenes.storage;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.viewscenes.storage.mapper")
@DubboComponentScan(basePackages = "com.viewscenes.storage.dubbo")
@ComponentScan(basePackages={"com.viewscenes.storage","com.viewscenes.common"})
public class SpringbootDubboStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboStorageApplication.class, args);
    }

}
