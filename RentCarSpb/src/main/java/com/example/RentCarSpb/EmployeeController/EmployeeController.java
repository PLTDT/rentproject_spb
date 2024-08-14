package com.example.RentCarSpb.EmployeeController;

// 引入必要的 Spring 和應用程序類
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

// 標註這個類為 REST 控制器，並指定處理 HTTP 請求
@RestController
// 允許來自不同來源的請求
@CrossOrigin
// 指定這個控制器的請求路徑前綴
@RequestMapping("api/v1/employee")
public class EmployeeController {
    
    // 注入 EmployeeService 服務，用於處理業務邏輯
    @Autowired
    private EmployeeService employeeService;

    // 處理 POST 請求，路徑為 /registeraction，用於註冊新員工
    @PostMapping(path = "/registeraction")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        // 調用服務層的方法來添加員工，並返回生成的員工 ID
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    // 處理 POST 請求，路徑為 /loginaction，用於用戶登錄
    @PostMapping(path = "/loginaction")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
        // 調用服務層的方法來進行登錄，並返回登錄響應
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}


