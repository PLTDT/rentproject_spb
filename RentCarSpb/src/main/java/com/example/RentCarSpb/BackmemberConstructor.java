package com.example.RentCarSpb;

public class BackmemberConstructor {
    private int employee_id;
    private String email;
    private String employee_name;
    private String password;

    // 強制要求傳入參數的構造函數
    public BackmemberConstructor(int employee_id, String email,String employee_name, String password) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.email = email;
        this.password = password;
    }

    // 可選的無參構造函數，設置默認值
    public BackmemberConstructor() {
        this.employee_id = 0;
        this.employee_name = "DefaultName";
        this.email = "default@example.com";
        this.password = "defaultPassword";
    }

    public int getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployeeName() {
        return employee_name;
    }

    public void setEmployeeName(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BackmemberConstructor [employee_id=" + employee_id + ", employee_name=" + employee_name + ", email=" + email + ", password=" + password + "]";
    }
}
