package com.example.RentCarSpb.Entity;

// 引入必要的 JPA 類和註解
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GenerationType;

// 標註這個類為 JPA 實體，對應到數據庫中的表
@Entity
// 指定這個實體對應的數據庫表名及唯一約束
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Employee {
    
    // 標註這個屬性為主鍵
    @Id
    // 指定數據庫表中的列名及長度
    @Column(name = "employee_id", length = 45)
    // 指定主鍵生成策略
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;

    // 指定數據庫表中的列名及長度
    @Column(name = "employee_name", length = 255)
    private String employeename;

    // 指定數據庫表中的列名及長度
    @Column(name = "email", length = 255)
    private String email;

    // 指定數據庫表中的列名及長度
    @Column(name = "password", length = 255)
    private String password;

    // 帶參數的構造函數，用於初始化 Employee 物件
    public Employee(int employeeid, String employeename, String email, String password) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.email = email;
        this.password = password;
    }

    // 無參數的構造函數，供 JPA 和其他框架使用
    public Employee() {
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

    // 覆寫 toString 方法，用於輸出 Employee 物件的字串表示
    @Override
    public String toString() {
        return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", email=" + email
                + ", password=" + password + "]";
    }
}

