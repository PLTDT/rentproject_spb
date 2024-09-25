package com.example.RentCarSpb.MemberInfoController;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentCarSpb.Entity.Employee;
import com.example.RentCarSpb.Service.MemberInfoService;

@RestController
@CrossOrigin  //(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("api/v1/memberinfo")
public class MemberInfoController {
    
    @Autowired
    private MemberInfoService memberInfoService;

    @GetMapping(path = "/getmemberinfo")
    public ResponseEntity<Optional<Employee>> getallMemberInfo(@RequestParam String email) {
        Optional<Employee> memberinfo = memberInfoService.getMemberInfoByEmail(email);

        if (!memberinfo.isEmpty()) {
            return ResponseEntity.ok(memberinfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
