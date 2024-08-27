package com.example.RentCarSpb.ECpayController;

//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.exception.EcpayException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/pay")
public class PaymentController {

    private final AllInOne allInOne;

    public PaymentController() {
        allInOne = new AllInOne("");
    }

    @PostMapping("/payment")
    public String processPayment(@RequestBody PaymentRequest paymentRequest) {
        AioCheckOutALL obj = new AioCheckOutALL();
                                    

        // Set current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String currentDateTime = LocalDateTime.now().format(formatter);
        //String tradeNo=paymentRequest.getFormid().replace("-", "");
        // Static values for now, these should be dynamically set based on your business logic

         // 生成唯一的订单编号
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String tradeNo = uuid.length() > 20 ? uuid.substring(0, 20) : uuid;
        
        System.out.println(tradeNo);

        obj.setMerchantTradeNo(tradeNo);
        obj.setMerchantTradeDate(currentDateTime);
        obj.setTotalAmount(paymentRequest.getTotal());
        obj.setTradeDesc("GoRent Payment");
        obj.setItemName("GoRent 租車服務");
        obj.setReturnURL("http://localhost:8080/");
        obj.setOrderResultURL("http://localhost:8080/paymentResult");

        String form = "";
        try {
            form = allInOne.aioCheckOut(obj, null);
        } catch (EcpayException e) {
            e.printStackTrace();
        }
        return form;
    }
    // 將 POST 請求的 body 映射到此類
    public static class PaymentRequest {
        private String formid;
        private String total;

        public String getFormid() {
            return formid;
        }

        public void setFormid(String formid) {
            this.formid = formid;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }
}
