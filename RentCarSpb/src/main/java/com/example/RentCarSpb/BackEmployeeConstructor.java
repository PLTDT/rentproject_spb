package com.example.RentCarSpb;

public class BackEmployeeConstructor {

    private int employee_id;
    private String employee_name;
    private String employee_position;
    private String employee_dep;

    // 強制要求傳入參數的構造函數（私有構造函數）
    private BackEmployeeConstructor(int employee_id, String employee_name, String employee_position, String employee_dep) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_position = employee_position;
        this.employee_dep = employee_dep;
    }

    // 可選的無參構造函數，設置默認值（私有構造函數）
    private BackEmployeeConstructor() {
        this.employee_id = 0;
        this.employee_name = "DefaultName";
        this.employee_position = "DefaultPosition";
        this.employee_dep = "DefaultDep";
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

    @Override
    public String toString() {
        return "BackEmployeeConstructor [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_position=" + employee_position + ", employee_dep=" + employee_dep + "]";
    }
}
