package com.example.RentCarSpb.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RentCarSpb.Service.EmployeeService;
import com.example.RentCarSpb.Dto.EmployeeDTO;
import com.example.RentCarSpb.Entity.Employee;
import com.example.RentCarSpb.Repo.EmployeeRepo;

@Service
public class EmployeeIMPL implements EmployeeService { 
    
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncode;

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
}
