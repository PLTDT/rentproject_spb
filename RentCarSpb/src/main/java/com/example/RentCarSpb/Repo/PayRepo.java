package com.example.RentCarSpb.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.RentCarSpb.Entity.Paydb;
import com.example.RentCarSpb.Entity.RentFormdb;

@EnableJpaRepositories

@Repository
public interface PayRepo extends JpaRepository<Paydb, Integer> {

    //Optional<Paydb> findByFormId(String formid);

    Optional<Paydb> findByFormid(RentFormdb formid);

}
