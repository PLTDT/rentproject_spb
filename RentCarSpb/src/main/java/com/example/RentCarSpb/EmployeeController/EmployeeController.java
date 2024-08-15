package com.example.RentCarSpb.EmployeeController;

// 引入必要的 Spring 和應用程序類
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentCarSpb.Dto.EmployeeDTO;
import com.example.RentCarSpb.Dto.LoginDTO;
import com.example.RentCarSpb.Service.EmployeeService;
import com.example.RentCarSpb.response.LoginResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin // 允許來自不同來源的請求，通常用於處理跨域請求
@RequestMapping("api/v1/employee") // 設定該控制器的基礎 URL 路徑
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; // 自動注入 EmployeeService 服務

    // 註冊新員工
    @PostMapping(path = "/registeraction")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        // 使用 EmployeeService 服務來添加員工，並返回員工的 ID
        String id = employeeService.addEmployee(employeeDTO);
        return id; // 返回新增員工的 ID
    }

    // 員工登入
    @PostMapping(path = "/loginaction")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
        // 使用 EmployeeService 服務來處理登入邏輯，並返回登入結果
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse); // 返回登入結果
    }

    // 檢查 email 是否已存在
    @GetMapping(path = "/check-email")
    public ResponseEntity<Map<String, Boolean>> checkEmailExists(@RequestParam String email) {
        // 使用 EmployeeService 服務來檢查 email 是否存在
        boolean exists = employeeService.checkEmailExists(email);
        // 構建返回的 Map 以告知 email 是否存在
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response); // 返回檢查結果
    }
}
