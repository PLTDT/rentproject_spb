package com.example.RentCarSpb.Repo;

import java.util.List;

import  java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.RentCarSpb.Entity.Employee;

// 標註這個介面為 Spring 的 Repository 組件，讓 Spring 自動識別並創建實例
@Repository
public interface MemberInfoRepo extends JpaRepository<Employee, Integer> {

    // 根據電子郵件和密碼查找員工，返回一個 Optional 以處理可能的空值
    List<Employee> findByEmailAndPassword(String email, String password);

    // 根據電子郵件查找員工，返回一個 Optional 以處理可能的空值
    Optional<Employee> findByEmail(String email);
    
    // 根據電子郵件檢查是否存在
    boolean existsByEmail(String email);
}
