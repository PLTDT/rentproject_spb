package com.example.RentCarSpb.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentCarSpb.Dto.RentFormDTO;
import com.example.RentCarSpb.Entity.RentFormdb;
import com.example.RentCarSpb.Repo.RentFormRepo;
import com.example.RentCarSpb.Service.RentFormService;

@Service
public class RentFormIMPL implements RentFormService {
    @Autowired
    private  RentFormRepo rentformRepo;
    @Override
    public String addRentForm(RentFormDTO rentFormDTO) {
        
        RentFormdb rentformdb = new RentFormdb(
            rentFormDTO.getFormid(),
            rentFormDTO.getRentplace(),
            rentFormDTO.getReturnplace(),
            rentFormDTO.getRentdate(),
            rentFormDTO.getReturndate(),
            rentFormDTO.getCarid(),
            rentFormDTO.getCarbrand(),
            rentFormDTO.getPassenger(),
            rentFormDTO.getCouponcode()
        );

        rentformRepo.save(rentformdb);
        return rentformdb.getRentplace();
    }
}
