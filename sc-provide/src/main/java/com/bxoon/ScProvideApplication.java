package com.bxoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ScProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScProvideApplication.class, args);
    }

}
