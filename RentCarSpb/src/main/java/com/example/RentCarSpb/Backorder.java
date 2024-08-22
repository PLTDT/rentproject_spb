package com.example.RentCarSpb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // 自動注入依賴的註解
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate; // 用於執行帶命名參數的SQL查詢
import org.springframework.jdbc.core.RowMapper; // 用於將查詢結果映射到Java對象的接口
import org.springframework.jdbc.core.BeanPropertyRowMapper; // 自動將資料庫列映射到Java對象屬性的類
import org.springframework.web.bind.annotation.CrossOrigin; // 允許跨域請求的註解
import org.springframework.web.bind.annotation.RequestMapping; // 映射HTTP請求路徑的註解
import org.springframework.web.bind.annotation.RestController; // 聲明一個RESTful控制器的註解

@CrossOrigin(origins = "http://localhost:3000") // 允許從http://localhost:3000（通常是React開發伺服器）發起的跨域請求
@RequestMapping("/daniel") // 將控制器映射到/daniel路徑下
@RestController // 將該類聲明為RESTful控制器，處理HTTP請求並返回JSON等響應
public class Backorder {

    @Autowired // 自動注入NamedParameterJdbcTemplate對象，用於執行SQL查詢
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @RequestMapping(path = "/getallorders", produces = "application/json") // 將HTTP GET請求映射到/getallorders路徑，並指定返回JSON數據
    public List<Test1> getAllOrders() {
        // 定義SQL查詢語句，選擇test1表中的所有數據
        String sql = "SELECT * FROM rentform";
        
        // 定義RowMapper，將查詢結果的每一行映射到Test1對象
        RowMapper<Test1> rowMapper = new BeanPropertyRowMapper<>(Test1.class);
        
        // 執行SQL查詢，並將結果映射為List<Test1>
        List<Test1> orders = namedParameterJdbcTemplate.query(sql, rowMapper);

        // 打印輸出每一個訂單對象的內容，以檢查訂單金額是否正確映射
        orders.forEach(order -> System.out.println(order.toString()));

        // 返回包含所有訂單的列表，作為API的響應數據
        return orders;
    }
}
