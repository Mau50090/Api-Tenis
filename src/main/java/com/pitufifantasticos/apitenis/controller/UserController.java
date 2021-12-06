package com.pitufifantasticos.apitenis.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.pitufifantasticos.apitenis.entity.User;
import com.pitufifantasticos.apitenis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody User user){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		
		Optional<User> oUser = userService.findById(id);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(oUser);
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable Long id){
		
		Optional<User> user = userService.findById(id);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		user.get().setNombre(userDetails.getNombre());
		user.get().setEmail(userDetails.getEmail());
		user.get().setUsername(userDetails.getUsername());
		user.get().setFactura(userDetails.getFactura());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		if(!userService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		userService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<User> readAll(){
		
		List<User> users = StreamSupport.stream(userService.fundAll().spliterator(),false).collect(Collectors.toList());
		
		return users;
	}
}
