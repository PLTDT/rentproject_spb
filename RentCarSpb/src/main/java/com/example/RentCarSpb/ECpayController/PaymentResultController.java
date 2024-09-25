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
    public ResponseEntity<String> handleGetRequest(@RequestParam Map<String, String> params) {
        String merchantTradeNo = params.get("MerchantTradeNo");
        System.out.println("Received MerchantTradeNo (GET): " + merchantTradeNo); // 輸出到控制台

        if (merchantTradeNo == null) {
            return ResponseEntity.badRequest().body("<html><body><h1>Error</h1><p>Missing MerchantTradeNo in query parameters</p></body></html>");
        }

        // 返回包含自動重定向的HTML內容
        String htmlResponse = "<html><body>" +
                "<script>window.location.href = 'http://localhost:3000/paymentResult?MerchantTradeNo=" + merchantTradeNo + "';</script>" +
                "</body></html>";
        return ResponseEntity.ok().body(htmlResponse);
    }

    @PostMapping("/paymentResult")
    public ResponseEntity<String> handlePostRequest(@RequestParam Map<String, String> params) {
        String merchantTradeNo = params.get("MerchantTradeNo");
        System.out.println("Received MerchantTradeNo (POST): " + merchantTradeNo); // 輸出到控制台

        if (merchantTradeNo == null) {
            return ResponseEntity.badRequest().body("<html><body><h1>Error</h1><p>Missing MerchantTradeNo in request parameters</p></body></html>");
        }

        // 返回包含自動重定向的HTML內容
        String htmlResponse = "<html><body>" +
                "<script>window.location.href = 'http://localhost:3000/paymentResult?MerchantTradeNo=" + merchantTradeNo + "';</script>" +
                "</body></html>";
        return ResponseEntity.ok().body(htmlResponse);
    }
}
