package com.example.RentCarSpb.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.RentCarSpb.Entity.Employee;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret; // JWT 的密鑰，用於簽名 token

    @Value("${jwt.expiration}")
    private Long expiration; // JWT 的過期時間，單位為秒

    // 生成 token，接受 Employee 對象
    public String generateToken(Employee employee) {
        Map<String, Object> claims = new HashMap<>();
        // 可以添加更多 claims，例如角色或用戶 ID
        return doGenerateToken(claims, employee.getEmail()); // 根據 employee 的 email 生成 token
    }

    // 創建 token
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        // 使用 Jwts.builder 創建 token
        return Jwts.builder()
                .setClaims(claims) // 設置 claims
                .setSubject(subject) // 設置主體 (例如用戶名)
                .setIssuedAt(new Date(System.currentTimeMillis())) // 設置 token 發行時間
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000)) // 設置過期時間
                .signWith(SignatureAlgorithm.HS512, secret) // 使用密鑰簽名 token
                .compact(); // 生成 token 字符串
    }

    // 驗證 token
    public Boolean validateToken(String token, String username) {
        // 比對 token 中的用戶名和提供的用戶名是否匹配，並檢查 token 是否過期
        final String tokenUsername = getUsernameFromToken(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    // 從 token 中獲取用戶名
    public String getUsernameFromToken(String token) {
        // 從 token 中提取用戶名
        return getClaimFromToken(token, Claims::getSubject);
    }

    // 從 token 中獲取到期日期
    public Date getExpirationDateFromToken(String token) {
        // 從 token 中提取過期日期
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // 從 token 中獲取聲明
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        // 解析 token，並使用 claimsResolver 提取指定的聲明
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // 解析 token，獲取所有聲明
    private Claims getAllClaimsFromToken(String token) {
        // 解析 token 並提取聲明
        return Jwts.parser()
                .setSigningKey(secret) // 設置簽名密鑰
                .parseClaimsJws(token) // 解析 token
                .getBody(); // 返回聲明
    }

    // 檢查 token 是否已過期
    private Boolean isTokenExpired(String token) {
        // 獲取 token 的過期日期並檢查是否過期
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
}
