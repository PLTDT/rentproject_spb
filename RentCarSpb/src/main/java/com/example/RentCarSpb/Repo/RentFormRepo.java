package com.example.RentCarSpb.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.RentCarSpb.Entity.RentFormdb;

@EnableJpaRepositories

@Repository
public interface RentFormRepo extends JpaRepository<RentFormdb, Integer> {

    

    
}
