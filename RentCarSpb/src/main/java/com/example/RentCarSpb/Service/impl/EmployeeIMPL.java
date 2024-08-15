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
    Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
    
    if (employee1 != null) {
        String password = loginDTO.getPassword();
        String encodedPassword = employee1.getPassword();
        Boolean isPwdRight = passwordEncode.matches(password, encodedPassword);
        
        if (isPwdRight) {
            Optional<Employee> employee = employeeRepo.findByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
            
            if (employee.isPresent()) {
                EmployeeDTO employeeDTO = new EmployeeDTO(
                    employee1.getEmployeeid(),
                    employee1.getEmployeename(),
                    employee1.getEmail(),
                    null // 不返回密碼
                );
                return new LoginResponse("Login Success", true, employeeDTO);
            } else {
                return new LoginResponse("Login Failed", false);
            }
        } else {
            return new LoginResponse("Login Not Match", false);
        }
    } else {
        return new LoginResponse("Email not exists", false);
    }
}

}

