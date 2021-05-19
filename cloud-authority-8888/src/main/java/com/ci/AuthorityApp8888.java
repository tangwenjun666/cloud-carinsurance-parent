package com.ci;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.ci.mapper")
@EnableDiscoveryClient//开启注册中心
public class AuthorityApp8888 {
    public static void main(String[] args) {
        SpringApplication.run(AuthorityApp8888.class,args);
    }
}
