package com.ci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApp7788 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApp7788.class,args);
    }
}
