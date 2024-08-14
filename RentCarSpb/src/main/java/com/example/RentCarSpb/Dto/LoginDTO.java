package com.example.RentCarSpb.Dto;

// 定義一個 Data Transfer Object (DTO) 類，用來封裝登錄所需的資料
public class LoginDTO {
    
    // 用戶的電子郵件地址
    private String email;
    // 用戶的密碼
    private String password;

    // 帶參數的構造函數，用於初始化 LoginDTO 物件
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // 無參數的構造函數，供 Spring 或其他框架使用
    public LoginDTO() {
    }

    // 獲取用戶的電子郵件
    public String getEmail() {
        return email;
    }

    // 設置用戶的電子郵件
    public void setEmail(String email) {
        this.email = email;
    }

    // 獲取用戶的密碼
    public String getPassword() {
        return password;
    }

    // 設置用戶的密碼
    public void setPassword(String password) {
        this.password = password;
    }

    // 覆寫 toString 方法，用於輸出 LoginDTO 物件的字串表示
    @Override
    public String toString() {
        return "LoginDTO [email=" + email + ", password=" + password + "]";
    }

}

