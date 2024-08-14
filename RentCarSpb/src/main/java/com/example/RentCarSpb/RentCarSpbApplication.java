package com.example.RentCarSpb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// 標註這個類為 Spring Boot 應用的入口點
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RentCarSpbApplication {

    // 應用程序的主方法，用於啟動 Spring Boot 應用
    public static void main(String[] args) {
        // 使用 SpringApplication 類的 run 方法啟動應用
        SpringApplication.run(RentCarSpbApplication.class, args);
    }
}

