package com.example.RentCarSpb.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/daniel5")
@RestController
public class Backregister {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // 註冊 API
    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public String registerEmployee(@RequestBody BackregisterConstructor employee) {
        String sql = "INSERT INTO backemployee (employee_name, employee_password, employee_position, employee_dep) " +
                     "VALUES (:employee_name, :employee_password, :employee_position, :employee_dep)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("employee_name", employee.getEmployeeName());
        params.addValue("employee_password", employee.getEmployeePassword());
        params.addValue("employee_position", employee.getEmployeePosition());
        params.addValue("employee_dep", employee.getEmployeeDep());

        int rowsAffected = namedParameterJdbcTemplate.update(sql, params);

        if (rowsAffected > 0) {
            return "註冊成功";
        } else {
            return "註冊失敗";
        }
    }

    // 新增登入 API
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public String loginEmployee(@RequestBody BackLoginRequest loginRequest) {
        String sql = "SELECT COUNT(*) FROM backemployee WHERE employee_name = :employee_name AND employee_password = :employee_password";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("employee_name", loginRequest.getUsername());
        params.addValue("employee_password", loginRequest.getPassword());

        int count = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);

        if (count > 0) {
            return "登入成功";
        } else {
            return "登入失敗，帳號或密碼錯誤";
        }
    }
}
