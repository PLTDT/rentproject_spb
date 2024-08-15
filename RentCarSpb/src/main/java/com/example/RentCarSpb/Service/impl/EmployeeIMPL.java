package com.example.RentCarSpb.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.RentCarSpb.Dto.EmployeeDTO;
import com.example.RentCarSpb.Service.EmployeeService;
import com.example.RentCarSpb.response.LoginResponse;
import com.example.RentCarSpb.Dto.EmployeeResponseWebDTO;
import com.example.RentCarSpb.Dto.LoginDTO;
import com.example.RentCarSpb.Entity.Employee;
import com.example.RentCarSpb.Repo.EmployeeRepo;
import com.example.RentCarSpb.util.JwtTokenUtil;

import java.util.Optional;

@Service // 標記該類別為 Spring 服務類別，以便自動掃描和注入
public class EmployeeIMPL implements EmployeeService { 
    
    @Autowired
    private EmployeeRepo employeeRepo; // 自動注入 EmployeeRepo，與資料庫進行交互

    @Autowired
    private PasswordEncoder passwordEncode; // 自動注入 PasswordEncoder，用於密碼編碼和解碼

    @Autowired
    private JwtTokenUtil jwtTokenUtil; // 自動注入 JwtTokenUtil，用於生成和驗證 JWT

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        // 創建 Employee 實體，並對密碼進行編碼
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncode.encode(employeeDTO.getPassword())
        );
        // 保存員工資料到資料庫
        employeeRepo.save(employee);
        return employee.getEmployeename(); // 返回員工姓名
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        // 根據 email 查找員工
        Optional<Employee> optionalEmployee = employeeRepo.findByEmail(loginDTO.getEmail());
        
        if (optionalEmployee.isPresent()) {
            Employee employee1 = optionalEmployee.get(); // 取出員工實體
            String password = loginDTO.getPassword(); // 獲取輸入的密碼
            String encodedPassword = employee1.getPassword(); // 獲取資料庫中的編碼密碼
            Boolean isPwdRight = passwordEncode.matches(password, encodedPassword); // 檢查密碼是否匹配
            
            if (isPwdRight) {
                // 密碼匹配，生成 JWT token
                String token = jwtTokenUtil.generateToken(employee1);

                // 創建回應 DTO，並返回成功的 LoginResponse
                EmployeeResponseWebDTO responseDTO = new EmployeeResponseWebDTO(
                    employee1.getEmployeeid(),
                    employee1.getEmployeename(),
                    employee1.getEmail()
                );
                return new LoginResponse("Login Success", true, responseDTO, token);
            } else {
                // 密碼不匹配，返回失敗的 LoginResponse
                return new LoginResponse("Login Not Match", false);
            }
        } else {
            // email 不存在，返回失敗的 LoginResponse
            return new LoginResponse("Email not exists", false);
        }
    }

    @Override
    public boolean checkEmailExists(String email) {
        // 檢查電子郵件是否存在於資料庫中
        return employeeRepo.existsByEmail(email);
    }
}
