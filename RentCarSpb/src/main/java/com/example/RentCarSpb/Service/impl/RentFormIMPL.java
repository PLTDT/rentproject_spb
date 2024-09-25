package com.example.RentCarSpb.Service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentCarSpb.Dto.RentFormDTO;
import com.example.RentCarSpb.Entity.Paydb;
import com.example.RentCarSpb.Entity.RentFormdb;
import com.example.RentCarSpb.Repo.PayRepo;
import com.example.RentCarSpb.Repo.RentFormRepo;
import com.example.RentCarSpb.Service.RentFormService;


@Service
public class RentFormIMPL implements RentFormService {

    @Autowired
    private  RentFormRepo rentformRepo;

    @Autowired
    private PayRepo payRepo;
    @Override
    public String addRentForm(RentFormDTO rentFormDTO) {
        
        boolean isdeleted = false;

        String paystatus ="未付款";
        
        RentFormdb rentformdb = new RentFormdb(
            rentFormDTO.getFormid(),
            rentFormDTO.getRentplace(),
            rentFormDTO.getReturnplace(),
            rentFormDTO.getRentdate(),
            rentFormDTO.getReturndate(),
            rentFormDTO.getCarid(),
            rentFormDTO.getCarbrand(),
            rentFormDTO.getPassenger(),
            paystatus,
            rentFormDTO.getCustomername(),
            rentFormDTO.getCustomeremail(),
            isdeleted
        );

        rentformRepo.save(rentformdb);
        return rentformdb.getRentplace();
    }
    @Override
    public List<RentFormdb> findAll() {
        List<RentFormdb> rentform = rentformRepo.findAll();
        return rentform;
    }


    @Override
    public List<RentFormdb> getRentFormByEmail(String customeremail) {
        return rentformRepo.findByCustomeremail(customeremail);
    }

    @Override
    public Optional<RentFormdb> deletePaydata(String formid) {
        // Fetch the RentFormdb record using the formid
        RentFormdb rentFormdb = rentformRepo.findByFormid(formid)
                                            .orElseThrow(() -> new IllegalArgumentException("Invalid form ID: " + formid));

        // Fetch the Paydb record using the rentFormdb
        Optional<Paydb> optionalPaydb = payRepo.findByFormid(rentFormdb);

        // Mark RentFormdb as deleted
        rentFormdb.setIsdeleted(true);
        rentformRepo.save(rentFormdb);

        // If Paydb exists, mark it as deleted
        if (optionalPaydb.isPresent()) {
            Paydb paydb = optionalPaydb.get();
            paydb.setIsdeleted(true);
            payRepo.save(paydb);
        }
        
        return Optional.of(rentFormdb);
    }

    
}
