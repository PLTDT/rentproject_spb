package com.example.RentCarSpb.RentFormController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.RentCarSpb.Dto.RentFormDTO;
import com.example.RentCarSpb.Service.RentFormService;
import com.example.RentCarSpb.Entity.RentFormdb;

@RestController
@CrossOrigin  //(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("api/v1/rentform")
public class RentFormController {
    
    @Autowired
    private RentFormService rentFormService;

    @PostMapping(path = "/rentcar")
    public String saveRentForm(@RequestBody RentFormDTO rentFormDTO) {
        String id = rentFormService.addRentForm(rentFormDTO);
        return id;
    }
    
    @GetMapping(path = "/getrentcar")
    public ResponseEntity<List <RentFormdb>> getallRentForm(@RequestParam String email) {
        List<RentFormdb> rentForm = rentFormService.getRentFormByEmail(email);

        if (!rentForm.isEmpty()) {
            return ResponseEntity.ok(rentForm);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
