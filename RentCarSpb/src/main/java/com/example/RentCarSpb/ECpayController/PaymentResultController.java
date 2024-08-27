package com.example.RentCarSpb.ECpayController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PaymentResultController {

    @GetMapping("/paymentResult")
    public ResponseEntity<Map<String, String>> handleGetRequest(@RequestParam Map<String, String> params) {
        // 返回 JSON 格式的資料
        return ResponseEntity.ok(params);
    }

    @PostMapping("/paymentResult")
    public ResponseEntity<Map<String, String>> handlePostRequest(@RequestParam Map<String, String> params) {
        // 返回 JSON 格式的資料
        return ResponseEntity.ok(params);
    }
}
