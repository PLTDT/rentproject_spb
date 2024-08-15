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
import com.example.RentCarSpb.util.JwtTokenUtil;

@Service
public class EmployeeIMPL implements EmployeeService { 
    
    @Autowired
    private EmployeeRepo employeeRepo; // 注入 EmployeeRepo 用於操作員工數據庫

    @Autowired
    private PasswordEncoder passwordEncode; // 注入 PasswordEncoder 用於加密和比對密碼

    @Autowired
    private JwtTokenUtil jwtTokenUtil; // 注入 JwtTokenUtil 用於生成和驗證 JWT token

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        // 根據 EmployeeDTO 創建 Employee 實體，並加密密碼
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncode.encode(employeeDTO.getPassword())
        );
        // 保存員工到數據庫
        employeeRepo.save(employee);
        // 返回員工名稱
        return employee.getEmployeename();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        // 根據電子郵件查找員工
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        
        if (employee1 != null) {
            // 比對提供的密碼和存儲的加密密碼
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncode.matches(password, encodedPassword);
            
            if (isPwdRight) {
                // 密碼匹配，進一步查找是否存在該員工
                Optional<Employee> employee = employeeRepo.findByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                
                if (employee.isPresent()) {
                    // 登入成功，生成 JWT token
                    String token = jwtTokenUtil.generateToken(employee1);

                    // 創建 EmployeeDTO 並返回帶有 token 的 LoginResponse
                    EmployeeDTO employeeDTO = new EmployeeDTO(
                        employee1.getEmployeeid(),
                        employee1.getEmployeename(),
                        employee1.getEmail(),
                        null // 不返回密碼
                    );
                    return new LoginResponse("Login Success", true, employeeDTO, token);
                } else {
                    // 找不到該員工，登入失敗
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                // 密碼不匹配
                return new LoginResponse("Login Not Match", false);
            }
        } else {
            // 找不到該電子郵件的員工
            return new LoginResponse("Email not exists", false);
        }
    }
}

