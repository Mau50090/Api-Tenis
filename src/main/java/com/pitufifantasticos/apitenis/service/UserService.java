package com.pitufifantasticos.apitenis.service;

import java.util.Optional;

import com.pitufifantasticos.apitenis.entity.User;

import org.springframework.data.domain.*;


public interface UserService {

	public Iterable<User> fundAll();
	
	public Page<User> findAll(Pageable pageable);
	
	public Optional<User> findById(Long id);
	
	public User save(User user);
	
	public void deleteById(Long id);
}
