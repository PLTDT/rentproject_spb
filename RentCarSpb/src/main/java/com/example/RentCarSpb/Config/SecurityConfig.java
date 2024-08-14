package com.example.RentCarSpb.Config;

// 引入 Spring 的註解和密碼編碼器相關的類
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// 設置這個類為 Spring 的配置類
@Configuration
public class SecurityConfig {

    // 定義一個 Bean，用於提供密碼編碼器
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 返回一個 BCryptPasswordEncoder 的實例
        return new BCryptPasswordEncoder();
    }
}

