package com.pitufifantasticos.apitenis.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.pitufifantasticos.apitenis.entity.Employee;
import com.pitufifantasticos.apitenis.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
	public ResponseEntity<?> create (@RequestBody Employee employee){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
	}

    @GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		
		Optional<Employee> oEmployee = employeeService.findById(id);
		
		if(!oEmployee.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(oEmployee);
		}
	}

    public ResponseEntity<?> update (@RequestBody Employee employeeDetails, @PathVariable Long id){
		
		Optional<Employee> employee = employeeService.findById(id);
		
		if(!employee.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		employee.get().setNombre(employeeDetails.getNombre());
		employee.get().setUsername(employeeDetails.getUsername());
        employee.get().setPassword(employeeDetails.getPassword());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee.get()));
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		if(!employeeService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		employeeService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

    @GetMapping
	public List<Employee> readAll(){
		
		List<Employee> employee = StreamSupport.stream(employeeService.fundAll().spliterator(),false).collect(Collectors.toList());
		
		return employee;
	}
}
