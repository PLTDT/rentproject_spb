package com.example.RentCarSpb.Dto;

// 定義一個 Data Transfer Object (DTO) 類，用來封裝員工的資料
public class EmployeeDTO {
    
    // 員工的唯一識別碼
    private int employeeid;
    // 員工的姓名
    private String employeename;
    // 員工的電子郵件地址
    private String email;
    // 員工的密碼
    private String password;

    // 帶參數的構造函數，用於初始化 EmployeeDTO 物件
    public EmployeeDTO(int employeeid, String employeename, String email, String password) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.email = email;
        this.password = password;
    }

    // 無參數的構造函數，供 Spring 或其他框架使用
    public EmployeeDTO() {
    }

    // 獲取員工 ID
    public int getEmployeeid() {
        return employeeid;
    }

    // 設置員工 ID
    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    // 獲取員工姓名
    public String getEmployeename() {
        return employeename;
    }

    // 設置員工姓名
    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    // 獲取員工電子郵件
    public String getEmail() {
        return email;
    }

    // 設置員工電子郵件
    public void setEmail(String email) {
        this.email = email;
    }

    // 獲取員工密碼
    public String getPassword() {
        return password;
    }

    // 設置員工密碼
    public void setPassword(String password) {
        this.password = password;
    }

    // 覆寫 toString 方法，用於輸出 EmployeeDTO 物件的字串表示
    @Override
    public String toString() {
        return "EmployeeDTO [employeeid=" + employeeid + ", employeename=" + employeename + ", email=" + email
                + ", password=" + password + "]";
    }

}

