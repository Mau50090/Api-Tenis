package com.pitufifantasticos.apitenis.service;

import java.util.Optional;
import com.pitufifantasticos.apitenis.entity.Tennis;
import com.pitufifantasticos.apitenis.repository.TennisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TennisServiceImpl implements TennisService{

    @Autowired
    private TennisRepository tennisRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Tennis> fundAll() {
        // TODO Auto-generated method stub
        return tennisRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Tennis> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return tennisRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tennis> findById(Long id) {
        // TODO Auto-generated method stub
        return tennisRepository.findById(id);
    }

    @Override
    public Tennis save(Tennis tennis) {
        // TODO Auto-generated method stub
        return tennisRepository.save(tennis);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        tennisRepository.deleteById(id);
    }
}
