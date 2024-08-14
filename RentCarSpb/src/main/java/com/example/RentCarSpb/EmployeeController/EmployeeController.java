package com.example.RentCarSpb.EmployeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentCarSpb.Dto.EmployeeDTO;
import com.example.RentCarSpb.Dto.LoginDTO;
import com.example.RentCarSpb.Service.EmployeeService;
import com.example.RentCarSpb.response.LoginResponse;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")

public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

    String id = employeeService.addEmployee(employeeDTO);
    return id;

    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }




}

