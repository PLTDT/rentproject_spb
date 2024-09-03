package com.example.RentCarSpb.PayController;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /*@PostMapping(path="/deletedata")
    public ResponseEntity<Optional<Paydb>> deletePaydata(@RequestParam String formid) {
    Optional<Paydb> deletedPaydata = payService.deletePaydata(formid);
        if (deletedPaydata.isPresent()) {
            return ResponseEntity.ok(deletedPaydata);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }*/

    @PostMapping("/updatedata")
    public ResponseEntity<?> updatePayData(@RequestBody PayDTO request) {
    Optional<Paydb> updatedPaydb = payService.updatePaydata(request.getFormid(), request.getPaydate(), request.getPaymethod(), request.getPaystatus());
    
    if (updatedPaydb.isPresent()) {
        return ResponseEntity.ok(updatedPaydb.get());
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paydb record not found for the given formid");
    }
}

}