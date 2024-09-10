package com.example.RentCarSpb.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/daniel")
@RestController
public class Backpay {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @RequestMapping(path = "/getallorders", produces = "application/json", method = RequestMethod.GET)
    public List<BackpayConstructor> getAllOrders() {
        // 定義SQL查詢語句，選擇pay表中的所有數據
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

    @RequestMapping(path = "/deleteorder/{form_id}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable("form_id") String formId) {
        // 定義SQL刪除語句，根據form_id刪除對應的支付記錄
        String sql = "DELETE FROM pay WHERE form_id = :form_id";

        // 使用MapSqlParameterSource將參數與SQL語句中的命名參數關聯
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("form_id", formId);

        // 執行刪除操作
        int rowsAffected = namedParameterJdbcTemplate.update(sql, parameters);

        // 輸出受影響的行數（即刪除的記錄數量）
        System.out.println("刪除了 " + rowsAffected + " 筆支付記錄");
    }
}
