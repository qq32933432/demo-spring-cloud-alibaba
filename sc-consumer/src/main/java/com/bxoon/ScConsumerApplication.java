package com.bxoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 开启服务注册与发现
@EnableDiscoveryClient
// 开启 Feign 客户端
@EnableFeignClients
@SpringBootApplication
public class ScConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScConsumerApplication.class, args);
    }

}