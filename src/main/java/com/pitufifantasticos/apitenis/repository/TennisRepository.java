package com.pitufifantasticos.apitenis.repository;

import com.pitufifantasticos.apitenis.entity.Tennis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisRepository extends JpaRepository<Tennis, Long>{
    
}
