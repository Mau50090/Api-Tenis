package com.pitufifantasticos.apitenis.service;

import java.util.Optional;

import com.pitufifantasticos.apitenis.entity.Employee;
import com.pitufifantasticos.apitenis.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Employee> fundAll() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Employee> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return employeeRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findById(Long id) {
        // TODO Auto-generated method stub
        return employeeRepository.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        employeeRepository.deleteById(id);
    }
    
}
