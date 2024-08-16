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

@Service
public class EmployeeIMPL implements EmployeeService { 
    
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncode;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncode.encode(employeeDTO.getPassword())
        );
        employeeRepo.save(employee);
        return employee.getEmployeename();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        Optional<Employee> optionalEmployee = employeeRepo.findByEmail(loginDTO.getEmail());
        
        if (optionalEmployee.isPresent()) {
            Employee employee1 = optionalEmployee.get();
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncode.matches(password, encodedPassword);
            
            if (isPwdRight) {
                String token = jwtTokenUtil.generateToken(employee1);

                EmployeeResponseWebDTO responseDTO = new EmployeeResponseWebDTO(
                    employee1.getEmployeeid(),
                    employee1.getEmployeename(),
                    employee1.getEmail()
                );
                return new LoginResponse("Login Success", true, responseDTO, token);
            } else {
                return new LoginResponse("Login Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }

    @Override
    public boolean checkEmailExists(String email) {
        return employeeRepo.existsByEmail(email);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
