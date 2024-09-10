package com.example.RentCarSpb.back;

public class BackregisterConstructor {
    private String employee_name;
    private String employee_password;
    private String employee_position;
    private String employee_dep;

    // 全參數建構子
    public BackregisterConstructor(String employee_name, String employee_password, String employee_position, String employee_dep) {
        this.employee_name = employee_name;
        this.employee_password = employee_password;
        this.employee_position = employee_position;
        this.employee_dep = employee_dep;
    }

    // Getter 和 Setter 方法
    public String getEmployeeName() {
        return employee_name;
    }

    public void setEmployeeName(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployeePassword() {
        return employee_password;
    }

    public void setEmployeePassword(String employee_password) {
        this.employee_password = employee_password;
    }

    public String getEmployeePosition() {
        return employee_position;
    }

    public void setEmployeePosition(String employee_position) {
        this.employee_position = employee_position;
    }

    public String getEmployeeDep() {
        return employee_dep;
    }

    public void setEmployeeDep(String employee_dep) {
        this.employee_dep = employee_dep;
    }

    // toString 方法，可選，用於打印對象內容
    @Override
    public String toString() {
        return "BackregisterConstructor [employee_name=" + employee_name + ", employee_password=" + employee_password
                + ", employee_position=" + employee_position + ", employee_dep=" + employee_dep + "]";
    }
}
