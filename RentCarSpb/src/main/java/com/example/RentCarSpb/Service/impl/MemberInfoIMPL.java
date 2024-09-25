package com.example.RentCarSpb.Service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentCarSpb.Entity.Employee;
import com.example.RentCarSpb.Repo.MemberInfoRepo;
import com.example.RentCarSpb.Service.MemberInfoService;


@Service
public class MemberInfoIMPL implements MemberInfoService {
    @Autowired
    private MemberInfoRepo memberInfoRepo;

    @Override
    public List<Employee> findAll() {
        List<Employee> rentform = memberInfoRepo.findAll();
        return rentform;
    }


    @Override
    public Optional<Employee> getMemberInfoByEmail(String email) {
        return memberInfoRepo.findByEmail(email);
    }

}
