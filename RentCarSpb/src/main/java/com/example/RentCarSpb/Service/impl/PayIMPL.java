package com.example.RentCarSpb.Service.impl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentCarSpb.Dto.PayDTO;
import com.example.RentCarSpb.Entity.Paydb;
import com.example.RentCarSpb.Entity.RentFormdb;
import com.example.RentCarSpb.Repo.PayRepo;
import com.example.RentCarSpb.Repo.RentFormRepo;
import com.example.RentCarSpb.Service.PayService;

@Service
public class PayIMPL implements PayService {

    @Autowired
    private PayRepo payRepo;

    @Autowired
    private RentFormRepo rentFormRepo;

    @Override
    public String addPaydata(PayDTO payDTO) {

        // Find existing RentFormdb by formid
        RentFormdb existingForm = findRentFormdbById(payDTO.getFormid().getFormid());

        // Check if a Paydb entry already exists with this RentFormdb
        Optional<Paydb> existingPaydb = payRepo.findByFormid(existingForm);

        if (existingPaydb.isPresent()) {
            // If an entry already exists, return its ID
            return existingPaydb.get().getPayid().toString();
        }
        
        // Handling null values for optional fields
        Date paydate = (payDTO.getPaydate() != null) ? payDTO.getPaydate() : new Date(System.currentTimeMillis());
        int totaldays = (payDTO.getTotaldays() != null) 
                        ? payDTO.getTotaldays() 
                        : calculateTotalDays(payDTO.getRentdate(), payDTO.getReturndate());
        String paymethod = (payDTO.getPaymethod() != null) ? payDTO.getPaymethod() : "unknown";
        String paystatus = (payDTO.getPaystatus() != null) ? payDTO.getPaystatus() : "pending";

        int carprice = getCarPrice(payDTO.getCarbrand());

        int total = (payDTO.getTotal() != null) ? payDTO.getTotal() : totaldays * carprice;

        // Create a new Paydb entity and associate it with the RentFormdb
        Paydb paydb = new Paydb(
            payDTO.getPayid(),
            existingForm,
            payDTO.getCustomername(),
            payDTO.getCustomeremail(),
            payDTO.getCarbrand(),
            payDTO.getRentdate(),
            payDTO.getReturndate(),
            totaldays,
            paydate,
            total,
            paymethod,
            paystatus
        );

        // Save the new Paydb entity to the database
        payRepo.save(paydb);

        // Return the ID of the saved entity as a string
        return paydb.getPayid().toString();
    }

    // Method to find RentFormdb by formid
    private RentFormdb findRentFormdbById(String formid) {
        return rentFormRepo.findByFormid(formid).orElseThrow(() -> 
            new IllegalArgumentException("Invalid form ID: " + formid)
        );
    }

    // Method to calculate total days between rent date and return date
    private int calculateTotalDays(Date rentDate, Date returnDate) {
        long differenceInMillies = Math.abs(returnDate.getTime() - rentDate.getTime());
        return (int) (differenceInMillies / (1000 * 60 * 60 * 24));
    }

    // Method to get car price based on car brand
    private int getCarPrice(String carbrand) {
        switch (carbrand) {
            case "SUZUKI Vitara":
                return 3000;
            case "HONDA H FIT HEV 1.5":
                return 2500;
            case "TOYOTA NEW VIOS 1.5":
                return 2000;
            case "NISSAN LIVINA":
                return 1800;
            default:
                return 0; // Default or unknown car brand price
        }
    }


    @Override
    public Optional<Paydb> getPaydata(String formid) {
    RentFormdb rentFormdb = rentFormRepo.findByFormid(formid)
                                        .orElseThrow(() -> new IllegalArgumentException("Invalid form ID: " + formid));
    return payRepo.findByFormid(rentFormdb);
}
}
