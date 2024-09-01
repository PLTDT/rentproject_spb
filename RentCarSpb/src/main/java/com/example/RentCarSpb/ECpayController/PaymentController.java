package com.example.RentCarSpb.ECpayController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.ResponseBody;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.exception.EcpayException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
public class PaymentController {

    private final AllInOne allInOne;

    // 保持初始化不變
    public PaymentController() {
        allInOne = new AllInOne(""); // 確保這裡設置了正確的商戶 ID 和密鑰
    }

    @GetMapping(value = "/payment", produces = "text/html")
    @ResponseBody
    public String processPayment(@RequestParam String formid, @RequestParam String total) {
        AioCheckOutALL obj = new AioCheckOutALL();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String currentDateTime = LocalDateTime.now().format(formatter);

        String uuid = (formid + (UUID.randomUUID().toString())).replace("-", "");
        String tradeNo = uuid.length() > 20 ? uuid.substring(0, 20) : uuid;

        obj.setMerchantTradeNo(tradeNo);
        obj.setMerchantTradeDate(currentDateTime);
        obj.setTotalAmount(total);
        obj.setTradeDesc("GoRent Payment");
        obj.setItemName("GoRent 租車服務");
        obj.setReturnURL("http://localhost:3000/"); // 確保這裡是正確的回調 URL
        obj.setOrderResultURL("http://localhost:3000/paymentResult?MerchantTradeNo=" + tradeNo + "&MerchantTradeDate=" + currentDateTime + "&formid=" + formid); // 包含 formid

        String form = "";
        try {
            form = allInOne.aioCheckOut(obj, null);
        } catch (EcpayException e) {
            e.printStackTrace();
            return "<html><body><h1>付款錯誤</h1><p>付款處理失敗，請稍後再試。</p></body></html>";
        }
        return form;
    }

}
