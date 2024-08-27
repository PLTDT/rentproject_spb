package com.example.RentCarSpb.PayController;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentCarSpb.Dto.PayDTO;
import com.example.RentCarSpb.Entity.Paydb;
//import com.example.RentCarSpb.Entity.RentFormdb;
import com.example.RentCarSpb.Service.PayService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/pay")
public class PayController {
    
    @Autowired
    private PayService payService;

    @PostMapping(path = "/paydata")
    public String savePaydata(@RequestBody PayDTO PayDTO) {
        String id = payService.addPaydata(PayDTO);
        return id;
    }

    @GetMapping(path="/getpaydata")
    public Optional<Paydb> getPaydata(@RequestParam String formid) {
        Optional<Paydb> paydata = payService.getPaydata(formid);
        return paydata;
    }

}
