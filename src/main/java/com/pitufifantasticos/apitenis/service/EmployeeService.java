package com.pitufifantasticos.apitenis.service;

import java.util.Optional;

import com.pitufifantasticos.apitenis.entity.Employee;

import org.springframework.data.domain.*;

public interface EmployeeService {
    
    public Iterable<Employee> fundAll();
	
	public Page<Employee> findAll(Pageable pageable);
	
	public Optional<Employee> findById(Long id);
	
	public Employee save(Employee employee);
	
	public void deleteById(Long id);
}
