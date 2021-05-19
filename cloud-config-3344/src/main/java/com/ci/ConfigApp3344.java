package com.ci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//开启配置中心
@EnableDiscoveryClient//开启注册中心
public class ConfigApp3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp3344.class,args);
    }
}
