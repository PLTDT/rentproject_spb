package com.example.RentCarSpb.Repo;

// 引入必要的 JPA 類和註解
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.RentCarSpb.Entity.Employee;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

// 啟用 JPA 存儲庫配置，通常在應用啟動類中使用，而非在每個 Repository 中
@EnableJpaRepositories
// 標註這個介面為 Spring 的 Repository 組件，讓 Spring 自動識別並創建實例
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    
    // 根據電子郵件和密碼查找員工，返回一個 Optional 以處理可能的空值
    Optional<Employee> findByEmailAndPassword(String email, String password);

    // 根據電子郵件查找員工，返回一個 Employee 物件
    Employee findByEmail(String email);
}

