package com.example.RentCarSpb.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.RentCarSpb.Entity.Employee;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    
}
