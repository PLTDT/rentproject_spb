package com.example.RentCarSpb.Service;

import java.util.List;

import com.example.RentCarSpb.Dto.RentFormDTO;
import com.example.RentCarSpb.Entity.RentFormdb;

public interface RentFormService {

    String addRentForm(RentFormDTO rentFormDTO);

    List<RentFormdb> findAll();
}
