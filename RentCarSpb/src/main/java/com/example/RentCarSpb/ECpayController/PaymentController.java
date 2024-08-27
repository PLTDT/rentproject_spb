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

    public PaymentController() {
        allInOne = new AllInOne(""); // 初始化 AllInOne 對象
    }

    @GetMapping(value = "/payment", produces = "text/html")
    @ResponseBody
    public String processPayment(@RequestParam String formid, @RequestParam String total) {
        AioCheckOutALL obj = new AioCheckOutALL();

        // 設置當前日期和時間
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String currentDateTime = LocalDateTime.now().format(formatter);

        // 生成唯一的訂單編號
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String tradeNo = uuid.length() > 20 ? uuid.substring(0, 20) : uuid;

        obj.setMerchantTradeNo(tradeNo);
        obj.setMerchantTradeDate(currentDateTime);
        obj.setTotalAmount(total);
        obj.setTradeDesc("GoRent Payment");
        obj.setItemName("GoRent 租車服務");
        obj.setReturnURL("http://localhost:3000/");
        obj.setOrderResultURL("http://localhost:3000/paymentResult");

        String form = "";
        try {
            form = allInOne.aioCheckOut(obj, null);
        } catch (EcpayException e) {
            e.printStackTrace();
        }
        return form;
    }
}
