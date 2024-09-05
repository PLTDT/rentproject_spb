package com.example.RentCarSpb.Config;

// 引入 Spring 的註解和密碼編碼器相關的類
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 設置這個類為 Spring 的配置類
@Configuration
public class SecurityConfig {

    // 定義一個 Bean，用於提供密碼編碼器
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 返回一個 BCryptPasswordEncoder 的實例
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://tongbro.ddns.net") // 前端 URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        
        };
    }
}

