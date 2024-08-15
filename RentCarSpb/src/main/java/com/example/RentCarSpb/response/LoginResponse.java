package com.example.RentCarSpb.response;

import com.example.RentCarSpb.Dto.EmployeeDTO;

public class LoginResponse {
    private String message; // 登入結果的消息
    private Boolean status; // 登入結果的狀態，成功為 true，失敗為 false
    private EmployeeDTO user; // 登入的使用者資訊
    private String token; // JWT token，用於後續的身份驗證

    // 帶參數的構造函數，用於初始化 LoginResponse 物件，包含消息、狀態、使用者資訊和 token
    public LoginResponse(String message, Boolean status, EmployeeDTO user, String token) {
        this.message = message;
        this.status = status;
        this.user = user;
        this.token = token;
    }

    // 帶參數的構造函數，用於初始化 LoginResponse 物件，包含消息、狀態和使用者資訊
    public LoginResponse(String message, Boolean status, EmployeeDTO user) {
        this.message = message;
        this.status = status;
        this.user = user;
    }

    // 帶參數的構造函數，用於初始化 LoginResponse 物件，包含消息和狀態
    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    // 無參數的構造函數，供序列化和反序列化使用
    public LoginResponse() {
    }

    // 獲取消息
    public String getMessage() {
        return message;
    }

    // 設置消息
    public void setMessage(String message) {
        this.message = message;
    }

    // 獲取狀態
    public Boolean getStatus() {
        return status;
    }

    // 設置狀態
    public void setStatus(Boolean status) {
        this.status = status;
    }

    // 獲取使用者資訊
    public EmployeeDTO getUser() {
        return user;
    }

    // 設置使用者資訊
    public void setUser(EmployeeDTO user) {
        this.user = user;
    }

    // 獲取 JWT token
    public String getToken() {
        return token;
    }

    // 設置 JWT token
    public void setToken(String token) {
        this.token = token;
    }

    // 重寫 toString 方法，以便於打印 LoginResponse 物件的內容
    @Override
    public String toString() {
        return "LoginResponse [message=" + message + ", status=" + status + ", user=" + user + ", token=" + token + "]";
    }
}
