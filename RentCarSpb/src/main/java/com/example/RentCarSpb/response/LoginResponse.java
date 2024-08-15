package com.example.RentCarSpb.response;

import com.example.RentCarSpb.Dto.EmployeeDTO;

// 定義一個用於登錄響應的類
public class LoginResponse {
    private String message;
    private Boolean status;
    private EmployeeDTO user; // 新增用戶資訊字段

    // 帶參數的構造函數，用於初始化 LoginResponse 物件
    public LoginResponse(String message, Boolean status, EmployeeDTO user) {
        this.message = message;
        this.status = status;
        this.user = user;
    }

    // 保持原有的構造函數
    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    // 無參數的構造函數，供框架和序列化操作使用
    public LoginResponse() {
    }

    // 獲取響應消息
    public String getMessage() {
        return message;
    }

    // 設置響應消息
    public void setMessage(String message) {
        this.message = message;
    }

    // 獲取登錄狀態
    public Boolean getStatus() {
        return status;
    }

    // 設置登錄狀態
    public void setStatus(Boolean status) {
        this.status = status;
    }

    // 獲取用戶資訊
    public EmployeeDTO getUser() {
        return user;
    }

    // 設置用戶資訊
    public void setUser(EmployeeDTO user) {
        this.user = user;
    }

    // 覆寫 toString 方法，用於輸出 LoginResponse 物件的字串表示
    @Override
    public String toString() {
        return "LoginResponse [message=" + message + ", status=" + status + ", user=" + user + "]";
    }
}
