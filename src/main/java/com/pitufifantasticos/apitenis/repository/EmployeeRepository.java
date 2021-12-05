package com.pitufifantasticos.apitenis.repository;
import com.pitufifantasticos.apitenis.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
