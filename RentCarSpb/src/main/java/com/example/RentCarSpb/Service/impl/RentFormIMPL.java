package com.example.RentCarSpb.Service.impl;

import org.springframework.stereotype.Service;

import com.example.RentCarSpb.Dto.RentFormDTO;
import com.example.RentCarSpb.Entity.RentFormdb;
import com.example.RentCarSpb.Service.RentFormService;

@Service
public class RentFormIMPL implements RentFormService {

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

        return rentformdb.toString();
    }
}
