package com.example.RentCarSpb.ECpayController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.exception.EcpayException;

@Controller
public class PaymentController {

    private final AllInOne allInOne;

    public PaymentController() {
        allInOne = new AllInOne("");
    }

    @GetMapping("/payment")
    @ResponseBody
    public String processPayment(@RequestParam(name = "tno", required = false) String tno,
                                @RequestParam(name = "total", required = false) String total) {
        AioCheckOutALL obj = new AioCheckOutALL();

        // Static values for now, these should be dynamically set based on your business logic
        obj.setMerchantTradeNo("a2233223228");
        obj.setMerchantTradeDate("2024/07/23 09:55:00");
        obj.setTotalAmount("125487");
        obj.setTradeDesc("Test Payment lala");
        obj.setItemName("Pocheng's Jsp online course");
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
}
