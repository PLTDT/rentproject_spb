package com.example.RentCarSpb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.RentCarSpb.Entity.Employee;

@Service
public interface MemberInfoService {


    List<Employee> findAll();

    Optional<Employee> getMemberInfoByEmail(String email);

}
