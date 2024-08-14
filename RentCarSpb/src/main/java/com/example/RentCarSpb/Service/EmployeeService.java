package com.example.RentCarSpb.Service;

import com.example.RentCarSpb.Dto.EmployeeDTO;
import com.example.RentCarSpb.Dto.LoginDTO;
import com.example.RentCarSpb.response.LoginResponse;

// 定義 EmployeeService 介面，提供員工相關的業務邏輯操作
public interface EmployeeService {
    
    // 定義一個方法來添加員工，接收 EmployeeDTO 物件並返回員工的姓名
    String addEmployee(EmployeeDTO employeeDTO);

    // 定義一個方法來處理員工登錄，接收 LoginDTO 物件並返回 LoginResponse 物件
    LoginResponse loginEmployee(LoginDTO loginDTO);
}

