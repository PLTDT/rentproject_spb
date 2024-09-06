package com.example.RentCarSpb.ECpayController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.sql.Date;

import com.example.RentCarSpb.Service.PayService;
import com.example.RentCarSpb.Entity.RentFormdb;

@RestController
public class PaymentResultController {

    @Autowired
    private PayService payService;

    @GetMapping("/paymentResult")
    public ResponseEntity<String> handleGetRequest(@RequestParam Map<String, String> params) {
        String merchantTradeNo = params.get("MerchantTradeNo");
        String merchantTradeDateString = params.get("MerchantTradeDate");
        String formidString = params.get("formid");
        String paymethod = "綠界金流";
        String paystatus = "已付款";

        System.out.println("Received MerchantTradeNo (GET): " + merchantTradeNo);
        System.out.println("Received MerchantTradeDate (GET): " + merchantTradeDateString);
        System.out.println("Received formid (GET): " + formidString);

        if (merchantTradeNo == null || merchantTradeDateString == null || formidString == null) {
            return ResponseEntity.badRequest().body("<html><body><h1>Error</h1><p>Missing MerchantTradeNo, MerchantTradeDate, or formid in query parameters</p></body></html>");
        }

        // Convert merchantTradeDateString to java.sql.Date
        java.sql.Date merchantTradeDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date utilDate = formatter.parse(merchantTradeDateString);
            merchantTradeDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body("<html><body><h1>Error</h1><p>Invalid date format for MerchantTradeDate. Expected format: yyyy/MM/dd HH:mm:ss</p></body></html>");
        }

        RentFormdb formid = new RentFormdb();
        formid.setFormid(formidString);

        try {
            payService.updatePaydata(formid, merchantTradeDate, paymethod, paystatus);

            // Return HTML content with a redirect script
            String htmlResponse = "<html><body>" +
                    "<script>window.location.href = 'https://tongbro.ddns.net:443/paymentResult?MerchantTradeNo=" + merchantTradeNo + "&MerchantTradeDate=" + merchantTradeDateString + "&formid=" + formidString + "';</script>" +
                    "</body></html>";
            return ResponseEntity.ok().body(htmlResponse);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("<html><body><h1>Error</h1><p>Error updating payment data.</p></body></html>");
        }
    }

    @PostMapping("/paymentResult")
    public ResponseEntity<String> handlePostRequest(@RequestParam Map<String, String> params) {
        String merchantTradeNo = params.get("MerchantTradeNo");
        String merchantTradeDateString = params.get("MerchantTradeDate");
        String formidString = params.get("formid");
        String paymethod = "綠界金流";
        String paystatus = "已付款";

        System.out.println("Received MerchantTradeNo (POST): " + merchantTradeNo);
        System.out.println("Received MerchantTradeDate (POST): " + merchantTradeDateString);
        System.out.println("Received formid (POST): " + formidString);

        if (merchantTradeNo == null || merchantTradeDateString == null || formidString == null) {
            return ResponseEntity.badRequest().body("<html><body><h1>Error</h1><p>Missing MerchantTradeNo, MerchantTradeDate, or formid in request parameters</p></body></html>");
        }

        // Convert merchantTradeDateString to java.sql.Date
        java.sql.Date merchantTradeDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date utilDate = formatter.parse(merchantTradeDateString);
            merchantTradeDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body("<html><body><h1>Error</h1><p>Invalid date format for MerchantTradeDate. Expected format: yyyy/MM/dd HH:mm:ss</p></body></html>");
        }

        RentFormdb formid = new RentFormdb();
        formid.setFormid(formidString);

        try {
            payService.updatePaydata(formid, merchantTradeDate, paymethod, paystatus);

            // Return HTML content with a redirect script
            String htmlResponse = "<html><body>" +
                    "<script>window.location.href = 'https://tongbro.ddns.net:443/paymentResult?MerchantTradeNo=" + merchantTradeNo + "&MerchantTradeDate=" + merchantTradeDateString + "&formid=" + formidString + "';</script>" +
                    "</body></html>";
            return ResponseEntity.ok().body(htmlResponse);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("<html><body><h1>Error</h1><p>Error updating payment data.</p></body></html>");
        }
    }
}
