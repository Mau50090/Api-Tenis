package com.pitufifantasticos.apitenis.service;

import com.pitufifantasticos.apitenis.entity.Tennis;
import java.util.Optional;
import org.springframework.data.domain.*;

public interface TennisService {
    
    public Iterable<Tennis> fundAll();
	
	public Page<Tennis> findAll(Pageable pageable);
	
	public Optional<Tennis> findById(Long id);
	
	public Tennis save(Tennis user);
	
	public void deleteById(Long id);
}
