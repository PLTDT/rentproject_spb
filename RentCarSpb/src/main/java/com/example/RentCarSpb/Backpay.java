package com.example.RentCarSpb;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/daniel")
@RestController
public class Backpay {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @RequestMapping(path = "/getallorders", produces = "application/json")
    public List<BackpayConstructor> getAllOrders() {
        // 定義SQL查詢語句，選擇rentform表中的所有數據
        String sql = "SELECT * FROM pay";
        
        // 定義RowMapper，將查詢結果的每一行映射到BackpayConstructor對象
        RowMapper<BackpayConstructor> rowMapper = new BeanPropertyRowMapper<>(BackpayConstructor.class);
        
        // 執行SQL查詢，並將結果映射為List<BackpayConstructor>
        List<BackpayConstructor> orders = namedParameterJdbcTemplate.query(sql, rowMapper);

        // 打印輸出每一個訂單對象的內容，以檢查訂單金額是否正確映射
        orders.forEach(order -> System.out.println(order.toString()));

        // 返回包含所有訂單的列表，作為API的響應數據
        return orders;
    }
}


