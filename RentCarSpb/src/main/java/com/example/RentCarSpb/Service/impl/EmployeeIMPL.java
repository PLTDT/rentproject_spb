package com.example.RentCarSpb.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RentCarSpb.Service.EmployeeService;
import com.example.RentCarSpb.response.LoginResponse;
import com.example.RentCarSpb.Dto.EmployeeDTO;
import com.example.RentCarSpb.Dto.LoginDTO;
import com.example.RentCarSpb.Entity.Employee;
import com.example.RentCarSpb.Repo.EmployeeRepo;

// 標註這個類為 Spring 的服務組件
@Service
public class EmployeeIMPL implements EmployeeService { 
    
    // 注入 EmployeeRepo，用於與數據庫進行交互
    @Autowired
    private EmployeeRepo employeeRepo;

    // 注入 PasswordEncoder，用於密碼加密和驗證
    @Autowired
    private PasswordEncoder passwordEncode;

    // 實現添加員工的方法
    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {

        // 創建 Employee 實體，將密碼進行加密處理
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncode.encode(employeeDTO.getPassword())
        );

        // 保存員工實體到數據庫
        employeeRepo.save(employee);

        // 返回員工姓名
        return employee.getEmployeename();
    }

    // 實現登錄員工的方法
    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        // 根據電子郵件查找員工
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        
        if (employee1 != null) {
            // 比對密碼是否匹配
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncode.matches(password, encodedPassword);
            
            if (isPwdRight) {
                // 如果密碼匹配，根據電子郵件和密碼查找員工
                Optional<Employee> employee = employeeRepo.findByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                
                if (employee.isPresent()) {
                    // 返回登錄成功的響應
                    return new LoginResponse("Login Success", true);
                } else {
                    // 如果找不到匹配的員工，返回登錄失敗的響應
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                // 密碼不匹配，返回登錄不匹配的響應
                return new LoginResponse("Login Not Match", false);
            }
        } else {
            // 如果電子郵件找不到對應的員工，返回電子郵件不存在的響應
            return new LoginResponse("Email not exits", false);
        }
    }
}

