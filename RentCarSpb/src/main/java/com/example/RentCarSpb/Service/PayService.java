package com.example.RentCarSpb.Service;


import java.util.Optional;

import com.example.RentCarSpb.Dto.PayDTO;

import com.example.RentCarSpb.Entity.Paydb;
//import com.example.RentCarSpb.Entity.RentFormdb;


public interface PayService {
    
    String addPaydata(PayDTO PayDTO); 

    Optional<Paydb> getPaydata(String formid);

}
